package mapper;


import java.util.List;
import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.ordermaster; 


@Mapper  
public interface OrdermasterMapper {  
	@Select("select * from ordermaster where orderid = #{orderid}")  
    List<ordermaster> select(String orderid);//根据订单ID查找订单信息
	@Select("select * from ordermaster where buyid = #{buyid}")  
    List<ordermaster> select1(String buyid);//根据用户ID查找订单信息
    @Insert("INSERT INTO ordermaster VALUES(#{orderid}, #{status},#{buyid},#{buyname},#{sellid},#{createTime},#{address})")//添加用户到数据库
    boolean insert(@Param("orderid") String orderid, @Param("status") int status,@Param("buyid") String buyid,@Param("buyname") String buyname,@Param("sellid") String sellid,@Param("createTime") Date createTime,@Param("address") String address);
    @Delete("delete from ordermaster where id = #{orderid}")
    boolean delete(@Param("orderid") String orderid);//根据ID删除商品信息
    
    //根据ID更新订单部分信息
    @Update("update ordermaster set status=#{status},createTime=#{createTime},address=#{address} where orderid=#{orderid}")
    boolean update(@Param("orderid") String orderid, @Param("status") int status,@Param("createTime") Date createTime,@Param("address") String address);
}  
