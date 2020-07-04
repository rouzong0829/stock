package tw.tedu.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.tedu.stock.mapper.GoodsMapper;
import tw.tedu.stock.service.IGoodsService;
import tw.tedu.stock.vo.IndexGoodsVO;

/**
 * 商品數據的實現類
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<IndexGoodsVO> getByVolume(Integer count, Integer desc) {
		return findByVolume(count, desc);
	}
	
	@Override
	public List<IndexGoodsVO> getByCode(Integer desc) {
		return findByCode(desc);
	}
	
	@Override
	public IndexGoodsVO getById(Integer id) {
		return findById(id);
	}
	
	/**
	 * 根據量查詢商品數據列表
	 * @param count 獲取的商品數量
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	private List<IndexGoodsVO> findByVolume(Integer count, Integer desc){
		return goodsMapper.findByVolume(count, desc);
	}
	
	/**
	 * 根據股票代號查詢商品數據列表
	 * @param desc 排序 0-asc, 1-desc
	 * @return 商品數據列表
	 */
	private List<IndexGoodsVO> findByCode(Integer desc){
		return goodsMapper.findByCode(desc);
	}
	
	/**
	 * 根據id查詢商品詳情
	 * @param id 商品id
	 * @return 商品詳情，若沒有則返回null
	 */
	private IndexGoodsVO findById(Integer id){
		return goodsMapper.findById(id);
	}
	
}
