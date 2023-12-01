package org.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getPizzas(Model model, @RequestParam(required = false) String searched) {
		List<Pizza> pizzas = searched == null
				? pizzaService.findAll()
				: pizzaService.findByName(searched);
		model.addAttribute("list", pizzas);
		model.addAttribute("searched", searched == null ? "" : searched);
		return "index";
	}
	
	@GetMapping("/detail/{id}")
	public String getPizza(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("list", pizza);
		return "detail";
	}
}
