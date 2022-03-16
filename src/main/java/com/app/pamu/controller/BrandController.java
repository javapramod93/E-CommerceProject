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

import com.app.pamu.entity.Brand;
import com.app.pamu.exception.BrandNotFoundException;
import com.app.pamu.service.IBrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService service;
	
	//1.register
	@GetMapping("/register")
	public String registerBrand(Model model) {
		model.addAttribute("brand", new Brand());
		return "BrandRegister";
	}
	
	//2. save
	@PostMapping("/save")
	public String saveBrand(@ModelAttribute Brand brand,Model model) {
		
		Long id = service.saveBrand(brand);
		model.addAttribute("message", "Brand created with Id: " + id);
		model.addAttribute("brands", new Brand());
		return "BrandRegister";
	}
	//3.all
	@GetMapping("/all")
	public String getAllBrands(Model model,@RequestParam(name = "message",required = false)String message) {
		
		List<Brand> list = service.getAllBrands();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "BrandData";
	}
	//4.delete
	@GetMapping("/delete")
	public String deleteBrand(@RequestParam Long id, RedirectAttributes  attributes) {
		
		try {
			service.deleteBrand(id);
			attributes.addAttribute("brand", "Brand deleted with Id: " + id);
		} catch (BrandNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}
	//5.edit
	@GetMapping("/edit")
	public String editBrand(@RequestParam Long id,Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			Brand ob = service.getOneBrand(id);
			model.addAttribute("brand", ob);
			page ="BrandEdit";
		} catch (BrandNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page ="redirect:all";
		}
		return page;
	}
	
	//6.update
	@PostMapping("/update")
	public String updateBrand(@ModelAttribute Brand brand,RedirectAttributes attributes) {
		service.updateBrand(brand);
		attributes.addAttribute("brand", "Brand updated");
		return "redirect:all";
	}
}
