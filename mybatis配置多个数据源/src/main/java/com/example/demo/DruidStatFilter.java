package com.example.demo;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/16 下午10:58
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@WebFilter(filterName = "DruidStatFilter", urlPatterns = "/*", initParams = {
		// 忽略资源
		@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter extends WebStatFilter {
}
