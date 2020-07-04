package tw.tedu.stock.entity;
/**
 * 訂單商品實體類
 */
public class OrderItem extends BaseEntity {
	
	private static final long serialVersionUID = 7639464304890850302L;
	
	private Integer id;
	private Integer oid;
	private Integer goodsId;
	private String goodsCode;
	private String goodsStock;
	private Integer goodsCount;
	private Double goodsPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(String goodsStock) {
		this.goodsStock = goodsStock;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", oid=" + oid + ", goodsId=" + goodsId + ", goodsCode=" + goodsCode
				+ ", goodsStock=" + goodsStock + ", goodsCount=" + goodsCount + ", goodsPrice=" + goodsPrice + "]";
	}
	
	
}
