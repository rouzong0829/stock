package tw.tedu.stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.tedu.stock.vo.IndexGoodsVO;

/**
 * 商品數據的持久層接口
 */
public interface GoodsMapper {
	
	/**
	 * 根據量查詢商品數據列表
	 * @param count 獲取的商品數量
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	List<IndexGoodsVO> findByVolume(@Param("count")Integer count, @Param("desc")Integer desc);
	
	/**
	 * 根據股票代號查詢商品數據列表
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	List<IndexGoodsVO> findByCode(Integer desc);
	
	/**
	 * 根據id查詢商品詳情
	 * @param id 商品id
	 * @return 商品詳情，若沒有則返回null
	 */
	IndexGoodsVO findById(Integer id);
	
}
