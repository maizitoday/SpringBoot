package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.TestLoginDao;
import com.example.demo.pojo.TestLogin;

/**
 * @author yubo
 * @version V2.0
 * @Description:             都支持Spring事务，即回滚时Cache的数据也会被移除
 *
 *                           需要记住的一点， 缓存的注解添加，都是方法执行完成后，在更新缓存的。
 *                           所以下面的查询， 查询完后，会存到缓存中，而下面的更新和删除， 也是需要执行完数据库后，然后
 *                           在去更新缓存的数据。
 *
 *                           同时数据需要对应同一个key值。
 *
 *                           同时缓存这个东西断开数据库或者redis后，就只能对接查询这个操作了
 *                           只有查询的这个操作才是走的缓存。
 *
 *
 * @date 2018/7/10 下午10:01
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class TestLoginService {

    @Autowired
    private TestLoginDao testLoginDao;

    /***
     * @Cacheable 标注的方法前先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；若没有数据，执行该方法并将方法返回值放进缓存。
     *            参数： value缓存名、 key缓存键值、 condition满足缓存条件、unless否决缓存条件
     * @return
     */
    @Cacheable(value = "testLoginData",key = "'maizi'")
    public TestLogin queryById(){

        return testLoginDao.queryById(1);
    }

    /***
     * @CachePut
              和 @Cacheable 类似，但会把方法的返回值放入缓存中, 主要用于数据新增和修改方法。
     * @return
     */
    @CachePut(value = "testLoginData",key = "'maizi'")
    public TestLogin updateById()
    {
        testLoginDao.updateById(1);
        TestLogin testLogin = new TestLogin();
        testLogin.setId(1);
        return testLogin;
    }

    /***
     * @CacheEvict
    方法执行成功后会从缓存中移除相应数据。
    参数： value缓存名、 key缓存键值、 condition满足缓存条件、 unless否决缓存条件、 allEntries是否移除所有数据（设置为true时会移除所有缓存）
     * @return
     */
    @CacheEvict(value = "testLoginData",key = "'maizi'")
    public int delById()
    {
        return testLoginDao.delById(1);
    }


}
