package controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.orderDetail;
import mapper.OrderDetailMapper;


@RestController 
@RequestMapping("/android")  
public class OrderDetailController {
	@Autowired
	private OrderDetailMapper orderdm;
	@RequestMapping("/getorderdetailINF1")//根据订单号获得订单详细信息
	public List<orderDetail> select(String orderid){
		return orderdm.select(orderid);
	}
	@RequestMapping("/getorderdetailINF2")//根据详细订单号获得订单详细信息
	public List<orderDetail> select1(String detailid){
		return orderdm.select1(detailid);
	}
	@RequestMapping("/addorderdetail")//添加详细订单
	public String addorder( String detailid,String orderid ,String itemid,String itemname,double totailprice)
	{
		if(orderdm.insert(detailid,orderid,itemid,itemname,totailprice))
			return "生成详细订单成功";
		else
			return "生成详细订单失败";
	}
	@RequestMapping("/deleteorder")
    //删除信息根据orderid
	public String delete(String orderid){
		if(orderdm.delete(orderid))
			return "删除订单成功";
		else
			return"删除订单失败";
   }
	@RequestMapping("/deleteorder1")
    //删除信息根据detailid
	public String delete1(String detailid){
		if(orderdm.delete1(detailid))
			return "删除订单成功";
		else
			return"删除订单失败";
   }
   @RequestMapping("/updateorder")//更新信息根据orderid
		public String update(String orderid,  String itemid,String itemname,double totailprice){
			if( orderdm.update(orderid,itemid,itemname,totailprice))
				return "更新成功";
			else
				return "更新失败";
}
   @RequestMapping("/updateorder1")//更新信息根据detailid
	public String update1(String detailid,  String itemid,String itemname,double totailprice){
		if( orderdm.update1(detailid,itemid,itemname,totailprice))
			return "更新成功";
		else
			return "更新失败";
}
	
}