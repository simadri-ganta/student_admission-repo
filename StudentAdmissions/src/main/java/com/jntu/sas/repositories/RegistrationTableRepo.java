package com.jntu.sas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jntu.sas.beans.Registration;

@Repository
public interface RegistrationTableRepo extends JpaRepository<Registration, String> {
	public List<Registration> findAllByOrderByJoindateAsc();

	public List<Registration> findAllByOrderByPercentageDesc();

	public List<Integer> countByCollege(String college);
}
