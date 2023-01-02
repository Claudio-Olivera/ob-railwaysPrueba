package com.practica1.Laptops;

import com.practica1.Laptops.Models.Laptop;
import com.practica1.Laptops.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class LaptopsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaptopsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		Laptop laptop = new Laptop(null, "Lenovo", "lmx-120");
		Laptop laptop2 = new Laptop(null, "Sony", "Hike-5000");
		repository.save(laptop);
		repository.save(laptop2);
		System.out.println(repository.findAll());
	}


}


