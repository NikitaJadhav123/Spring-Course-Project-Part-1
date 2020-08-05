package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.RoleDAO;
import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {


    @Autowired
    @Qualifier("usersDAO")
    private UsersDAO usersDAO;
    @Autowired
    RoleDAO roleDAO;



        @Override
        public Users createUser(Users users) throws UserAlreadyExistsException {


            if(usersDAO.findByEmailId(users.getEmailId()).isPresent()) {
                throw new UserAlreadyExistsException("Email Already Exists");
            }

            if(usersDAO.findByMobileNo(users.getMobileNo()).isPresent()) {
                throw new UserAlreadyExistsException("Mobile Number Already Exists");
            }

            return usersDAO.save(users);
        }

    @Override
    public Users getUser(String emailid,String password) throws UserDetailsNotfoundException {
            
            if(!usersDAO.findByEmailId(emailid).isPresent()) {
                throw new UserDetailsNotfoundException("User not Registered");
            }
            
            if(!usersDAO.findByPassword(password).isPresent()){
                throw new UserDetailsNotfoundException("Unauthorized User");
            }

        return usersDAO.findByEmailId(emailid).get();
    }


}
