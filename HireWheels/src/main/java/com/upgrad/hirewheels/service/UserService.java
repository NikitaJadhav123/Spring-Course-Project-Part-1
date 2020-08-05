package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotfoundException;

public interface UserService {

    Users createUser(Users users) throws UserAlreadyExistsException;
     Users getUser(String emailid,String password) throws UserDetailsNotfoundException;
}
