import java.util.*;
/**
* Write a description of class Shop here.
*
* @author (your name)
* @version (a version number or a date)
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
    customerIn= customerline;
    total = customerline.size();
  }

  /**
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
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
