package mapper;

import lombok.Data;
import lombok.ToString;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午1:56
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
@ToString
public class Function {
    private String sqlType;
    private String funcName;
    private String sql;
    private Object resultType;
    private String parameterType;


}
