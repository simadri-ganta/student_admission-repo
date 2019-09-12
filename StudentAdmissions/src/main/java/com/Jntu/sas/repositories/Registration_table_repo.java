package com.Jntu.sas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jntu.sas.beans.Registration_table;

@Repository
public interface Registration_table_repo extends JpaRepository<Registration_table, String> {
	public List<Registration_table> findAllByOrderByJoindateAsc();
	public List<Registration_table> findAllByOrderByPercentageDesc();
	public List<Integer> countByCollege(String college);
}
