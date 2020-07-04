package tw.tedu.stock.configurer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tw.tedu.stock.interceptor.LoginInterceptor;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 黑名單
		List<String> pathPatterns = new ArrayList<>();
		pathPatterns.add("/user/**");
		pathPatterns.add("/web/**");
		pathPatterns.add("/address/**");
		pathPatterns.add("/favorite/**");
		pathPatterns.add("/order/**");
		
		// 白名單
		List<String> excludePathPatterns = new ArrayList<>();
		excludePathPatterns.add("/user/reg");
		excludePathPatterns.add("/user/login");
		excludePathPatterns.add("/web/register.html");
		excludePathPatterns.add("/web/login.html");
		excludePathPatterns.add("/web/index.html");
		excludePathPatterns.add("/web/product.html");
		excludePathPatterns.add("/web/goods.html");
		excludePathPatterns.add("/web/construction.html");		
		
		// 註冊
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns(pathPatterns)
		.excludePathPatterns(excludePathPatterns);
		
	}
	
	
	
}
