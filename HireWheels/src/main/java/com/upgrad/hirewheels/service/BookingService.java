package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.BookingAmountException;

public interface BookingService {

    Booking addBooking(Booking booking) throws BookingAmountException;
}
