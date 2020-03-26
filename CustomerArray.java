import java.util.*;
/**
* Write a description of class CustomerArray here.
*
* @author YuehaoZhu
* @version 3/25/2020
*/
public class CustomerArray implements Customers
{
  // instance variables
  ArrayList<Customer>[] customerArray;
  int customerNumber;


  /**
  * Constructor for objects of class CustomerArray
  */
  public CustomerArray(int length)
  {
    // initialise instance variables
    customerArray = new ArrayList[length];
    customerNumber = 0;
  }

  /**
  * adds a customer into the customer array
  *
  * @param  customer  the customer to be added into the customer array
  * @return    true if add is successful
  */
  public boolean add(Customer customer)
  {
    if(customerArray[customer.arrival] == null){
      customerArray[customer.arrival] = new ArrayList<Customer>();
      customerArray[customer.arrival].add(customer);
    }else{
      customerArray[customer.arrival].add(customer);
    }
    customerNumber+=1;
    return true;
  }

  /**
  * to check if the customer array instance is empty
  *
  *
  * @return    true if the customer array is empty
  */
  public boolean isEmpty(){
    if(customerNumber == 0) return true;
    else return false;
  }


  /**
  * removes the first customer that is left in the customer array
  *
  *
  * @return   the customer that is removed
  */
  public Customer pop(){
    if(!isEmpty()){
      Customer done = customerArray[currentPosition()].get(0);
      customerArray[currentPosition()].remove(0);
      customerNumber--;
      return done;
    }else return null;
  }

  /**
  * returns the first customer left in the customer array
  *
  *
  * @return    the first customer left in the customer array
  */
  public Customer peek(){
    if(customerNumber == 0){
      return null;
    }else return customerArray[currentPosition()].get(0);
  }
  /**
  * returns the number of customers left in the customer array
  *
  * @return    the number of customers left in the customer array
  */
  public int size(){
    return customerNumber;
  }


  private int currentPosition(){
    int currentPosition = 0;
    for (int i = 0; i < customerArray.length; i++) {
      if(customerArray[i] == null){
        currentPosition++;
      }else if(customerArray[i].isEmpty()){
        currentPosition++;
      }else break;
    }
    return currentPosition;
  }
}
