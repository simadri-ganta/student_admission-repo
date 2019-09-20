package com.jntu.sas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jntu.sas.beans.Registration;

@Repository
public interface RegisterationRepo1 extends JpaRepository<Registration, String> {
	public List<Registration> findAllByOrderByJoinDateAsc();

	public List<Registration> findAllByOrderByPercentageDesc();

	public List<Integer> countByFirstCollege(String firstCollege);
}
