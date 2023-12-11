package org.java.controller;

import java.util.List;

import org.java.db.pojo.Offert;
import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	private List<Pizza> getAllPizzas() {
		List<Pizza> pizzasList = pizzaService.findAll();

		return pizzasList;
	}

	// METODO CHE CHIAMA TUTTE LE PIZZE NEL DB DA MOSTRARE NELLA HOME

	@GetMapping("/")
	public String getPizzas(Model model, @RequestParam(required = false) String query) {

		List<Pizza> pizzas = query != null ? pizzaService.findByNameOrDescription(query) : getAllPizzas();

		model.addAttribute("query", query);
		model.addAttribute("pizzasList", pizzas);

		return "index-home";

	}

	// METODO PER VISUALIZZARE IL DETTAGLIO

	@GetMapping("/pizza/{id}")
	public String detailSong(Model model, @PathVariable int id) {

		// RECUPERO DAL DB LA PIZZA CERCADOLA CON IL ID PASSATO TRAMITE PARAMETRO AL
		// METODO
		Pizza p = pizzaService.findById(id);

		List<Offert> offerts = p.getOffert();

		model.addAttribute("pizza", p);
		model.addAttribute("offerts", offerts);
		return "detail-pizza";

	}

	// METODO PER LA VISUALISAZIONE DEL FORM IN PAGINA

	@GetMapping("/pizza/create")
	public String viewForm(Model model) {

		Pizza pizza = new Pizza();

		model.addAttribute("pizza", pizza);

		return "create-update-form";
	}

	// METODO PER LA CREAZIONE DI UNA NUOVA PIZZA CHE RICHIAMA IL METODO GENERICO DI
	// SALVATAGGIO NEL RETURN
	@PostMapping("/pizza/create")
	public String cretePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		return savePizza(model, pizza, bindingResult);

	}

	// METODO CHE CONDUCE AL FORM PER LA MODIFICA DELLA PIZZA
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(Model model, @PathVariable int id) {

		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);

		return "create-update-form";
	}

	// METODO PER MODIFICARE LE INFORMAZIONI DELLA PIZZA SALVANDOLE NEL DB
	// RICHIAMANDO IL METODO SAVEPIZZA
	@PostMapping("/pizza/edit/{id}")
	public String updatePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		return savePizza(model, pizza, bindingResult);

	}

	// METODO PER ELIMINARE UNA ELEMENTO DAL DB

	@PostMapping("/pizza/delete/{id}")
	public String delete(Model model, @PathVariable int id, RedirectAttributes redirectAtr) {

		Pizza pizza = pizzaService.findById(id);

		pizzaService.delete(pizza);

		// NEL REDIRECT AGGIUNGE UN ATTRIBUTO CON L'OGGETTO PIZZA PER MOSTRARE NEL
		// FRONTEND UNA NOTIFICA DI QUALE ELEMENTO E' STATO ELIMINATO
		redirectAtr.addFlashAttribute("pizzaDeleted", pizza);

		return "redirect:/";

	}

	// METODO CHE VALIDA I CAMPI IN ARRIVO E SALVA LA PIZZA, SIA CHE SIA IN
	// CREAZIONE CHE IN MODIFICA, IL METODO VIENE RICHIAMATO NEI VARI RETURN

	public String savePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("pizza", pizza);
			System.out.println("pizza-con-errori" + pizza);
			return "create-update-form";
		}

		try {

			pizzaService.save(pizza);

			int id = pizza.getId();

			return "redirect:/pizza/" + id;

		} catch (Exception e) {
			bindingResult.addError(
					new FieldError("pizza", "name", pizza.getName(), false, null, null, "This pizza already exists"));
			model.addAttribute("pizza", pizza);
			return "create-update-form";
		}

	}

}
