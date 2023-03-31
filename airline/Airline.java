package airline;
import java.util.ArrayList;
import java.util.UUID;


public class Airline {
    private UUID airlineId;
    public String name;
    public String location;
    private ArrayList<Flight> allFlights;

    public Airline(String n, String l){
        airlineId = UUID.randomUUID();
        name = n;
        location = l;
        allFlights = new ArrayList<Flight>();
    }

    @Override
    public String toString(){
        return String.valueOf(name);
    }
    public static void main(String[] args){
        
    }
}