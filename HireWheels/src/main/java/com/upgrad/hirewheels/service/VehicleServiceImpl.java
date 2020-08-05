package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDAO;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.UserDetailsNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    @Qualifier("vehicleDAO")
   private VehicleDAO vehicleDAO;

    @Autowired
    @Qualifier("usersDAO")
    private UsersDAO usersDAO;

    @Autowired
    @Qualifier("vehicleSubcategoryDAO")
    VehicleSubcategoryDAO vehicleSubcategoryDAO;


    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }

    @Override
    public List<Vehicle> getVehicleByUserID(int id) throws UserDetailsNotfoundException {
        Optional<Users> optionalUsers = usersDAO.findById(id);
        Users foundUser = optionalUsers.orElseThrow(()->new UserDetailsNotfoundException("User Not Found "));


        return foundUser.getVehicles();
    }

   // @Override
   // public List<Vehicle> getAvailableVehicles(VehicleCategory vehicleCategory) {
   //VehicleSubcategory vehicleSubcategory=new VehicleSubcategory();
    //    VehicleSubcategory vehicleSubcategory1=vehicleSubcategoryDAO.findById(vehicleCategory.getId()).get();

    //}
}
