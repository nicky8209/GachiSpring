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

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.itemService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String itemId = map.get("itemId").toString();
		mav.addObject("itemId", itemId);
		mav.setViewName("/item/detail");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.itemService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/item/update");
		return mav;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		boolean isUpdateSuccess = this.itemService.edit(map);
		if (isUpdateSuccess) {
			String itemId = map.get("itemId").toString();
			mav.setViewName("redirect:/detail?itemId=" + itemId);
		} else {
			mav = this.update(map);
		}

		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		boolean isDeleteSuccess = this.itemService.remove(map);
		if (isDeleteSuccess) {
			mav.setViewName("redirect:/list");
		} else {
			String itemId = map.get("itemId").toString();
			mav.setViewName("redirect:/detail?itemId=" + itemId);
		}

		return mav;
	}

}
