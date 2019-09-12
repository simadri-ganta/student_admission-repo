package com.Jntu.sas.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Jntu.sas.beans.Selected_students;

public interface Selected_students_repo extends JpaRepository<Selected_students, String> {
	public List<Integer> countByCollegecodeAndAlloteddepartment(String collegecode, String alloteddepartment);
	public List<Selected_students> findAllByCollegecodeAndAlloteddepartment(String collegecode, String alloteddepartment);
	public List<Integer> countByCollegecode(String collegecode);
	public List<Selected_students> findTop5ByCollegecode(String collegecode,Sort sort);
}
