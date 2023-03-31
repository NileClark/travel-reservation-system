package airline;
import java.util.UUID;
import java.util.ArrayList;
import java.time.*;

import user.User;

public class Flight {
    private UUID flightId;
    String name;
    private LocalDate flightDate;
    private LocalTime flightTime;
    private int totalSeats;
    private int seatsRemaining;
    private ArrayList<User> passengers;
    
    public Flight(String n, int s, String fd, int[] ft, ZoneId tz){
        flightId = UUID.randomUUID();
        name = n;
        flightDate = LocalDate.parse(fd);
        flightTime = LocalDateTime.of(LocalDate.parse(fd), LocalTime.of(ft[0], ft[1])).atZone(tz).withZoneSameInstant(ZoneOffset.UTC)
        .toLocalTime();
        totalSeats = s;
        seatsRemaining = s;
    }

    @Override
    public String toString(){
        return String.valueOf(name) + ": " + String.valueOf(seatsRemaining) + " seats remaining.";
    }

    private String printFlightInfo(){
        return String.valueOf(name) + ": " + String.valueOf(seatsRemaining) + " seats remaining.";
    }

    public String getUserId(){
        return flightId.toString();
    }



    public static void main(String[] args){
        
    }
}