package com.Jntu.sas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jntu.sas.beans.Registrationtable;

@Repository
public interface RegistrationTableRepo extends JpaRepository<Registrationtable, String> {
	public List<Registrationtable> findAllByOrderByJoindateAsc();

	public List<Registrationtable> findAllByOrderByPercentageDesc();

	public List<Integer> countByCollege(String college);
}
