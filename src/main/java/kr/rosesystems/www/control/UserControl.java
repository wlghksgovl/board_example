package kr.rosesystems.www.control;

import kr.rosesystems.www.dao.IDao;
import kr.rosesystems.www.dto.Paging;
import kr.rosesystems.www.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserControl {

	@Autowired
	private IDao dao;

	@RequestMapping(value = { "/", "/list" })
	public String list( Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {
		Paging paging = new Paging();
		paging.setPageNo(pageNum);
		paging.setPageSize(5);
		model.addAttribute("list", dao.getAll(paging));
		model.addAttribute("paging", paging);
		return "list";
	}

	@RequestMapping("/showContent")
	public String showContent(Model model, @RequestParam("u_num") String u_num) {
		User user = dao.getContent(u_num);
		model.addAttribute("user", user);
		return "contents";
	}

	@RequestMapping("/addContent")
	public String addContent() {
		return "insert";
	}

	@RequestMapping("/doAddContent")
	public String doAddContent(User user) {
		dao.insert(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("u_num") String u_num,
						 @RequestParam("c_pw") String c_pw) {
		if (null == dao.pwChk(u_num, c_pw)) {
			dao.delete(u_num);
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(String u_contents, @RequestParam("u_num") String u_num,
											@RequestParam("c_pw") String  c_pw) {
		if (null == dao.pwChk(u_num, c_pw)) {
			dao.update(u_num, u_contents);
			return "list";
		} else {
			return "false";
		}
	}
}
