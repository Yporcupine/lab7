
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer implements Comparable<Customer>
{
    // instance variables - replace the example below with your own
    public int arrival;
    public int orderingTime;
    public int giveUpTime;
    public boolean served;
    public boolean left;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int arrival, int orderingTime, int giveUpTime)
    {
        // initialise instance variables
        this.arrival = arrival;
        this.orderingTime = orderingTime;
        this.giveUpTime = giveUpTime;
        served = false;
        left = false;
        
    }

    public int compareTo(Customer customer){
        return this.arrival - customer.arrival;
        
        
    }
}
