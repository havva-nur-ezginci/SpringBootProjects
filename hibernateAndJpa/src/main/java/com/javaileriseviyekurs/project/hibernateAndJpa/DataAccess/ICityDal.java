package com.javaileriseviyekurs.project.hibernateAndJpa.DataAccess;
import java.util.List;

import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.City;
//import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.*;  // ikiside tercih edilebilir

public interface ICityDal {
   List <City> getAll(); // şehirleri listelemek isteyelim
   void add(City city);
   void update(City city);
   void delete(City city);	
   City getById(int id); // tek bir şehri getirmek için 
}
