package user;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class User {
    public String username;
    private UUID userID;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private long phoneNum;
    private String address;
    private ArrayList<Trip> trips;

    public User (String uname, String name1, String name2, String bd, long phoneN, String addr){
        userID = UUID.randomUUID();
        username = uname;
        firstName = name1;
        lastName = name2;
        birthday = LocalDate.parse(bd);
        phoneNum = phoneN;
        address = addr;
        trips = new ArrayList<Trip>();
    }

    @Override
    public String toString(){
        return String.valueOf(lastName) + ", " + String.valueOf(firstName);
    }

    public String getUserId(){
        return userID.toString();
    }

    public Map<String, String> getUserInfo(){
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", username);
        userInfo.put("firstName", firstName);
        userInfo.put("lastName", lastName);
        userInfo.put("birthday", birthday.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        userInfo.put("phoneNum", Long.toString(phoneNum));
        userInfo.put("address", address);

        return userInfo;
    } 

    public void editUser(String userField, String newValue){
        switch(userField){
            case "username":
                username = newValue;
                System.out.println("User updated.");
                break;
            case "firstName":
                firstName = newValue;
                System.out.println("User updated.");
                break;
            case "lastName":
                lastName = newValue;
                System.out.println("User updated.");
                break;
            case "birthday":
                birthday = LocalDate.parse(newValue);
                System.out.println("User updated.");
                break;
            case "phoneNum":
                phoneNum = Long.parseLong(newValue);
                System.out.println("User updated.");
                break;
            case "address":
                address = newValue;
                System.out.println("User updated.");
                break;
            default:
                System.out.println("No change made to user");
        }
    }

    public ArrayList<Trip> getUserTrips(){
        return trips.toString();
    }

    public void addTripToUser(Trip trip){
        trips.add(trip);
        System.out.println("Trip added to user's trips.");
    }

    public void removeTripFromUser(UUID tripID){
        trips.removeIf(t -> t.getTripId().equals(tripID));
        System.out.println("Trip removed from user's trips.");
    }

    public static void main(String[] args){

    }
}