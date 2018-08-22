package mapper;

import java.util.List;

import lombok.Data;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午1:55
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
public class MapperBean {
    private String interfaceName; // 接口名
    private List<Function> list; // 接口下所有方法
}
