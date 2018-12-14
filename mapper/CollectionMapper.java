package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.Collection;

@Mapper
public interface CollectionMapper {
	public List<Collection> getcollection(String UserId);
    public boolean setcollection(Collection collection);
    public boolean delcollection(String UserId,String GoodsId);
}
