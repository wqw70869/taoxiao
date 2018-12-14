package controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.ordermaster;
import mapper.OrdermasterMapper;


@RestController 
@RequestMapping("/android")  
public class OrdermasterController {
	@Autowired
	private OrdermasterMapper orderm;
	@RequestMapping("/getorderINF1")
	public List<ordermaster> select(String orderid){
		return orderm.select(orderid);
	}
	@RequestMapping("/getorderINF2")
	public List<ordermaster> select1(String buyid){
		return orderm.select1(buyid);
	}
	@RequestMapping("/addordermaster")
	public String addorder( String orderid,int status ,String buyid,String buyname,String sellid, Date createTime,String address)
	{
		if(orderm.insert(orderid,status,buyid,buyname,sellid,createTime,address))
			return "生成订单成功";
		else
			return "生成订单失败";
	}
    @RequestMapping("/deleteordermaster")
     //删除信息
	public String delete(String orderid){
		if(orderm.delete(orderid))
			return "删除订单成功";
		else
			return"删除订单失败";
    }
    
    @RequestMapping("/updateordermaster")//更新信息
	public String update(String orderid,int  status,Date createTime,String address){
		if( orderm.update(orderid,status,createTime,address))
			return "更新成功";
		else
			return "更新失败";
	}
}
