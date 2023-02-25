package com.javaileriseviyekurs.project.hibernateAndJpa.DataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.City;

@Repository  // başka bir zaman hibernate yerine başka birşey kullanmak istersek bu annatationı buradan silip kullanacağımız yere koyarsak repository im diğeridir diye gösterirriz.
public class HibernateCityDal implements ICityDal{
	
	private EntityManager entityManager;//JPA dan karşılık gelen class

	//constructor injection
	@Autowired   //Biz projeye hibernate eklediğimizden onun ataması otamatik yapılacak
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// AOP - Aspect Oriented Programing
	@Override
	@Transactional // jpa sağlıyor bunu bize. bu anatation getAll un başında ve sonunda transaction açıyor bizim için.
	public List<City> getAll() { //şehirleri döndürücez.
		Session session = entityManager.unwrap(Session.class); // JPA ya hibernate session ı ver demiş oluyoruz.
		//hibernate bizim için gerekeli olan tüm enjeksiyonları gerçekleştiricek.
		List<City>  cities =session.createQuery("from City",City.class).getResultList();//query yazıcaz
	    return cities;
	}
	
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class,id);//geleni City.class tipine map etsin
	    return city;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);//session.save buda kullanılabilir.
// eğer city nesnemiz için id varsa veritabanında olmayan bir kayıt olur ve bunun için ekleme yapılır
// eğer id verirsek onu güncelleme yapar.
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);	
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class,city.getId());//geleni City.class tipine map etsin
		session.delete(cityToDelete);
	}

	

}
