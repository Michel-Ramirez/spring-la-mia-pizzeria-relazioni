package org.java;

import java.math.BigDecimal;

import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pizza pizza1 = new Pizza("Capricciosa", "La pizza tutta capricciosa",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("11.50"));

		Pizza pizza2 = new Pizza("Margherita", "Bona come la regina", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("9.99"));

		Pizza pizza3 = new Pizza("Quattro Stagioni", "Ormai non ce son più",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("12.75"));

		Pizza pizza4 = new Pizza("Diavola", "Quella che vorremmo tutti", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("10.25"));

		Pizza pizza5 = new Pizza("Quattro Formaggi", "La puzzona", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("13.20"));

		Pizza pizza6 = new Pizza("Napoletana", "Aho! gnamme belli", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("11.75"));

		Pizza pizza7 = new Pizza("Calzone", "Quello di Babbo Natale", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("10.99"));

		Pizza pizza8 = new Pizza("Hawaiian", "Dove vorremmo essere tutti", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("10.50"));

		Pizza pizza9 = new Pizza("Vegetariana", "Magnatela te!", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("11.00"));

		Pizza pizza10 = new Pizza("Bianca", "is White", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("9.75"));

		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		pizzaService.save(pizza5);
		pizzaService.save(pizza6);
		pizzaService.save(pizza7);
		pizzaService.save(pizza8);
		pizzaService.save(pizza9);
		pizzaService.save(pizza10);

	}

}
