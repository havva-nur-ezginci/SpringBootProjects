package com.javaileriseviyekurs.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaileriseviyekurs.project.hibernateAndJpa.Business.ICityService;
import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.City;

@RestController // burası api dir 
@RequestMapping("/api")  //bu clas daki herşey api ile başlayacak
public class CityController {

	private ICityService cityService; //Business katmanıyla iletşim kurulacak.

	@Autowired // ICityService i sadece manager kullandığından dolayı autowired bunu kolayca bulucak bizim için
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities") //localhost/api/cities dedğimizde gelsin demek tüm şehileri istemiştik.
	public List<City> get(){
		return cityService.getAll();
	}
	
	@GetMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")  // tek bir şehri alacağımızda id dinamik oluyor. Ben bir parametre istiyorum demek oluyor.
	public City getById(@PathVariable int id){ // /cities/{id} bu restful apimizin yolu bu yoldan almamız gerek id yi
		return cityService.getById(id);			
	}
	
	
	
	
	
}
