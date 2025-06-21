package com.programming.systemdesign.lowleveldesign.parkinglot;

public interface FeeStrategy {

    double calculateFee(Ticket ticket, long exitTime);
}
