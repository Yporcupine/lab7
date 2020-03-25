import java.util.*;
/**
 * Write a description of class CustomerQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerQueue extends PriorityQueue<Customer> implements Customers
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class CustomerQueue
     */
    public CustomerQueue()
    {
    }

    public CustomerQueue(ArrayList<Customer> groupCustomer){
    }

    /**
    * Retrieves and removes the head of this queue.
    *
    * @return    the head of this queue
    */
    public Customer pop(){
      return remove();
    }
}
