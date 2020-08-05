package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Location")
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;	//PRIMARY KEY


    @Column( nullable = false)
    private String location;


    @Column( nullable = false)
    private String address;


    @Column( nullable = false)
    private String pinCode;



    @ManyToOne //FOREIGN KEY
    private City city;


    public Location(){

    }

    public Location(String location, String address,City city, String pincode) {
        this.location = location;
        this.address = address;
        this.pinCode = pincode;
        this.city = city;
    }

    @OneToMany(mappedBy = "location" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "location" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Vehicle> vehicle;


    public Location(String location, String address,String pincode) {
        this.location = location;
        this.address = address;
        this.pinCode = pincode;

    }
}
