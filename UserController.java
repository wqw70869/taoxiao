package com.example.taoxiao;

import java.io.IOException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;



@RestController 
@RequestMapping("/user")
public class UserController {
	@Autowired
	private userMapper userm;
	
	@RequestMapping("/1")
	public user newuser(){
		user a=new user();
		return a;
	}
	
	@RequestMapping("/2")  
    public List<user> showuser(){  
        return userm.select1();
    }
	//http://172.24.11.85:8080/user/1
	@RequestMapping("/newuser")
	public String newuser(String userid,String userpsw,String nickname,String college,
			String tel, String ali){
		JSONObject result = new JSONObject();
		if(userm.insert(userid,userpsw,nickname,tel))
			result.put("status", "true");
		else
			result.put("status", "false");
		return result.toJSONString();
	}
	//http://172.24.11.85:8080/user/entry
	@RequestMapping("/entry")
	public String entry(String userid,String userpsw){
		System.out.println(userid);
		System.out.println(userpsw);
		JSONObject result = new JSONObject();
		if(userm.select2(userid)!=null)
		{
			if(userm.select3(userid,userpsw)!=null)
			{
				System.out.println("登录成功");
				result.put("status", "true");
				user tuser = userm.select2(userid);
				result.put("userid", userid);
			    result.put("nickname", tuser.getNickname());
			    result.put("headpicture",tuser.getHeadpicture());
			    result.put("college", tuser.getCollege());
			    result.put("grade", tuser.getGradle());
			    result.put("tel", tuser.getTel());
			    result.put("ali", tuser.getAli());
			}
			else
				result.put("status", "false");
		}
		else
			result.put("status", "false");
		System.out.println("return:"+result.toJSONString());
		return result.toJSONString();
	}
	@RequestMapping("/updateuser")
	public String updateuser(String userid, String nickname, String tel, String ali) {
		JSONObject result = new JSONObject();
		if(userm.update(userid, nickname, tel, ali)){
			result.put("status", "true");
		}
		else
			result.put("status", "false");
		return result.toJSONString();
	}
	@RequestMapping("/changepsw")
	public String changepsw(String userid, String userpsw) {
		JSONObject result = new JSONObject();
		if(userm.update2(userid, userpsw)){
			result.put("status", "true");
		}
		else
			result.put("status", "false");
		return result.toJSONString();
	}
	@RequestMapping("/uppicture")
	public String uppicture(Blob headpicture)
	{
		JSONObject result = new JSONObject();
		if(userm.uppicture(headpicture) ){
			result.put("status", "true");
		}
		else
			result.put("status", "false");
		return result.toJSONString();
	}

}
