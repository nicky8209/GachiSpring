package sample.spring.yse;

import java.util.List;
import java.util.Map;

public interface ItemService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	boolean edit(Map<String, Object> map);

	boolean remove(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);

	String join(Map<String, Object> map);

	Map<String, Object> login(Map<String, Object> map);

}
