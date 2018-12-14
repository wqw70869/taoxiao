package mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.orderDetail; 

//设置数据库的访问操作的文件

@Mapper  
public interface OrderDetailMapper {  
	@Select("select * from orderdetail where orderid = #{orderid}")  
    List<orderDetail> select(String orderid);//根据订单ID查找订单详细信息
	@Select("select * from orderdetail where detailid = #{detailid}")  
    List<orderDetail> select1(String detailid);//根据详细订单ID查找订单详细信息
    
    @Insert("INSERT INTO orderdetail VALUES(#{detailid}, #{orderid},#{itemid},#{itemname},#{totailprice})")//添加详细信息到数据库
    boolean insert(@Param("detailid") String detailid, @Param("orderid") String orderid,@Param("itemid") String itemid,@Param("itemname") String itemname,@Param("totailprice") double totailprice);
     //插入详细订单信息
    @Delete("delete from orderdetail where orderid = #{orderid}")
    boolean delete(@Param("orderid") String orderid);//根据orderID删除商品信息
    @Delete("delete from orderdetail where detailid = #{detailid}")
    boolean delete1(@Param("detailid") String detailid);//根据detailID删除商品信息
    //根据orderID更新订单部分信息
    @Update("update orderdetail set itemid=#{itemid},itemname=#{itemname},totailprice=#{totailprice} where orderid=#{orderid}")
    //根据detailid更新订单部分信息
    boolean update(@Param("orderid") String orderid, @Param("itemid") String itemid,@Param("itemname") String itemname,@Param("totailprice") double totailprice);
    @Update("update orderdetail set itemid=#{itemid},itemname=#{itemname},totailprice=#{totailprice} where detailid=#{detailid}")
    boolean update1(@Param("detailid") String detailid, @Param("itemid") String itemid,@Param("itemname") String itemname,@Param("totailprice") double totailprice);
}  