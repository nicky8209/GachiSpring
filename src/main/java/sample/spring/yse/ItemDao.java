package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map, String sql) {
		return this.sqlSessionTemplate.insert(sql, map);
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

	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("item.select_list", map);
	}

	public Map<String, Object> login(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.login", map);
	}
	public Map<String, Object> salt(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.salt", map);
	}

	public Map<String, Object> check(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.check", map);
	}

	public Map<String, Object> postercid(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.postercid", map);
	}

	public Map<String, Object> upload(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("item.upload", map);
	}

}
