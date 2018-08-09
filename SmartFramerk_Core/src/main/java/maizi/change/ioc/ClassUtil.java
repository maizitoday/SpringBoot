package maizi.change.ioc;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.LoggerFactory;

/**
 * @author yubo
 * @version V2.0
 * @Description:  类操作工具类，获取某注解类，接口类等
 * @date 2018/8/8 下午4:27
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class ClassUtil {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     * @return
     */
    public static ClassLoader getClassLoader()
    {
       return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String className,boolean isInitialized)
    {
        Class<?> cls;
        try {
           cls = Class.forName(className,isInitialized,getClassLoader());
        }catch (Exception e){
            LOGGER.error("类加载失败");
            throw new RuntimeException(e);
        }
        return cls;
    }

    /**
     * 获取指定包名下的所有类
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName)
    {
       Set<Class<?>> classSet = new HashSet<Class<?>>();
       try {
           Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".","/"));
           while (urls.hasMoreElements())
           {
               URL url = urls.nextElement();
               if (url != null)
               {
                   String protocol = url.getProtocol();
                   if (protocol.equals("file"))
                   {
                       String packagePath = url.getPath().replaceAll("%20","");
                       addClass(classSet,packagePath,packageName);
                   }else if(protocol.equals("jar"))
                   {
                       JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                       if (jarURLConnection != null)
                       {
                           JarFile jarFile = jarURLConnection.getJarFile();
                           if (jarFile != null)
                           {
                               Enumeration<JarEntry> jarEntrys = jarFile.entries();
                               while (jarEntrys.hasMoreElements())
                               {
                                   JarEntry jarEntry = jarEntrys.nextElement();
                                   String jarEntryName = jarEntry.getName();
                                   if (jarEntryName.endsWith(".class"))
                                   {
                                       String className = jarEntryName.substring(0,jarEntryName.lastIndexOf(".")).replaceAll("/",".");
                                       doAddClass(classSet,className);
                                   }

                               }
                           }
                       }
                   }
               }
           }
       }catch (Exception e){
           LOGGER.error("获取所有class集合失败");
           throw new RuntimeException(e);
       }
       return classSet;
    }


    /***
     * 加载所有的class文件
     * @param classSet
     * @param packagePath
     * @param packageName
     */
    private static void addClass(Set<Class<?>> classSet,String packagePath,String packageName)
    {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });


        for (File file : files)
        {
            String fileName = file.getName();
            if (file.isFile())
            {
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if (className != null)
                {
                    className = packageName + "." + className;
                }
                doAddClass(classSet,className);
            }else{
                String subPackagePath = fileName;
                if (packagePath != null)
                {
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if (packageName != null)
                {
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }

    /***
     *
     * @param classSet
     * @param className
     */
    private static void doAddClass(Set<Class<?>> classSet,String className)
    {
        Class<?> cls = loadClass(className,false);
        classSet.add(cls);
    }



}
