package org.java.db.repo;

import java.util.List;

import org.java.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	List<Pizza> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String value, String value2);

}
