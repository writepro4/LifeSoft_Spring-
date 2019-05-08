package com.example.spring02.controller.shop;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product/*") //공통적인 url mapping
public class ProductController {
	
	@Inject //의존관계 주입(DI)
	ProductService productService;
	
	@RequestMapping("list.do") // 세부적인 url mapping
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list"); // 이동할 페이지 이름
		mav.addObject("list", productService.listProduct()); //데이터저장
		return mav;  //페이지 이동
	}

}
