package maizi.change.aop;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import maizi.change.ioc.BeanHelper;
import maizi.change.ioc.ClassHelper;
import maizi.change.ioc.Service;
import maizi.change.transaction.TransactionProxy;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/16 下午3:04
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class AopHelper {
	static {
		try {
			// 找到所有的代理， 找到带有注释的类对应的代理列表，然后反射执行业务代码
			Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
			for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
				Class<?> targetClass = targetEntry.getKey();
				List<Proxy> proxyList = targetEntry.getValue();
				Object proxy = ProxyManager.createProxy(targetClass, proxyList);
				BeanHelper.setBean(targetClass, proxy);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("  aop 初始化失败   ");
		}
	}

	/***
	 * 获取所有Aspect注解的类
	 * 
	 * @param aspect
	 * @return
	 * @throws Exception
	 */
	private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
		Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
		Class<? extends Annotation> annotation = aspect.value();
		if (annotation != null && !annotation.equals(Aspect.class)) {
			targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
		}
		return targetClassSet;
	}

	private static Map<Class<?>,Set<Class<?>>> createProxyMap() throws Exception
	{
		Map<Class<?>,Set<Class<?>>> proxyMap = new HashMap<Class<?>,Set<Class<?>>>();
	    addAspectProxy(proxyMap);
	    addTransactionProxy(proxyMap);
        return proxyMap;
	}



	/***
	 * 代理类和目标类之间的映射关系
	 * 
	 * @return
	 * @throws Exception
	 */
	private static Map<Class<?>, Set<Class<?>>> addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
//		Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
		// 获取所有切面代理类
		Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
		for (Class<?> proxyClass : proxyClassSet) {
			if (proxyClass.isAnnotationPresent(Aspect.class)) {
				Aspect aspect = proxyClass.getAnnotation(Aspect.class);
				// 获取有这个切面注解的所有类
				Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
				// 每个代理类， 代理所有目标类，代理类和目标类是一对多的情况
				proxyMap.put(proxyClass, targetClassSet);
			}
		}
		return proxyMap;
	}


	private static void addTransactionProxy(Map<Class<?>,Set<Class<?>>> proxyMap)
	{
		Set<Class<?>> serviceClassSet = ClassHelper.getClassSetByAnnotation(Service.class);
        proxyMap.put(TransactionProxy.class,serviceClassSet);

	}














	/***
	 * 一个Controller或者类，一共有多少代理
	 * @param proxyMap
	 * @return
	 * @throws Exception
	 */
	public static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
		for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
			Class<?> proxyClass = proxyEntry.getKey();
			Set<Class<?>> targetClassSet = proxyEntry.getValue();
			for (Class<?> targetClass : targetClassSet) {
				Proxy proxy = (Proxy) proxyClass.newInstance();
				if (targetMap.containsKey(targetClass)) {
					targetMap.get(targetClass).add(proxy);
				} else {
					List<Proxy> proxyList = new ArrayList<Proxy>();
					proxyList.add(proxy);
					targetMap.put(targetClass, proxyList);
				}
			}
		}
		return targetMap;
	}
}
