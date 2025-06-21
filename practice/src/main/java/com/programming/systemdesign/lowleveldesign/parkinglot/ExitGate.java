package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.Date;

public class ExitGate {

    private int gateId;

    public ExitGate(int gateId) {
        this.gateId = gateId;
    }

    public int getGateId() {
        return gateId;
    }

    public double processExit(Ticket ticket) {
        FeeStrategy feeStrategy = new HourlyRateFeeStrategy();
        return feeStrategy.calculateFee(ticket, new Date().getTime());
    }
}
