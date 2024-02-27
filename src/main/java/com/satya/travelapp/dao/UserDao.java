package com.satya.travelapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satya.travelapp.entity.AppUser;
import com.satya.travelapp.wrapper.AppUserWrapper;

@Repository
public interface UserDao extends JpaRepository<AppUser, Integer> {
	AppUser findByEmail(String email);
	AppUser findByContactNumber(String contactNumber);
	
	@Query("SELECT NEW com.satya.travelapp.wrapper.AppUserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) FROM AppUser u WHERE u.role = 'user'")
	List<AppUserWrapper> getAllAppUser();
	
	@Transactional
    @Modifying
	@Query("UPDATE AppUser u set u.status = :status WHERE u.id = :id")
	Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
	
	@Query("SELECT NEW com.satya.travelapp.wrapper.AppUserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) FROM AppUser u WHERE u.role = 'admin'")
	List<AppUserWrapper> getAllAdmin();
}
