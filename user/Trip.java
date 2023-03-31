package user;
import java.util.UUID;

import accomodation.Reservation;
import airline.Flight;

public class Trip {

    private UUID tripId;
    private Flight flightInfo;
    private Reservation hotelResInfo;

    public Trip () {
        tripId = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "Flight: " + flightInfo.toString() + ", " + String.valueOf(lastName);
    }


    public UUID getTripId(){
        return tripId;
    }

    public Object[] getTripInfo(){
        Object[] tripInfo = {flightInfo, hotelResInfo};
        return tripInfo;
    }

    public void updateTripDetails(String tripCase, Flight flight, Reservation res){
        switch (tripCase) {
            case "flight":
               flightInfo = flight;
               hotelResInfo = null;
               System.out.println("A flight has been added to your trip.");
               break;
            case "hotel":
                flightInfo = null;
                hotelResInfo = res;
                System.out.println("A hotel reservation has been added to your trip.");
                break;
            case "both":
                flightInfo = flight;
                hotelResInfo = res;
                System.out.println("Both a flight and a hotel reservation have been added to your trip.");
                break;
            default:
                System.out.println("Details have not been added to your trip.");
        }
    }

    public static void main(String[] args){

    }
}