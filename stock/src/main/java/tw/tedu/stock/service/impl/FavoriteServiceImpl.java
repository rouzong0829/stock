package tw.tedu.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.mapper.FavoriteMapper;
import tw.tedu.stock.service.IFavoriteService;
import tw.tedu.stock.service.exception.DeleteException;
import tw.tedu.stock.service.exception.FavoriteNotFoundException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.vo.FavoriteVO;
/**
 * 收藏數據的實現類
 */
@Service
public class FavoriteServiceImpl implements IFavoriteService {
	
	@Autowired
	private FavoriteMapper favoriteMapper;

	@Override
	@Transactional
	public void addToFavorite(String username, Favorite favorite) throws InsertException, DeleteException {
		// 根據參數查詢數據
		Favorite data = findByUidAndGid(favorite.getUid(), favorite.getGid());
		// 判斷是否為null
		if(data == null){
			Date now = new Date();
			favorite.setCreatedUser(username);
			favorite.setCreatedTime(now);
			favorite.setModifiedUser(username);
			favorite.setModifiedTime(now);
			// 執行添加
			addnew(favorite);
		}else{
			// 執行刪除
			deleteByUidAndGid(favorite.getUid(), favorite.getGid());
		}
	}
	
	@Override
	public void deleteFavorite(Integer uid, Integer id) throws DeleteException, FavoriteNotFoundException {
		Favorite data = findByUidAndId(uid, id);
		if(data == null){
			throw new FavoriteNotFoundException("刪除數據失敗!該數據不存在!");
		}
		deleteByUidAndId(uid, id);
	}
	
	@Override
	public List<FavoriteVO> getByUid(Integer uid) {
		return findByUid(uid);
	}
	
	@Override
	public Favorite getByUidAndGid(Integer uid, Integer gid) {
		return findByUidAndGid(uid, gid);
	}
	
	/**
	 * 增加收藏數據
	 * @param favorite 收藏數據
	 */
	private void addnew(Favorite favorite){
		Integer rows = favoriteMapper.addnew(favorite);
		if(rows != 1){
			throw new InsertException("添加收藏時出現未知異常!");
		}
	}
	
	/**
	 * 根據用戶id與商品id刪除收藏數據
	 * @param uid 用戶id
	 * @param gid 商品id
	 */
	private void deleteByUidAndGid(Integer uid, Integer gid){
		Integer rows = favoriteMapper.deleteByUidAndGid(uid, gid);
		if(rows != 1){
			throw new DeleteException("刪除收藏時出現未知異常!");
		}
	}
	
	/**
	 * 根據用戶id與收藏id刪除收藏數據
	 * @param uid 用戶id
	 * @param id 收藏id
	 * @return 受影響行數
	 */
	private void deleteByUidAndId(Integer uid, Integer id){
		Integer rows = favoriteMapper.deleteByUidAndId(uid, id);
		if(rows != 1){
			throw new DeleteException("刪除收藏時出現未知異常!");
		}
	}
	
	/**
	 * 根據用戶id與商品id查詢收藏數據
	 * @param uid 用戶id
	 * @param gid 商品id
	 * @return 匹配的收藏數據，若沒有則返回null
	 */
	private Favorite findByUidAndGid(Integer uid, Integer gid){
		return favoriteMapper.findByUidAndGid(uid, gid);
	}
	
	/**
	 * 根據用戶id與收藏id查詢收藏數據
	 * @param uid 用戶id
	 * @param id 收藏id
	 * @return 匹配的收藏數據，若沒有則返回null
	 */
	private Favorite findByUidAndId(Integer uid, Integer id){
		return favoriteMapper.findByUidAndId(uid, id);
	}
	
	/**
	 * 根據用戶id查詢該用戶的收藏列表
	 * @param uid 用戶id
	 * @return 該用戶的收藏數據列表
	 */
	private List<FavoriteVO> findByUid(Integer uid){
		return favoriteMapper.findByUid(uid);
	}
	
}
