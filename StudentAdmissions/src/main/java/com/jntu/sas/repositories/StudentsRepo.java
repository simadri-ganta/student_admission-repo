package com.jntu.sas.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jntu.sas.beans.Student;

public interface StudentsRepo extends JpaRepository<Student, String> {
	public List<Integer> countByCollegecodeAndAlloteddepartment(String collegecode, String alloteddepartment);

	public List<Student> findAllByCollegecodeAndAlloteddepartment(String collegecode,
			String alloteddepartment);

	public List<Integer> countByCollegecode(String collegecode);

	public List<Student> findTop5ByCollegecode(String collegecode, Sort sort);
}
