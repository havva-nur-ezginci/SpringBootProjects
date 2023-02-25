package com.javaileriseviyekurs.project.hibernateAndJpa.Business;

import java.util.List;

import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.City;

public interface ICityService {
	   List <City> getAll(); // şehirleri listelemek isteyelim
	   void add(City city);
	   void update(City city);
	   void delete(City city);	
	   City getById(int id);
	   
}
