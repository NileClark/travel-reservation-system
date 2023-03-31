package accomodation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

import user.User;

public class Hotel {
    private UUID hotelId;
    private String name;
    private String address;
    private Long phoneNum;
    private Room[] allRooms;
    private ArrayList<Reservation> allReservations;
    // private ArrayList<Room> availableRooms;

    public Hotel(String n, String ad, Long pn, int[][] rooms) {
        hotelId = UUID.randomUUID();
        name = n;
        address = ad;
        phoneNum = pn;
        allRooms = createRooms(rooms);
        allReservations = new ArrayList<Reservation>();
        // availableRooms = new ArrayList<Room>(Arrays.asList(allRooms));
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public String printReservationInfo(Reservation res) {

        return "The reservation was made at " + this.toString() + ". " + res.toString();
    }

    public Room[] createRooms(int[][] args) {
        Room[] newRooms = new Room[args.length];

        for (int i = 0; i < args.length; i++) {
            Room newRoom = new Room(args[i][0], args[i][1]);
            newRooms[i] = newRoom;
        }
        System.out.println("Rooms create!");
        return newRooms;
    }

    public String getHotelId() {
        return hotelId.toString();
    }

    public Map<String, Object> getHotelInfo() {
        Map<String, Object> hotelInfo = new HashMap<>();
        hotelInfo.put("name", name);
        hotelInfo.put("address", address);
        hotelInfo.put("phoneNum", Long.toString(phoneNum));
        hotelInfo.put("allRooms", allRooms);

        return hotelInfo;
    }

    public void makeReservation(User u, Room r, String ci, String co, int g) {
        Reservation newRes = new Reservation(u, r, ci, co, g);
        if (!allReservations.contains(newRes)) {
            allReservations.add(newRes);
            System.out.println("New reservation made for " + u.username);
        } else {
            newRes = null;
            System.out.println("Reservation already exists.");
        }

    }

    public ArrayList<LocalDate> getDateRange(LocalDate startDate, LocalDate endDate) {
        // Getting the range of dates to check
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        ArrayList<LocalDate> dateRange = IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toCollection(ArrayList::new));
        return dateRange;
    }

    public ArrayList<Room> checkAvailableRooms(String proposedCheckIn, String proposedCheckOut) {
        // checks proposed reservation dates against dates in current active
        // reservations. If there is conflict, removes the room from the list of rooms,
        // returns rooms that are not currently reserved during time period
        LocalDate startDate = LocalDate.parse(proposedCheckIn);
        LocalDate endDate = LocalDate.parse(proposedCheckOut);

        ArrayList<LocalDate> datesToCheck = getDateRange(startDate, endDate);

        // ArrayList<Room> roomsReserved = new ArrayList<Room>();

        ArrayList<Room> roomsAvailable = new ArrayList<Room>(Arrays.asList(allRooms));

        for (Reservation res : allReservations) {
            Map<String, Object> currentRes = res.getReservationInfo();

            ArrayList<LocalDate> resDates = getDateRange(LocalDate.parse((CharSequence) currentRes.get("checkIn")),
                    LocalDate.parse((CharSequence) currentRes.get("checkOut")));

            for (LocalDate date : datesToCheck) {
                if (resDates.contains(date)) {
                    roomsAvailable.remove(currentRes.get("reservedRoom"));
                }
            }
        }

        return roomsAvailable;
    }

    public static void main(String[] args) {

    }
}