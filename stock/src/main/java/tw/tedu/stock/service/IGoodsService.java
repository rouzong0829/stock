package tw.tedu.stock.service;

import java.util.List;

import tw.tedu.stock.vo.IndexGoodsVO;

/**
 * 商品數據的業務層接口
 */
public interface IGoodsService {
	
	/**
	 * 根據量獲取商品數據列表
	 * @param count 獲取的商品數量
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	List<IndexGoodsVO> getByVolume(Integer count, Integer desc);
	
	/**
	 * 根據股票代號獲取商品數據列表
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	List<IndexGoodsVO> getByCode(Integer desc);
	
	/**
	 * 根據id獲取商品詳情
	 * @param id 商品id
	 * @return 商品詳情，若沒有則返回null
	 */
	IndexGoodsVO getById(Integer id);
	
}
