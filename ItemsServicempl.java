package cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.dao.ItemsMapper;
import cn.itheima.pojo.Items;
import cn.itheima.pojo.ItemsExample;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> list() throws Exception {
		//濡傛灉涓嶉渶瑕佷换浣曟煡璇㈡潯浠�,鐩存帴灏唀xample瀵硅薄new鍑烘潵鍗冲彲
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public Items findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItems(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
	
}
