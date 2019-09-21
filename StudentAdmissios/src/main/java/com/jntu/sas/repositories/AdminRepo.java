package com.jntu.sas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jntu.sas.beans.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {

}
