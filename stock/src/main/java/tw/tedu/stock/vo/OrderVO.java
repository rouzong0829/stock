package tw.tedu.stock.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 訂單數據的Value Object類
 */
public class OrderVO implements Serializable {
	
	private static final long serialVersionUID = -8883071240922822721L;
	
	private Integer id;
	private Integer uid;
	private String recvName;
	private Long pay;
	private Integer buySell;
	private Date orderTime;
	private Integer status;
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public Long getPay() {
		return pay;
	}
	public void setPay(Long pay) {
		this.pay = pay;
	}
	public Integer getBuySell() {
		return buySell;
	}
	public void setBuySell(Integer buySell) {
		this.buySell = buySell;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		return "OrderVO [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", pay=" + pay + ", buySell=" + buySell
				+ ", orderTime=" + orderTime + ", status=" + status + ", oid=" + oid + ", goodsId=" + goodsId
				+ ", goodsCode=" + goodsCode + ", goodsStock=" + goodsStock + ", goodsCount=" + goodsCount
				+ ", goodsPrice=" + goodsPrice + "]";
	}
	
}
