package org.java.controller;

import org.java.db.serv.IngredientService;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {

	@Autowired
	private PizzaService pizzaService;
	private IngredientService ingredientService;

	@GetMapping("/ingredients")
	public String ingredientList() {
		return "index-ingredient-list";
	}

}
