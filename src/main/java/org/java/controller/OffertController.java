package org.java.controller;

import org.java.db.pojo.Offert;
import org.java.db.pojo.Pizza;
import org.java.db.serv.OffertService;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OffertController {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private OffertService offertService;

	@GetMapping("/offert/{id}/create")
	public String createOffert(Model model) {

		Offert offert = new Offert();
		model.addAttribute("offert", offert);

		return "offert-form";
	}

	@PostMapping("/offert/{id}/create")
	public String saveOffert(@ModelAttribute Offert offert, @PathVariable int id) {

		Pizza pizza = pizzaService.findById(id);

		Offert newOffert = new Offert(offert.getTitle(), offert.getStartDateOffert(), offert.getEndDateOffert(), pizza);

		offertService.save(newOffert);

		return "redirect:/pizza/" + id;

	}

}
