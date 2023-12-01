package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDao itemDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.itemDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("item_id").toString();
		}
		return null;

	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.itemDao.selectDetail(map);
	}

	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.itemDao.update(map);
		return affectRowCount == 1;

	}

	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.itemDao.delete(map);
		return affectRowCount == 1;

	}

}
