package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("item/create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		String itemId = this.itemService.create(map);
		if (itemId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?itemId=" + itemId);
		}

		return mav;
	}

}
