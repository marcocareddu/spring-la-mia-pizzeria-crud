package org.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	public List<Pizza> finAll() {
		return pizzaRepository.findAll();
	}
	public Pizza findById(int id) {
		return pizzaRepository.findById(id).get();
	}
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}
}
