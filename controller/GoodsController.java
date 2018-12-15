package com.example.taoxiao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//设置访问的接口的文件

@RestController 
@RequestMapping("/goods")  
public class GoodsController {

		@Autowired
		private GoodsMapper goodsm;
		
		@RequestMapping("/newgoods")
		public String addgoods(String goodsname,String sellid, String kinds,double price, String description, Date uptime){
			if(goodsm.insert(goodsname,sellid,kinds,price,description,uptime))
				return "商品创建成功";
			else
				return "商品创建失败";
		}
		@RequestMapping("/getgoodsINF")
		public List<sellgoods> select2(String id){//根据商品ID查找商品
			return goodsm.select2(id);
		}
		@RequestMapping("/getgoodsINFBytype")//根据类型返回商品信息
		public List<sellgoods> select3(String type){
			return goodsm.select3(type);
		}
		@RequestMapping("/delete")//删除商品信息
			public String delete(String id){
				if(goodsm.delete(id))
					return "删除成功";
				else
					return"删除失败";
		}
		@RequestMapping("/update")//更新商品信息
				public String update(String goodsid,String goodsname,String sellid,String kinds,double price,String description,Date uptime){
					if( goodsm.update(goodsid,goodsname,sellid,kinds,price,description,uptime))
						return "更新成功";
					else
						return "更新失败";
		}
		@RequestMapping("/Sreachsell")//搜索买卖的商品
				public List<sellgoods> Searchsell(String Text)
		{
			return goodsm.Searchesll(Text);
		}
	@RequestMapping("/Sreachrent")//搜索租借的商品
	public List<rentgoods> Searchrent(String Text)
	{
		return goodsm.Searchrent(Text);
	}

}
