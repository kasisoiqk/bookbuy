package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.mapper.BookMapper;
import com.laptrinhjavaweb.service.IBookService;

@Controller(value = "controllerOfWeb")
public class HomeController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private BookMapper bookMapper;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView redirectHomePage() {
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public ModelAndView loadHomePage() {
		return new ModelAndView("web/home");
	}
	
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	public ModelAndView loadSearchPage() {
		return new ModelAndView("web/search");
	}
	
	@RequestMapping(value = {"/book-info/{id}"}, method = RequestMethod.GET)
	public ModelAndView loadBookPage(@PathVariable(name = "id") Long id) {
		// Chưa làm trường hợp không tìm thấy !!!
		
		ModelAndView mav = new ModelAndView("web/book");
		BookEntity book = bookService.findOne(id);
		mav.addObject("book", bookMapper.convertToDTO(book));
		return mav;
	}
	
	@RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
	public ModelAndView loadCartPage() {
		return new ModelAndView("web/cart");
	}
	
	@RequestMapping(value = {"/checkout/address"}, method = RequestMethod.GET)
	public ModelAndView loadAddressPage() {
		return new ModelAndView("web/checkout/address");
	}
	
	@RequestMapping(value = {"/checkout/payment"}, method = RequestMethod.POST)
	public ModelAndView loadPaymentPage() {
		return new ModelAndView("web/checkout/payment");
	}
	
	@RequestMapping(value = {"/purchase"}, method = RequestMethod.GET)
	public ModelAndView loadPurchasePage() {
		return new ModelAndView("web/purchase");
	}
	
	@RequestMapping(value = {"/chat"}, method = RequestMethod.GET)
	public ModelAndView loadChatPage() {
		return new ModelAndView("web/chat");
	}
	
	@RequestMapping(value = {"/user-info"}, method = RequestMethod.GET)
	public ModelAndView loadUserInfoPage() {
		return new ModelAndView("web/user-info");
	}
	
}
