package com.recette;

import com.recette.model.Recette;
import com.recette.repository.RecetteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RecetteRepository recetteRepository;
/*
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveRecetteTest(){
		Recette pizza =  Recette.builder()
		.name("Pizza")
				.ingredients("Farine")
		.larecette("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout")
				build();

		recetteRepository.save(pizza);

		Assertions.assertThat(pizza.getId()).isGreaterThan("0");
	}
*/

	@Test
	@Order(2)
	public void getRecetteTest(){

		Recette recette = recetteRepository.findById("1").get();
		Assertions.assertThat(recette.getId()).isEqualTo("1");
	}

	@Test
	@Order(3)
	public void getListOfRecetteTest(){

		List list = recetteRepository.findAll();
		assertThat(list.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateRecetteTest(){
		Recette recette = recetteRepository.findById("1").get();
		recette.setName("ratatouille");
		recetteRepository.save(recette);
		assertNotEquals("pizza", recetteRepository.findById("1").get().getName());

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteRecetteTest(){
		recetteRepository.deleteById("1");
		assertThat(recetteRepository.existsById("1")).isFalse();
	}

}
