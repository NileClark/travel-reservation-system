import java.util.ArrayList;
import java.util.Scanner;

import airline.*;
import user.*;
import accomodation.*;

public class App {
    private ArrayList<Hotel> allHotels;
    private ArrayList<Airline> allAirlines;
    private ArrayList<User> allUsers;
    // int[][] roomNums = {{101, 2},{102, 2},{201, 4},{202, 4},{301, 4},{302, 4}};
    // Hotel marriott;
    // Hotel hilton;
    // Hotel motel6;
    // Hotel radisson;

    public App(){
        allHotels = new ArrayList<Hotel>();
        allAirlines = new ArrayList<Airline>();
        allUsers = new ArrayList<User>();
        // marriott = new Hotel("marriott", "Seattle", 5558475L, roomNums);
  
        // hilton = new Hotel("hilton", "Downtown Seattle", 5558475L, roomNums);
        // allHotels.add(hilton);
        // motel6 = new Hotel("motel6", "Seatac", 5558475L, roomNums);
        // allHotels.add(motel6);
        // radisson = new Hotel("radisson", "Seattle", 5558475L, roomNums);
        // allHotels.add(radisson);

    }

    public String viewAllHotels(){
        return allHotels.toString();
    }

    public String viewAllAirlines(){
        return allAirlines.toString();
    }

    public String viewAllUsers(){
        return allUsers.toString();
    }

    public void addHotel(Hotel hotelToAdd){
        allHotels.add(hotelToAdd);
    }

    public static void main(String[] args) {
        int[][] roomNums = {{101, 2},{102, 2},{201, 4},{202, 4},{301, 4},{302, 4}};
        App myApp = new App();
        Hotel marriott = new Hotel("The Marriott", "Seattle", 5558475L, roomNums);
        Hotel hilton = new Hotel("The Hilton", "Portland", 5558475L, roomNums);
        Hotel motel6 = new Hotel("Motel6", "Sacramento", 5558475L, roomNums);
        Hotel radisson = new Hotel("The Radisson", "San Francisco", 5558475L, roomNums);
       
        myApp.addHotel(marriott);
        myApp.addHotel(hilton);
        myApp.addHotel(motel6);
        myApp.addHotel(radisson);
        System.out.println(myApp.viewAllHotels());
        
    }
}