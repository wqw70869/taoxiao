package entity;

//订单详细类
public class orderDetail{
	private String detailid;
	private String orderid;
	 private String itemid;
	 private String itemname;
	 private double totailprice;
	public String getDetailid() {
		return detailid;
	}
	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getTotailprice() {
		return totailprice;
	}
	public void setTotailprice(double totailprice) {
		this.totailprice = totailprice;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	 
}
