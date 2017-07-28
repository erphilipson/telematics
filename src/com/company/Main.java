package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        VehicleInfo vehicleInfo = new VehicleInfo();
        TelematicsService telematicsService = new TelematicsService();

        telematicsService.report(vehicleInfo);

        System.out.println("What is your car's VIN?");
        vehicleInfo.setVin(Integer.parseInt(scanner.nextLine()));

        System.out.println("How many miles has your car travelled?");
        vehicleInfo.setOdometer(scanner.nextDouble());

        System.out.println("How many gallons of fuel has your car consumed?");
        vehicleInfo.setConsumption(scanner.nextDouble());

        System.out.println("What was your odometer reading for your last oil change?");
        vehicleInfo.setOdometerLastOilChange(scanner.nextDouble());

        System.out.println("What is your engine size in liters?");
        vehicleInfo.setEngineLiters(scanner.nextDouble());

    }
}
