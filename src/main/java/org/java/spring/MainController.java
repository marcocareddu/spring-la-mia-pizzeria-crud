package org.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getPizzas(Model model) {
		List<Pizza> pizzas = pizzaService.finAll();
		model.addAttribute("list", pizzas);
		return "index";
	}
	
	@GetMapping("/detail/{id}")
	public String getPizza(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("list", pizza);
		return "detail";
	}
}
