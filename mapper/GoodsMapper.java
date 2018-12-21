package com.example.taoxiao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Update; 


@Mapper
public interface GoodsMapper {  
	@Select("select * from sellgoods order by uptime")
    List<sellgoods> select1();//查找所有的商品
    
    @Select("select * from sellgoods where type = #{type}")  
    List<sellgoods> select3(String type);//根据商品的类型查找商品
    
    @Select("select * from sellgoods where id = #{id}")  
    List<sellgoods> select2(Integer goodsid);//根据ID查找商品信息

    @Delete("delete from sellgoods where id = #{id}" +"delete from photo where photoid = #{id}")
    boolean delete(@Param("id") Integer goodsid);//根据ID删除商品信息
    
    @Update("update sellgoods set goodsname=#{goodsname},sellid=#{sellid},kinds=#{kinds},price=#{price},description=#{description},uptime=#{uptime} where goodsid=#{goodsid}")
    boolean update(@Param("goodsid") String goodsid, @Param("goodsname") String goodsname,@Param("sellid") String sellid,@Param("kinds") String kinds,
    		@Param("price") double price,@Param("description") String description,@Param("uptime") Date uptime);
    
    @Insert("INSERT INTO sellgoods VALUES(null,#{goodsname},#{sellid},#{kinds},#{price},#{description},#{uptime)")//添加用户到数据库
    boolean insert(@Param("goodsname") String goodsname, @Param("sellid") String sellid,@Param("kinds") String kinds,
    		@Param("price") double price,@Param("description") String description, @Param("uptime") Date uptime);

    @Insert("INSERT INTO photo VALUES(#{photoid},#{photoname})")
    boolean insertphoto(@Param("photoid") Integer photoid,@Param("photoname") String photoname);

    @Select("select * from sellgoods where goodsname like #{Text} OR description like #{Text} OR kinds like #{Text}")
    List<sellgoods> Searchsell(@Param("Text") String Text);//根据关键字搜索商品

    @Select("select * from sellgoods where type=#{type} AND goodsname like #{Text} OR description like #{Text}")
    List<sellgoods> Searchsell(@Param("type")String type,@Param("Text") String Text);//根据类型与关键字搜索商品

    @Select("select * from rentgoods where goodsname like #{Text} OR description like #{Text} OR kinds like #{Text}")
    List<rentgoods> Searchrent(@Param("Text") String Text);//根据关键字搜索商品

    @Select("select * from sellgoods where sellid=#{sellid}")
    List<sellgoods> Mysellgoods(@Param("sellid") Integer sellid);//查看我的发布


}  

