import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.exceptions.BookingAmountException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotfoundException;
import com.upgrad.hirewheels.service.AdminService;
import com.upgrad.hirewheels.service.BookingService;
import com.upgrad.hirewheels.service.VehicleService;
import com.upgrad.hirewheels.service.initService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class CarRentalApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("hwBeans.xml");

        initService service = (initService) context.getBean("initService");

        Role adminUserType = new Role("Admin");
        Role customerUserType = new Role("User");
        service.acceptRoleDetails(adminUserType);
        service.acceptRoleDetails(customerUserType);

        Users users = new Users("Admin", "Admin", "admin@123", "upgrad@gmail.com", "9999999999", 10000.00, adminUserType);
        service.acceptUsersDetails(users);


        VehicleCategory vehicleCategory = new VehicleCategory("Car");
        VehicleCategory vehicleCategory1 = new VehicleCategory("Bike");
        service.acceptVehicleCategoryDetails(vehicleCategory);
        service.acceptVehicleCategoryDetails(vehicleCategory1);


        VehicleSubcategory vehicleSubcategory = new VehicleSubcategory("SUV", 300, vehicleCategory);
        VehicleSubcategory vehicleSubcategory1 = new VehicleSubcategory("SEDAN", 350, vehicleCategory);
        VehicleSubcategory vehicleSubcategory2 = new VehicleSubcategory("HATCHBACK", 250, vehicleCategory);
        VehicleSubcategory vehicleSubcategory3 = new VehicleSubcategory("CRUISER", 200, vehicleCategory1);
        VehicleSubcategory vehicleSubcategory4 = new VehicleSubcategory("DIRT BIKE", 200, vehicleCategory1);
        VehicleSubcategory vehicleSubcategory5 = new VehicleSubcategory("SPORTS BIKE", 150, vehicleCategory1);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory1);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory2);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory3);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory4);
        service.acceptVehicleSubcategoryDetails(vehicleSubcategory5);


        FuelType fuelType = new FuelType("Petrol");
        FuelType fuelType1 = new FuelType("Diesel");
        service.acceptFuelTypeDetails(fuelType);
        service.acceptFuelTypeDetails(fuelType1);


        City city = new City("Mumbai");
        service.acceptCityDetails(city);


        Location location = new Location("Worli", "Dr E Moses Rd, Worli Naka, Upper Worli", city, "400018");
        Location location1 = new Location("Chembur", "Optic Complex", city, "400019");
        Location location2 = new Location("Powai", "Hiranandani Towers", city, "400020");
        service.acceptLocationDetails(location);
        service.acceptLocationDetails(location1);
        service.acceptLocationDetails(location2);





        Vehicle vehicle=new Vehicle("Hyundai Creta","M150001","White",1,"https://images.carandbike.com/car-images/large/hyundai/creta/hyundai-creta.webp?v=56",users,fuelType,location,vehicleSubcategory);


        AdminService adminService=(AdminService) context.getBean("AdminService");
        System.out.println( adminService.registerVehicle(vehicle));


        Booking booking=new Booking(new Date(29-5-2020),new Date(29-5-20),new Date(25-5-20),3000.00,users,location,vehicle);
        BookingService bookingService=(BookingService) context.getBean("BookingService");
        try {
            bookingService.addBooking(booking);
        }
        catch(BookingAmountException e){
            e.printStackTrace();
        }


        VehicleService vehicleService=(VehicleService) context.getBean("VehicleService");

        for(Vehicle v:vehicleService.getAllVehicles()) {
            System.out.print(v.getModel()+" "+v.getNo()+" "+v.getColor()+" " +v.getImageUrl()+" "+v.getLocation().getId()+" "+ v.getBooking()+" "+v.getFuelType().getId()+" "+v.getVehicleSub().getId());
        }


        try {
            for(Vehicle v:vehicleService.getVehicleByUserID(users.getId())) {
                System.out.print(v.getModel()+" "+v.getNo()+" "+v.getColor()+" "+v.getImageUrl());
            }
        }
        catch(UserDetailsNotfoundException e){
            e.printStackTrace();
        }
/*


        System.out.println("\n================== Insert ==================\n");


        try {
            UserService userService = (UserService) context.getBean("UserService");
            Users users1 = new Users("Admin", "Admin", "admin@123", "upgrad@gmail.com", "9999999999", 10000.00, adminUserType);
            userService.createUser(users1);
            System.out.println(userService.getUser(users1.getEmailId(),users1.getPassword()));

        }
        catch(UserAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (UserDetailsNotfoundException e) {
            e.printStackTrace();
        }

*/
    }

}

