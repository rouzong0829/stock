package tw.tedu.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.tedu.stock.service.IGoodsService;
import tw.tedu.stock.util.ResponseResult;
import tw.tedu.stock.vo.IndexGoodsVO;

/**
 * 商品數據的控制器類
 */
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	
	@Autowired
	private IGoodsService goodsService;
	
	@GetMapping("/volume/{desc}")
	public ResponseResult<List<IndexGoodsVO>> getMostVolume(@PathVariable("desc")Integer desc){
		List<IndexGoodsVO> list = goodsService.getByVolume(5, desc);
		return new ResponseResult<List<IndexGoodsVO>>(SUCCESS, list);
	}
	
	@GetMapping("/code/{desc}")
	public ResponseResult<List<IndexGoodsVO>> getListByCode(@PathVariable("desc")Integer desc){
		List<IndexGoodsVO> list = goodsService.getByCode(desc);
		return new ResponseResult<List<IndexGoodsVO>>(SUCCESS, list);
	}
	
	@GetMapping("/details/{id}")
	public ResponseResult<IndexGoodsVO> getById(@PathVariable("id")Integer id){
		IndexGoodsVO indexGoodsVO = goodsService.getById(id);
		return new ResponseResult<IndexGoodsVO>(SUCCESS, indexGoodsVO);
	}
	
}
