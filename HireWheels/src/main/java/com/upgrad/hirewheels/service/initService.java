package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("initService")
public class initService {



    @Qualifier("roleDAO")
    @Autowired
    private RoleDAO roleDAO;
    public void acceptRoleDetails(Role role) {
        roleDAO.save(role);
    }


    @Qualifier("usersDAO")
    @Autowired
    private UsersDAO usersDAO;
    public void acceptUsersDetails(Users users) {
        usersDAO.save(users);
    }


    @Qualifier("vehicleCategoryDAO")
    @Autowired
    private VehicleCategoryDAO vehicleCategoryDAO;
    public void acceptVehicleCategoryDetails(VehicleCategory vehicleCategory) {
        vehicleCategoryDAO.save(vehicleCategory);
    }


    @Qualifier("vehicleSubcategoryDAO")
    @Autowired
    VehicleSubcategoryDAO vehicleSubcategoryDAO;
    public void acceptVehicleSubcategoryDetails(VehicleSubcategory vehicleSubcategory) {
        vehicleSubcategoryDAO.save(vehicleSubcategory);
    }

    @Qualifier("fuelTypeDAO")
    @Autowired
    private FuelTypeDAO fuelTypeDAO;
    public void acceptFuelTypeDetails(FuelType fuelType) {
        fuelTypeDAO.save(fuelType);
    }

    @Qualifier("cityDAO")
    @Autowired
    private CityDAO cityDAO;
    public void acceptCityDetails(City city) {
        cityDAO.save(city);
    }

    @Qualifier("locationDAO")
    @Autowired
    private LocationDAO locationDAO;
    public void acceptLocationDetails(Location location) {
        locationDAO.save(location);
    }








}
