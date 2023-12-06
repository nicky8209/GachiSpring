package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDao itemDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.itemDao.insert(map, "item.insert");
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

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.itemDao.selectList(map);
	}

	@Override
	public String join(Map<String, Object> map) {
		int affectRowCount = this.itemDao.insert(map, "member.insert");
		if (affectRowCount == 1) {
			return map.get("id").toString();
		}
		return null;

	}

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		return this.itemDao.login(map);
	}

	@Override
	public Map<String, Object> salt(Map<String, Object> map) {
		return this.itemDao.salt(map);
	}

	@Override
	public Map<String, Object> check(Map<String, Object> map) {
		return this.itemDao.check(map);
	}

	@Override
	public Map<String, Object> postercid(Map<String, Object> map) {
		return this.itemDao.postercid(map);
	}
}
