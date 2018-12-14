package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import mapper.CollectionMapper;
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
}
