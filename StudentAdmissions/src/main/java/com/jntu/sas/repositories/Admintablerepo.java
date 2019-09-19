package com.jntu.sas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jntu.sas.beans.Admin;

public interface Admintablerepo extends JpaRepository<Admin, String> {

}
