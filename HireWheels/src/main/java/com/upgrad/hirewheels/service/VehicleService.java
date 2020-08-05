package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.UserDetailsNotfoundException;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();


     List<Vehicle> getVehicleByUserID(int id) throws UserDetailsNotfoundException;

   // public List<Vehicle> getAvailableVehicles(VehicleCategory vehicleCategory);
}
