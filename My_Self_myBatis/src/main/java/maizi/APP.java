package maizi;

import mapper.User;
import mapper.UserMapper;

/**
 * @author yubo
 * @version V2.0
 * @Description:            maven 打包自动会把xml文件放入到resource目录下，需要用maven的插件配置
 * @date 2018/8/21 下午3:35
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class APP {

    public static void main(String[] args){
        MySqlSession  sqlSession = new MySqlSession();
        // 纯接口调用方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println("  user:   "+user);
    }


}
