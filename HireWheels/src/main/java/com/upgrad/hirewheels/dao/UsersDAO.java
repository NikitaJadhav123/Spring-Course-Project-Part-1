package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("usersDAO")
public interface UsersDAO extends JpaRepository<Users,Integer> {

    Optional<Users> findByEmailId(String emailId);
    Optional<Users> findByMobileNo(String mobileNo);
    Optional<Users> findByPassword(String password);
  //  Optional<Users> findByEmailIdandPassword(String emailId,String password);
}
