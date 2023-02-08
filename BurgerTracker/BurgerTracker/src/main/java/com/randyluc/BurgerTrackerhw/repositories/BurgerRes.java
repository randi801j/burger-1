package com.randyluc.BurgerTrackerhw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.randyluc.BurgerTrackerhw.models.Burger;

@Repository
public interface BurgerRes extends CrudRepository <Burger,Long> {
	List<Burger> findAll();
}
