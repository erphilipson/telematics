package com.company;

/**
 * Created by Ethan on 7/21/17.
 */
public class VehicleInfo {
    private int vin;
    private double odometer;
    private double consumption;
    private double odometerLastOilChange;
    private double engineLiters;

    public VehicleInfo() {
        this.vin = vin;
        this.odometer = odometer;
        this.consumption = consumption;
        this.odometerLastOilChange = odometerLastOilChange;
        this.engineLiters = engineLiters;
    }

    public int getVin() {
        return vin;
    }

    public double getOdometer() {
        return this.odometer;
    }

    public double getConsumption() {
        return this.consumption;
    }

    public double getOdometerLastOilChange() {
        return this.odometerLastOilChange;
    }

    public double getEngineLiters() {
        return this.engineLiters;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setOdometerLastOilChange(double odometerLastOilChange) {
        this.odometerLastOilChange = odometerLastOilChange;
    }

    public void setEngineLiters(double engineLiters) {
        this.engineLiters = engineLiters;
    }
}
