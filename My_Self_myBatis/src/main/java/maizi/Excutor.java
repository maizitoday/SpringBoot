package maizi;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午3:14
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public interface Excutor {

    public <T> T query(String sql, Object parameter);

}
