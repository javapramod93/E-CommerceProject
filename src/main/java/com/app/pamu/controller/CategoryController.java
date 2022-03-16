package com.app.pamu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pamu.entity.Category;
import com.app.pamu.exception.CategoryNotFoundException;
import com.app.pamu.service.ICategoryService;
import com.app.pamu.service.ICategoryTypeService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService service;
	
	@Autowired
	private ICategoryTypeService categoryTypeService;
	
	private void commounUi(Model model) {
		model.addAttribute("categoryTypes", categoryTypeService.getCategoryTypeIdAndName());
	}
	
	//1.register
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("category", new Category());
		commounUi(model);
		return "CategoryRegister";
	}
	
	//2. save
	@PostMapping("/save")
	public String saveCategory(@ModelAttribute Category category, Model model) {
		
		Long id = service.createCategory(category);
		model.addAttribute("message", "Category created with Id: "+id);
		model.addAttribute("category", new Category());
		commounUi(model);
		return "CategoryRegister";
	}
	//3.all
	@GetMapping("/all")
	public String getAllCategory(Model model,@RequestParam(value = "message",required = false)String message) {
		
		List<Category> list = service.getAllCategorys();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "CategoryData";
	}
	
	//4.
	@GetMapping("/delete")
	public String deleteCategory(@RequestParam Long id,RedirectAttributes attributes) {
		
		try {
			service.deleteCategory(id);
			attributes.addAttribute("message", "Category deleted with Id: " +id);
		} catch (CategoryNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			
		}
		return "redirect:all";
	}
	
	//5.edit
	@GetMapping("/edit")
	public String editCategory(@RequestParam Long id,Model model, RedirectAttributes attributes) {
		
		String page = null;
		try {
			 Category ob = service.getOneCategory(id);
			 model.addAttribute("category", ob);
			 page = "CategoryEdit";
			 commounUi(model);
		} catch (CategoryNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}
	
	//6.update
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute Category category,RedirectAttributes attributes) {
		
		service.updateCategory(category);
		attributes.addAttribute("message", "Category Updated");
		return "redirect:all";
	}
}












