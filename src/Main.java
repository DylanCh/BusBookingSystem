import java.util.*;

public class Main{
  
    private static Bus bus = Bus.getInstance();
    private static Map<Integer,Passenger> busSeats = new HashMap<>();
    private static int count=0;
    public static void main(String[] args){
      
        Thread t1 = new Thread(new Runnable() {
          public void run(){
            // reserve 3 seats for 3 people 
               assignSeats(16, new Passenger("John Doe"));
               assignSeats(17, new Passenger("Donald T"));
               assignSeats(1, new Passenger("Chris B"));
               count+=3;
               Scanner scanner = new Scanner(System.in);
               while (count<Bus.getSeatCount()){
                 System.out.println("Enter a seat number you want to book: ");
                 int seat = scanner.nextInt();
                 System.out.println("Enter your name: ");
                 String name = scanner.next();
                 assignSeats(seat,new Passenger(name));
                 
               }
               
               System.out.println(Bus.getSeats().size()+" seats are booked.");
               count=0;
          }}); 
          
          t1.start();
    }
    
    private static void assignSeats(int seat, Passenger passenger){
        boolean b = bus.setSeats(seat);
        if (b){
            busSeats.put(seat,passenger);
            count++;
        }
    }
}
