import java.util.*;

class Bus{
    private static Bus instance = null;
    
    private static final int seatCount=48;
    
    public static int getSeatCount(){return seatCount;}
    
    private static Set<Integer> seats = new HashSet<>();
    
    public static boolean setSeats(int seat){
        if (seat<0 || seat> seatCount) 
            throw new IllegalArgumentException("Seat number cannot be negative");
        boolean b;
        if (seats.size()>=seatCount){
            System.out.println("The bus is full");
            return false;
        }
        else {
          if (!seats.contains(seat)){ 
            seats.add(seat);
            return true;
          }
          else{ 
            System.out.println("Seat "+seat+" has been booked");
            return false;
          }
        }
    }
    public static Set<Integer> getSeats(){return seats;}
    
    protected Bus(){}
    
    public static Bus getInstance() {
      if(instance == null) {
         instance = new Bus();
      }
      return instance;
   }
}
