package com.example.taoxiao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//设置访问的接口的文件

@RestController 
@RequestMapping("/goods")  
public class GoodsController {

		@Autowired
		private GoodsMapper goodsm;
		
		@RequestMapping("/newgoods")//发布商品
		public String addgoods(String goodsname,String sellid, String kinds,double price, String description, Date uptime){
			JSONObject result = new JSONObject();
			if( goodsm.insert(goodsname,sellid,kinds,price,description,uptime))
				result.put("status", "true");
			else
				result.put("status", "false");
			return result.toJSONString();
		}
	@RequestMapping("/newgoods")
	public String insertphoto(Integer goodid)
	{
		JSONObject result = new JSONObject();
		String name=goodid+".png";
		if(	goodsm.insertphoto(goodid,name)) {
			result.put("status", "true");
		}
		else {
			result.put("status", "false");
		}
		return result.toJSONString();
	}
	@RequestMapping("/goodshome")
	public String home()
	{
		String title;

		JSONObject result = new JSONObject();
		List<sellgoods> str=goodsm.select1();
		for(int i = 0; i<str.size(); i++) {
			str.get(i).getGoodname();
		}
		result.put("home",str);
		return result.toJSONString();
	}
		@RequestMapping("/getgoodsINF")
		public String select2(Integer id){//根据商品ID查找商品
			JSONArray json = new JSONArray();
			List<sellgoods> str=goodsm.select2(id);
			for(sellgoods t:str) {
				JSONObject jo = new JSONObject();
				jo.put("goodid", str.get(0).getGoodid());
				jo.put("goodname", str.get(0).getGoodname());
				jo.put("price", str.get(0).getPrice());
				jo.put("description", str.get(0).getDescription());
				jo.put("userid", str.get(0).getSellid());
				jo.put("uptime",str.get(0).getUptime());
				jo.put("type",str.get(0).getType());
				json.add(jo);
			}
			return json.toJSONString();

		}
		@RequestMapping("/delete")//删除商品信息
			public String delete(Integer id){
			JSONObject result = new JSONObject();
			if( goodsm.delete(id))
				result.put("status", "true");
			else
				result.put("status", "false");
			return result.toJSONString();
		}
		@RequestMapping("/update")//更新商品信息
				public String update(String goodsid,String goodsname,String sellid,String kinds,double price,String description,Date uptime){
			JSONObject result = new JSONObject();
			if( goodsm.update(goodsid,goodsname,sellid,kinds,price,description,uptime))
				result.put("status", "true");
			else
				result.put("status", "false");
			return result.toJSONString();
		}
		@RequestMapping("/Sreachsell")//搜索买卖的商品
				public String Searchsell(String Text)
		{

			List<sellgoods> str=goodsm.Searchsell(Text);
			JSONArray json = new JSONArray();
			for(sellgoods t:str) {
				JSONObject jo = new JSONObject();
				jo.put("goodid", str.get(0).getGoodid());
				jo.put("goodname", str.get(0).getGoodname());
				jo.put("price", str.get(0).getPrice());
				jo.put("description", str.get(0).getDescription());
				jo.put("userid", str.get(0).getSellid());
				jo.put("uptime",str.get(0).getUptime());
				jo.put("type",str.get(0).getType());
				json.add(jo);
			}
			return json.toJSONString();
		}
		public String Searchsell(String type,String Text)
		{

			List<sellgoods> str=goodsm.Searchsell(type,Text);
			JSONArray json = new JSONArray();
			for(sellgoods t:str) {
				JSONObject jo = new JSONObject();
				jo.put("goodid", str.get(0).getGoodid());
				jo.put("goodname", str.get(0).getGoodname());
				jo.put("price", str.get(0).getPrice());
				jo.put("description", str.get(0).getDescription());
				jo.put("userid", str.get(0).getSellid());
				jo.put("uptime",str.get(0).getUptime());
				jo.put("type",str.get(0).getType());
				json.add(jo);
			}
			return json.toJSONString();
		}
	@RequestMapping("/Sreachrent")//搜索租借的商品
	public String Searchrent(String Text)
	{

		List<rentgoods> str=goodsm.Searchrent(Text);
		JSONArray json = new JSONArray();
		for(rentgoods t:str) {
			JSONObject jo = new JSONObject();
			jo.put("goodid", str.get(0).getGoodid());
			jo.put("goodname", str.get(0).getGoodname());
			jo.put("description", str.get(0).getdescription());
			json.add(jo);
		}
		return json.toJSONString();
	}
	@RequestMapping("/Mysellgoods")//查看自己的发布
	public String Mysellgoods(Integer sellid)
	{

		List<sellgoods> str=goodsm.Mysellgoods(sellid);
		JSONArray json = new JSONArray();
		for(sellgoods t:str) {
			JSONObject jo = new JSONObject();
			jo.put("goodid", str.get(0).getGoodid());
			jo.put("goodname", str.get(0).getGoodname());
			jo.put("price", str.get(0).getPrice());
			jo.put("description", str.get(0).getDescription());
			jo.put("userid", str.get(0).getSellid());
			jo.put("uptime",str.get(0).getUptime());
			jo.put("type",str.get(0).getType());
			json.add(jo);
		}
		return json.toJSONString();
	}

}
