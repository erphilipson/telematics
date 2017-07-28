package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Ethan on 7/21/17.
 */

public class TelematicsService {

    void report(VehicleInfo vehicleInfo) throws IOException {

        int vin = 0;
        double totalOdometer = 0;
        double totalConsumption = 0;
        double totalOdoLastOilChange = 0;
        double totalEngineLiters = 0;

        int numCars = 0;
        String html= "";
        String htmlRows = "";



        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(vehicleInfo);

        File jsonFile = new File(vehicleInfo.getVin() + ".json");

        FileWriter fileWriter = new FileWriter(jsonFile);
        fileWriter.write(json);
        fileWriter.close();


        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

//                CONVERTING TO STRINGS SO replace() CAN BE USED
                String vinString = "" + vi.getVin();
                String odometerString = "" + vi.getOdometer();
                String consumptionString = "" + vi.getConsumption();
                String odoLastOilChangeString = "" + vi.getOdometerLastOilChange();
                String englineLitersString = "" + vi.getEngineLiters();

//                CREATES ALL TABLE ROWS
                htmlRows += addRow(vinString, odometerString, consumptionString, odoLastOilChangeString, englineLitersString);

                html = "<html>\n" +
                        "<title>Vehicle Telematics Dashboard</title>\n" +
                        "<body>\n" +
                        "<h1 align=\"center\">Averages for # vehicles</h1>\n" +
                        "<table align=\"center\">\n" +
                        "    <tr>\n" +
                        "        <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td align=\"center\">!</td><td align=\"center\">@</td><td align=\"center\">$</td align=\"center\"><td align=\"center\">%</td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "<h1 align=\"center\">History</h1>\n" +
                        "<table align=\"center\" border=\"1\">\n" +
                        "    <tr>\n" +
                        "        <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "    </tr>\n" +
                        htmlRows +
                        "    <tr>\n" +
//                        "        <td align=\"center\">VIN</td><td align=\"center\">!!</td><td align=\"center\">@@</td><td align=\"center\">$$</td align=\"center\"><td align=\"center\">%%</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "</body>\n" +
                        "</html>";

                totalOdometer += vi.getOdometer();
                totalConsumption += vi.getConsumption();
                totalOdoLastOilChange += vi.getOdometerLastOilChange();
                totalEngineLiters += vi.getEngineLiters();

                numCars += 1;

            }
        }

        String numCarsString = "" + numCars;
        String avgOdomoter = "" + totalOdometer / numCars;
        String avgConsumption = "" + totalConsumption / numCars;
        String avgOdoLastOilChange = "" + totalOdoLastOilChange / numCars;
        String avgTotalEngineLiters = "" + totalEngineLiters / numCars;


//        # = numCars | ! = avgOdometer | @ = avgConsumption | $ = avgOdoLastOilChange | % = avgTotalEngineLiters
//        VIN = each VIN | !! = each odometer | @@ = each consumption | $$ = each last oil | %% = each engine size

        html = html.replace("#", numCarsString);
        html = html.replace("!", avgOdomoter);
        html = html.replace("@", avgConsumption);
        html = html.replace("$", avgOdoLastOilChange);
        html = html.replace("%", avgTotalEngineLiters);

        System.out.println(html);

        FileWriter fw = new FileWriter("test.html");
        fw.write(html);
        fw.close();


    }
    
    public String addRow(String vinString, String odometer, String consumption, String odoLastOilChange, String engineLiters) {
        String htmlRow = "<tr><td align=\"center\">VIN</td><td align=\"center\">!!</td><td align=\"center\">@@</td><td align=\"center\">$$</td align=\"center\"><td align=\"center\">%%</td></tr>";
        htmlRow = htmlRow.replace("VIN", vinString);
        htmlRow = htmlRow.replace("!!", odometer);
        htmlRow = htmlRow.replace("@@", consumption);
        htmlRow = htmlRow.replace("$$", odoLastOilChange);
        htmlRow = htmlRow.replace("%%", engineLiters);

        return htmlRow;
    }
}


