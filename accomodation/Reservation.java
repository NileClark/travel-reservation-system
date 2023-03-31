package accomodation;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import user.User;

public class Reservation {
    private UUID resId;
    private LocalDate dateMade;
    private LocalDate dateUpdated;
    private User guest;
    private Room reservedRoom;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numGuests;

    public Reservation(User u, Room r, String ci, String co, int g){
        resId = UUID.randomUUID();
        dateMade = LocalDate.now();
        dateUpdated = null;
        guest = u;
        reservedRoom = r;
        checkIn = LocalDate.parse(ci);
        checkOut = LocalDate.parse(co);
        numGuests = g;
    }

    // to out print reservation information for user consumption
    @Override
    public String toString(){
        String reservationUpdateText = "This reservation was modified on " + String.valueOf(dateUpdated) + ".";
        return guest.toString() + " made a reservation for " + String.valueOf(numGuests) + ". Check in:  " + String.valueOf(checkIn) + ", check out: " + String.valueOf(checkOut) + ". This reservation was made on " + String.valueOf(dateMade) + ". " + 
        dateUpdated == null ? "This reservation has never been modified. "
        : reservationUpdateText; 
    }


    public String getResId(){
        return resId.toString();
    }

    // to return data for programmatic use
    public Map<String, Object> getReservationInfo(){
        Map<String, Object> reservationInfo = new HashMap<>();
        reservationInfo.put("guest", guest);
        reservationInfo.put("reservedRoom", reservedRoom);
        reservationInfo.put("checkIn", checkIn);
        reservationInfo.put("checkOut", checkOut);
        reservationInfo.put("numGuests", numGuests);
        reservationInfo.put("dateMade", dateMade);
        if(dateUpdated != null){
            reservationInfo.put("dateUpdated", dateUpdated); 
        }
        return reservationInfo;
    }

    public void editReservation(String resField, Object newValue){
        switch(resField){
            case "reservedRoom":
                reservedRoom = (Room) newValue;
                dateUpdated = LocalDate.now();
                System.out.println("Reservation updated.");
                break;
            case "checkIn":
                checkIn = LocalDate.parse((CharSequence) newValue);// 'yyyy-mm-dd'
                dateUpdated = LocalDate.now();
                System.out.println("Reservation updated.");
                break;
            case "checkOut":
                checkOut = LocalDate.parse((CharSequence) newValue);// 'yyyy-mm-dd'
                dateUpdated = LocalDate.now();
                System.out.println("Reservation updated.");
                break;
            case "numGuests":
                numGuests = Integer.parseInt((String)newValue); // needs to be string
                dateUpdated = LocalDate.now();
                System.out.println("Reservation updated.");
                break;
            default:
                System.out.println("No change made to reservation.");
        }
    }

    public static void main(String[] args){

    }
}