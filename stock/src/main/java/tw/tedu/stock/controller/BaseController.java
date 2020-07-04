package tw.tedu.stock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.tedu.stock.controller.exception.CountEmptyException;
import tw.tedu.stock.controller.exception.CountException;
import tw.tedu.stock.controller.exception.FileEmptyException;
import tw.tedu.stock.controller.exception.FileSizeOutOfLimitException;
import tw.tedu.stock.controller.exception.FileTypeNotSupportException;
import tw.tedu.stock.controller.exception.FileUploadException;
import tw.tedu.stock.controller.exception.RequestException;
import tw.tedu.stock.service.exception.AccessDeniedException;
import tw.tedu.stock.service.exception.AddressNotFoundException;
import tw.tedu.stock.service.exception.DataEmptyException;
import tw.tedu.stock.service.exception.DataFormatException;
import tw.tedu.stock.service.exception.DeleteException;
import tw.tedu.stock.service.exception.DuplicateKeyException;
import tw.tedu.stock.service.exception.FavoriteNotFoundException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.PasswordNotMatchException;
import tw.tedu.stock.service.exception.ServiceException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.service.exception.UserNotFoundException;
import tw.tedu.stock.util.ResponseResult;

/**
 * 當前所有控制器類的基類
 */
public class BaseController {
	
	/**
	 * 正確響應時的代號
	 */
	public static final Integer SUCCESS = 200;
	
	@ExceptionHandler({ServiceException.class, RequestException.class})
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e){
		
		Integer state = null;
		
		if(e instanceof DuplicateKeyException){
			// 400-違反了Unique約束的異常
			state = 400;
		}else if(e instanceof UserNotFoundException){
			// 401-查詢不到用戶數據的異常
			state = 401;
		}else if(e instanceof PasswordNotMatchException){
			// 402-密碼不匹配的異常
			state = 402;
		}else if(e instanceof FavoriteNotFoundException){
			// 403-查詢不到收藏數據異常
			state = 403;
		}else if(e instanceof AddressNotFoundException){
			// 404-地址數據不存在
			state = 404;
		}else if(e instanceof AccessDeniedException){
			// 405-數據權限驗證不通過
			state = 405;
		}else if(e instanceof InsertException){
			// 500-插入數據異常
			state = 500;
		}else if(e instanceof UpdateException){
			// 501-更新數據異常
			state = 501;
		}else if(e instanceof DeleteException){
			// 502-刪除數據異常
			state = 502;
		}else if(e instanceof FileEmptyException){
			// 600-上傳文件為空異常
			state = 600;
		}else if(e instanceof FileSizeOutOfLimitException){
			// 601-上傳文件大小超出限制的異常
			state = 601;
		}else if(e instanceof FileTypeNotSupportException){
			// 602-上傳文件類型不支持的異常
			state = 602;
		}else if(e instanceof CountEmptyException){
			// 603-數量為空的異常
			state = 603;
		}else if(e instanceof DataFormatException){
			// 604-數據格式異常
			state = 604;
		}else if(e instanceof DataEmptyException){
			// 605-數據為空異常
			state = 605;
		}else if(e instanceof CountException){
			// 606-數量異常
			state = 606;
		}else if(e instanceof FileUploadException){
			// 610-文件上傳異常
			state = 610;
		}
		return new ResponseResult<> (state, e);
	}
	
	/**
	 * 從Session中獲取uid
	 * @param session HttpSession對象
	 * @return 當前用戶登入的id
	 */
	protected Integer getUidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
}
