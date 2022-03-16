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

import com.app.pamu.entity.CategoryType;
import com.app.pamu.exception.CategoryTypeNotFoundException;
import com.app.pamu.service.ICategoryTypeService;

@Controller
@RequestMapping("/categorytype")
public class CategoryTypeController {

	@Autowired
	private ICategoryTypeService service;
	
	//1.register
	@GetMapping("/register")
	public String registerCategoryType(Model nodel) {
		return "CategoryTypeRegister";
	}
	
	//2.save
	@PostMapping("/save")
	public String saveCategoryType(@ModelAttribute CategoryType categoryType,Model model) {
		
		Long id = service.saveCategoryType(categoryType);
		model.addAttribute("message", "CategoryType created with Id:"+id);
		model.addAttribute("categoryType", new CategoryType());
		return "CategoryTypeRegister";
	}
	
    //3.get All
	 @GetMapping("/all")
	 public String getAllCategoryType(Model model,@RequestParam(value = "message",required = false) Long id, String message) {
		 
		List<CategoryType> list = service.getAllCategoryType();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "CategoryTypeData";
	 }
	
	//4.remove category
	@GetMapping("/delete")
	public String deleteCategoryType(@RequestParam Long id,RedirectAttributes attributes) {
		
		try {
			service.deleteCategoryType(id);
			attributes.addAttribute("message","CategoryType deleted with Id:"+id);
		}catch(CategoryTypeNotFoundException ctnfe) {
			ctnfe.printStackTrace();
			attributes.addAttribute("message",ctnfe.getMessage());
		}
	    return "redirect:all";
	}
	
	//5.edit category
	@GetMapping("/edit")
	public String editCategoryType(@RequestParam Long id,Model model, RedirectAttributes attributes ) {
		
		String page = null;
		try {
			CategoryType ct = service.getOneCategoryType(id);
			model.addAttribute("categorytype", ct);
			page = "CategoryTypeEdit";
		} catch (CategoryTypeNotFoundException e) {
			e.printStackTrace();
			attributes.addFlashAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		   return page;
	}
	
	//6.update
	@PostMapping("/update")
	public String updateCategoryType(@ModelAttribute CategoryType categoryType, RedirectAttributes attributes) {
		  
		service.updateCategoryType(categoryType);
		attributes.addFlashAttribute("message", "CategoryType Uodated");
		return "redirect:all";
	}	
}
