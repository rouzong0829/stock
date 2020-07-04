package tw.tedu.stock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登入攔截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 獲取Session
		HttpSession session = request.getSession();
		// 判斷Session中是否存在uid
		if(session.getAttribute("uid") == null || !request.isRequestedSessionIdValid()){
			// 為null，沒有登入
			response.sendRedirect("../web/login.html");
			// 攔截
			return false;
		}else{
			// 非null，已經登入
			return true;
		}
	}
	
	
	
}
