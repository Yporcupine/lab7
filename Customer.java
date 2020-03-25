
/**
* Write a description of class Customer here.
*
* @author Yuehao Zhu
* @version 3/25/2020
*/
public class Customer implements Comparable<Customer>
{
  // instance variables - replace the example below with your own
  public int arrival;
  public int orderingTime;
  public int giveUpTime;
  public int ordering;
  public boolean served;
  public boolean left;
  public boolean serving;

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
    serving = false;
    ordering = 0;

  }

  /**
  * compares each instance of customer by its arrival time
  *
  * @param  customer  the customer to be added into the customer array
  * @return    the difference of the two compared
  */
  public int compareTo(Customer customer){
    return this.arrival - customer.arrival;
  }

  /**
  * updates the state(whether the customer is served, or whether the customer left)
  *
  * @param  currentTime the minute from 11AM that the customer's state is being updated
  *
  */
  public void states(int currentTime){
    if((currentTime-arrival)>=giveUpTime && !serving){
      left = true;
    }else if(serving && ordering == orderingTime){
      served = true;
    }
  }
}
