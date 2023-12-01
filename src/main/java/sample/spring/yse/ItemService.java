package sample.spring.yse;

import java.util.Map;

public interface ItemService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

}
