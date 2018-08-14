package maizi.change.bean;
/**
 * @author yubo
 * @version V2.0
 * @Description: 封装表单参数
 * @date 2018/8/14 下午2:13
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class FormParam {
	private String fieldName;
	private Object fieldValue;

	public FormParam(String fieldName, Object fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}
