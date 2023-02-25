package com.javaileriseviyekurs.springBootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
	
	@GetMapping("/") // uygulama sunucumuzun ana istek noktasında ProductsController ın get i çalışacak
	public String get() { //json değil String döndürüyoruz
		return "Laptop";
	}
	
	@GetMapping("/products") 
	public String get2() { 
		return "Laptop 0";
	}

}
