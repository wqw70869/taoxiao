package entity;

import java.util.Date;
//订单类
public class ordermaster {
	private String orderid;
	private int status;//订单状态  0 未支付  1已支付
	private String buyid;
	private String buyname;
	private String sellid;
	private Date createTime;;
	private String address;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBuyid() {
		return buyid;
	}
	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}
	public String getBuyname() {
		return buyname;
	}
	public void setBuyname(String buyname) {
		this.buyname = buyname;
	}
	public String getSellid() {
		return sellid;
	}
	public void setSellid(String sellid) {
		this.sellid = sellid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}

