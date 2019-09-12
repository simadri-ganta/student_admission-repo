package com.Jntu.sas.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Jntu.sas.beans.Selectedstudents;

public interface SelectedStudentsRepo extends JpaRepository<Selectedstudents, String> {
	public List<Integer> countByCollegecodeAndAlloteddepartment(String collegecode, String alloteddepartment);

	public List<Selectedstudents> findAllByCollegecodeAndAlloteddepartment(String collegecode,
			String alloteddepartment);

	public List<Integer> countByCollegecode(String collegecode);

	public List<Selectedstudents> findTop5ByCollegecode(String collegecode, Sort sort);
}
