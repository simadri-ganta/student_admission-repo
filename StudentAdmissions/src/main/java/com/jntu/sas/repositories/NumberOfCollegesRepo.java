package com.jntu.sas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jntu.sas.beans.College;

public interface NumberOfCollegesRepo extends JpaRepository<College, String> {

}
