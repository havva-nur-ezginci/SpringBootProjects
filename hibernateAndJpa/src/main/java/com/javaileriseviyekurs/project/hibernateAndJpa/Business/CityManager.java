package com.javaileriseviyekurs.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaileriseviyekurs.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javaileriseviyekurs.project.hibernateAndJpa.Entities.City;

@Service//burası bir iş katmanı diye belirttik şart değil ama sonradan kamaşıklıkta işimizi kolaylaştırıyoe.
public class CityManager implements ICityService{
	
	private ICityDal cityDal;
	// dependency injection 
	@Autowired //sen otomatik olarak git bak ICityDal için uygun olanı bul ve ata zaten 
	//şuanda biz sadece hibernate kullandığımızdan direk onun ataması yapılacak.
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional 
	public List<City> getAll() {
		return this.cityDal.getAll(); //hibernate kodu yazmadık @Autowired  kullanmamızı sağladı 
	}

	@Override
	@Transactional 
	public void add(City city) {
		this.cityDal.add(city);
	}

	@Override
	@Transactional 
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional 
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDal.getById(id);
	}

}
