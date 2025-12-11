package utils;
import java.util.*;
public class IDGenerator {
    private static int counteruser=0;
    private static int counterbook=0;
    private static int countertransaction=0;
    private static int counterreservation=0;

    public static long GenerateUserId() {
        counteruser++;
        return (long)counteruser;
    }
    
    public static long GenerateBookId() {
        counterbook++;
        return (long)(counterbook);
    }
    
    public static long GenerateTransactionId(){
        countertransaction++;
        return (long)countertransaction;
    }
    
    public static long GenerateReservationId(){
        counterreservation++;
        return (long)counterreservation;
    }
}
