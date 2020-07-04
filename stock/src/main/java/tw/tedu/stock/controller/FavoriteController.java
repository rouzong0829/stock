package tw.tedu.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.service.IFavoriteService;
import tw.tedu.stock.util.ResponseResult;
import tw.tedu.stock.vo.FavoriteVO;

/**
 * 收藏的控制器類
 */
@RestController
@RequestMapping("/favorite")
public class FavoriteController extends BaseController {
	
	@Autowired
	private IFavoriteService favoriteService;
	
	@PostMapping("/add")
	public ResponseResult<Void> addToFavorite(HttpSession session, Favorite favorite){
		// 從session中獲取username與uid
		String username = session.getAttribute("username").toString();
		Integer uid = getUidFromSession(session);
		// 將uid封裝進favorite
		favorite.setUid(uid);
		// 執行業務方法
		favoriteService.addToFavorite(username, favorite);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseResult<Void> deleteFavorite(HttpSession session, @PathVariable("id")Integer id){
		Integer uid = getUidFromSession(session);
		favoriteService.deleteFavorite(uid, id);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@RequestMapping("/list")
	public ResponseResult<List<FavoriteVO>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<FavoriteVO> list = favoriteService.getByUid(uid);
		return new ResponseResult<List<FavoriteVO>>(SUCCESS, list);
	}
	
	@PostMapping("/exists/{id}")
	public ResponseResult<Favorite> checkExists(HttpSession session, @PathVariable("id")Integer id){
		Integer uid = getUidFromSession(session);
		Favorite favorite = favoriteService.getByUidAndGid(uid, id);
		return new ResponseResult<Favorite>(SUCCESS, favorite);
	}
	
}
