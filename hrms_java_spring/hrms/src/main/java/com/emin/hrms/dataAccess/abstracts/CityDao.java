package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
