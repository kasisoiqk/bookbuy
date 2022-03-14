package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {
	
	@RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
	public ModelAndView redirectHomePage() {
		return new ModelAndView("redirect:/admin/manage-book");
	}
	
	@RequestMapping(value = {"/manage-book"}, method = RequestMethod.GET)
	public ModelAndView loadManageBookPage() {
		return new ModelAndView("admin/manage-book");
	}
	
	@RequestMapping(value = {"/manage-category"}, method = RequestMethod.GET)
	public ModelAndView loadManageCategoryPage() {
		return new ModelAndView("admin/manage-category");
	}
	
	@RequestMapping(value = {"/manage-user-info"}, method = RequestMethod.GET)
	public ModelAndView loadManageUserPage() {
		return new ModelAndView("admin/manage-user");
	}
	
	@RequestMapping(value = {"/manage-purchase"}, method = RequestMethod.GET)
	public ModelAndView loadManagePurchasePage() {
		return new ModelAndView("admin/manage-purchase");
	}
	
}
