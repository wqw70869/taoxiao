package com.example.taoxiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
@RestController 
@RequestMapping("/user")
public class CollectionController {
	@Autowired
	private CollectionMapper cmapper;
	
	
	@RequestMapping("/newcollection")
	public String newcollection(){
		JSONObject result = new JSONObject();
		result.put("status", "true");//添加返回的字段
		result.put("status", "false");
		return result.toJSONString();
	}
	public boolean setcollection(String UserId,String GoodsId)
	{
		if( cmapper.setcollection(UserId,GoodsId,Uptime))
			return true;
		else
			return false;
	}
	public boolean delcollection(String UserId,String GoodsId)
	{
		if( cmapper.delcollection(UserId,GoodsId))
			return true;
		else
			return false;
	}

}
