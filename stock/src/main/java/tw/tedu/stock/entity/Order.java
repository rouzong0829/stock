package tw.tedu.stock.entity;

import java.util.Date;
/**
 * 訂單實體類
 */
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 9077707856074912337L;
	
	private Integer id;
	private Integer uid;
	private String recvName;
	private String recvAddress;
	private Long pay;
	private Integer buySell;
	private Date orderTime;
	private Integer status;
	
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
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
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
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", recvAddress=" + recvAddress + ", pay="
				+ pay + ", buySell=" + buySell + ", orderTime=" + orderTime + ", status=" + status + "]";
	}
	
	
}
