package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;	//PRIMARY KEY


    @Column(nullable = false)
    private Date pickupDate;


    @Column( nullable = false)
    private  Date dropOffDate;

    @Column( nullable = false)
    private Date bookingDate;

    @Column(precision=10, scale=2,nullable = false)
    private double amount;


    @ManyToOne   //foreign key
    private Users users;

    @ManyToOne   //foreign key
    private Location location;

    @ManyToOne  //foreign key
    private Vehicle vehicle;

    public Booking(Date pickupDate, Date dropOffDate, Date bookingDate, double amount) {
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
    }

    public Booking(Date pickupDate, Date dropOffDate, Date bookingDate, double amount, Users users) {
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.users = users;
    }

    public Booking(Date pickupDate, Date dropOffDate, Date bookingDate, double amount, Users users, Location location, Vehicle vehicle) {
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.users = users;
        this.location = location;
        this.vehicle = vehicle;
    }

    public Booking(){

    }
}
