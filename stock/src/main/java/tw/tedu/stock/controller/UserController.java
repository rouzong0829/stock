package tw.tedu.stock.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.tedu.stock.controller.exception.FileEmptyException;
import tw.tedu.stock.controller.exception.FileSizeOutOfLimitException;
import tw.tedu.stock.controller.exception.FileTypeNotSupportException;
import tw.tedu.stock.controller.exception.FileUploadException;
import tw.tedu.stock.entity.User;
import tw.tedu.stock.service.IUserService;
import tw.tedu.stock.util.ResponseResult;

/**
 * 用戶的控制器類
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	
	/**
	 * 上傳文件夾的名稱
	 */
	private static final String UPLOAD_DIR_NAME = "upload";
	
	/**
	 * 上傳文件的最大大小
	 */
	private static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
	
	/**
	 * 允許上傳的文件類型
	 */
	private static final List<String> FILE_CONTENT_TYPES = new ArrayList<>();
	
	/**
	 * 初始化允許上傳的文件類型的集合
	 */
	static{
		FILE_CONTENT_TYPES.add("image/jpeg");
		FILE_CONTENT_TYPES.add("image/png");
	}
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/reg")
	public ResponseResult<Void> handleReg(User user){
		userService.reg(user);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@PostMapping("/login")
	public ResponseResult<User> handleLogin(
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			HttpSession session){
		User user = userService.login(username, password);
		// 將相關信息存入Session
		session.setAttribute("uid", user.getId());
		session.setAttribute("username", user.getUsername());
		return new ResponseResult<User>(SUCCESS, user);
	}
	
	@PostMapping("/logout")
	public ResponseResult<Void> handleLogout(HttpSession session){
		session.removeAttribute("uid");
		session.removeAttribute("username");
		session.invalidate();
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@PostMapping("/password")
	public ResponseResult<Void> changePassword(
			@RequestParam("old_password")String oldPassword,
			@RequestParam("new_password")String newPassword,
			HttpSession session){
		// 獲取當前登入的用戶id
		Integer uid = getUidFromSession(session);
		userService.changePassword(uid, oldPassword, newPassword);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@RequestMapping("/info")
	public ResponseResult<User> getInfo(HttpSession session){
		Integer uid = getUidFromSession(session);
		User user = userService.getById(uid);
		return new ResponseResult<User>(SUCCESS, user);
	}
	
	@PostMapping("/change_info")
	public ResponseResult<Void> changeInfo(User user, HttpSession session){
		Integer id = getUidFromSession(session);
		// 將id封裝到參數user中，因為user是用戶提交的數據，並不包含id
		user.setId(id);
		userService.changeInfo(user);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@PostMapping("/upload")
	public ResponseResult<String> handleUpload(HttpSession session, @RequestParam("file")MultipartFile file){
		// 檢查是否存在上傳文件
		if(file.isEmpty()){
			throw new FileEmptyException("上傳失敗!沒有選擇上傳的文件或文件為空!");
		}
		// 檢查文件大小
		if(file.getSize() > FILE_MAX_SIZE){
			throw new FileSizeOutOfLimitException("上傳失敗!上傳的文件大小超出限制!");
		}
		// 檢查文件類型
		if(!FILE_CONTENT_TYPES.contains(file.getContentType())){
			throw new FileTypeNotSupportException("上傳失敗!上傳的文件類型錯誤!");
		}
		// 確認上傳文件夾的路徑
		String parentPath = session.getServletContext().getRealPath(UPLOAD_DIR_NAME);
		File parent = new File(parentPath);
		if(!parent.exists()){
			parent.mkdirs();
		}
		// 確認文件名
		String originalFileName = file.getOriginalFilename();
		int beginIndex = originalFileName.lastIndexOf(".");
		String suffix = originalFileName.substring(beginIndex);
		String fileName = System.currentTimeMillis() + "" + (new Random().nextInt(90000000) + 10000000) + suffix;
		File dest = new File(parent, fileName);
		// 執行保存
		try {
			file.transferTo(dest);
			System.err.println("上傳完成!");
		} catch (IllegalStateException e) {
			throw new FileUploadException("上傳失敗!請稍後重試!");
		} catch (IOException e) {
			throw new FileUploadException("上傳失敗!請稍後重試!");
		}
		
		// 獲取當前用戶id
		Integer uid = getUidFromSession(session);
		// 更新頭像數據
		String avatar = "/" + UPLOAD_DIR_NAME + "/" + fileName;
		userService.changeAvatar(uid, avatar);
		
		// 返回
		ResponseResult<String> rr = new ResponseResult<>();
		rr.setState(SUCCESS);
		rr.setData(avatar);
		return rr;
	}
	
}
