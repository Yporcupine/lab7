import java.util.*;
/**
* initiates an object that can simulate the action happenning in the coffee shop
*
* @author Yuehao Zhu
* @version 3/25/2020
*/
public class Shop
{
  // instance variables - replace the example below with your own
  Customers customerIn;
  int time;
  int total;

  /**
  * Constructor for objects of class Shop
  */
  public Shop(Customers customerline, int startTime)
  {
    time = startTime;
    customerIn = customerline;
    total = customerline.size();
  }

  /**
  * simulates the action happenning in the coffee shop
  *
  *
  * @return    the number of customer served and the average waiting time for each customer
  */
  public String run()
  {
    int givenUp = 0;
    int customerServed = 0;
    float waitingTime = 0;
    while (!customerIn.isEmpty()) {
      Customer current = customerIn.peek();
      if(time < current.arrival){
        time++;
        continue;
      }else current.states(time);
      if(current.left == true){
        waitingTime += (float)current.giveUpTime;
        customerIn.pop();
        givenUp++;
        continue;
      }else if(current.served == true){
        waitingTime += (float)(time - current.orderingTime - current.arrival);
        customerIn.pop();
        customerServed++;
        continue;
      }else{
        current.serving = true;
        current.ordering++;
        time++;
      }
    }

    float waitingTimeAverage = waitingTime / total;

    return Integer.toString(customerServed) +"  " + String.format("%.2f", waitingTimeAverage);
  }
}
