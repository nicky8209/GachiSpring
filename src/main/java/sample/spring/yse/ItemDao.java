package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("item.insert", map);
	}

	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("item.select_detail", map);
	}

	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("item.update", map);
	}

	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("item.delete", map);
	}

}
