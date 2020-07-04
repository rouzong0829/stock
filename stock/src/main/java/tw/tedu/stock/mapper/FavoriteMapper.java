package tw.tedu.stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.vo.FavoriteVO;

/**
 * 商品收藏的持久層接口
 */
public interface FavoriteMapper {
	
	/**
	 * 增加收藏數據
	 * @param favorite 收藏數據
	 * @return 受影響行數
	 */
	Integer addnew(Favorite favorite);
	
	/**
	 * 根據用戶id與商品id刪除收藏數據
	 * @param uid 用戶id
	 * @param gid 商品id
	 * @return 受影響行數
	 */
	Integer deleteByUidAndGid(@Param("uid")Integer uid, @Param("gid")Integer gid);
	
	/**
	 * 根據用戶id與收藏id刪除收藏數據
	 * @param uid 用戶id
	 * @param id 收藏id
	 * @return 受影響行數
	 */
	Integer deleteByUidAndId(@Param("uid")Integer uid, @Param("id")Integer id);
	
	/**
	 * 根據用戶id與商品id查詢收藏數據
	 * @param uid 用戶id
	 * @param gid 商品id
	 * @return 匹配的收藏數據，若沒有則返回null
	 */
	Favorite findByUidAndGid(@Param("uid")Integer uid, @Param("gid")Integer gid);
	
	/**
	 * 根據用戶id與收藏id查詢收藏數據
	 * @param uid 用戶id
	 * @param id 收藏id
	 * @return 匹配的收藏數據，若沒有則返回null
	 */
	Favorite findByUidAndId(@Param("uid")Integer uid, @Param("id")Integer id);
	
	/**
	 * 根據用戶id查詢該用戶的收藏列表
	 * @param uid 用戶id
	 * @return 該用戶的收藏數據列表
	 */
	List<FavoriteVO> findByUid(Integer uid);
	
}
