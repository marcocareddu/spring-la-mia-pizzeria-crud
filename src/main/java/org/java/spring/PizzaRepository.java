package org.java.spring;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

//	List<Pizza> findByNameContainingIgnoreCase(String searched);
	List<Pizza> findByNameContainingOrDescriptionContainingIgnoreCase(String name, String description);
	}