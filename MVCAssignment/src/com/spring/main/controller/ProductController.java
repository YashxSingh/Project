package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.model.Product;
import com.spring.main.service.Productservice;

@Controller
public class ProductController {
	@Autowired
	private Productservice productservice;
	@Autowired
	private Product product;

	@RequestMapping("/all-products")
	public String Showallproducts(Model model) {
		List<Product> list = productservice.fetchAllProducts();
		product.setName("");
		product.setDescription("");
		product.setPrice(0);
		product.setCategory("");
		model.addAttribute("product", product);
		model.addAttribute("list", list);
		return "all-product";

	}

	@RequestMapping("/insert-product")
	public String InsertProduct(@RequestParam("ename") String name, @RequestParam("eprice") double price,
			@RequestParam("edescription") String description, @RequestParam("ecategory") String category, Model model) {
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);
		product.setCategory(category);

		productservice.insertProduct(product);

		List<Product> list = productservice.fetchAllProducts();
		model.addAttribute("list", list);

		return "redirect:redirect-product";

	}

	@RequestMapping("delete-product")
	public String deleteProduct(@RequestParam("id") Integer id, Model model) {
		productservice.deleteProduct(id);
		List<Product> list = productservice.fetchAllProducts();
		product.setName("");
		product.setDescription("");
		product.setPrice(0);
		product.setCategory("");
		model.addAttribute("product", product);
		model.addAttribute("list", list);

		return "redirect:redirect-product";

	}

	@RequestMapping("/redirect-product")
	public String redirect(Model model) {
		product.setName("");
		product.setDescription("");
		product.setPrice(0);
		product.setCategory("");
		model.addAttribute("product", product);
		List<Product> list = productservice.fetchAllProducts();

		model.addAttribute("list", list);
		return "all-product";
	}

	@RequestMapping("/edit-product")
	public String updateProduct(@RequestParam("id") Integer id, Model model) {

		List<Product> list = productservice.fetchAllProducts();
		for (Product p : list) {
			if (p.getId() == id) {
				product = p;
				break;
			}
		}
		model.addAttribute("flag", "edit");
		model.addAttribute("product", product);
		model.addAttribute("list", list);
		return "all-product";
	}

	@RequestMapping("/edit-product-op")
	public String processedit(@RequestParam("id") Integer id, @RequestParam("ename") String name,
			@RequestParam("eprice") double price, @RequestParam("edescription") String description,
			@RequestParam("ecategory") String category, Model model) {
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);
		product.setCategory(category);

		productservice.processedit(product);
		return "redirect:redirect-product";
	}

}
