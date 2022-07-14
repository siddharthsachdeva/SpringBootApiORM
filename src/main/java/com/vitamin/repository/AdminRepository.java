package com.vitamin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitamin.entity.AdminDetails;

@Repository
public interface AdminRepository extends CrudRepository<AdminDetails, Integer> {

	@Query("select case when (count(ad) > 0)then true else false end from AdminDetails ad where ad.emailId = :emailId and ad.username = :username")
	public boolean isAdminExists(@Param("emailId") String emailId, @Param("username") String username);
	
	public AdminDetails findAdminByUsername(String username);
	
}