package tw.tedu.stock.service;

import java.util.List;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.service.exception.DeleteException;
import tw.tedu.stock.service.exception.FavoriteNotFoundException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.vo.FavoriteVO;

/**
 * 收藏數據的業務層接口
 */
public interface IFavoriteService {
	
	/**
	 * 將商品添加到收藏
	 * @param username 當前操作的執行人
	 * @param favorite 收藏的數據
	 * @throws InsertException
	 */
	void addToFavorite(String username, Favorite favorite)throws InsertException, DeleteException;
	
	/**
	 * 根據用戶id與收藏id刪除收藏數據
	 * @param uid 用戶id
	 * @param id 收藏id
	 * @throws DeleteException
	 */
	void deleteFavorite(Integer uid, Integer id)throws DeleteException, FavoriteNotFoundException;
	
	/**
	 * 根據用戶id查詢該用戶的收藏列表
	 * @param uid 用戶id
	 * @return 該用戶的收藏列表
	 */
	List<FavoriteVO> getByUid(Integer uid);
	
	/**
	 * 根據用戶id與商品id查詢收藏數據
	 * @param uid 用戶id
	 * @param gid 商品id
	 * @return 匹配的收藏數據，若沒有則返回null
	 */
	Favorite getByUidAndGid(Integer uid, Integer gid);
	
}
