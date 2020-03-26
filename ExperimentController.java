import java.util.*;
import java.io.*;
/**
* Write a description of class ExperimentController here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class ExperimentController
{
  // instance variables - replace the example below with your own
  public Shop newShop;

  /**
  * Constructor for objects of class ExperimentController
  */
  public ExperimentController()
  {
  }

  public static void main(String[] args) {
    ExperimentController experiment = new ExperimentController();
    experiment.noonAndBefore();

  }
  /**
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
  */
  private long generateCustomers(int number, Customers customerline,int seed)
  {
    Random random = new Random(seed);
    long addingTime = 0;
    for (int i = 0; i < number; i++) {
      Customer newCustomer = new Customer(random.nextInt(180), (2+random.nextInt(4)), (5+random.nextInt(26)));
      Long startTime = System.nanoTime();
      customerline.add(newCustomer);
      long stopTime = System.nanoTime();
      addingTime += stopTime - startTime;
    }
    return addingTime;
  }

  private long shopRun(int openingTime, Customers customerline){
    newShop = new Shop(customerline, openingTime);
    Long startTime = System.nanoTime();
    newShop.run();
    long stopTime = System.nanoTime();
    return stopTime - startTime;
  }

  public void timeTest(){
    try {
      Random random = new Random(10);
      Customers array = new CustomerArray(180);
      Customers queue = new CustomerQueue();
      File runta = new File("runningTimeArray.csv");
      File runtq = new File("runningTimeQueue.csv");
      PrintWriter addingTimeArray = new PrintWriter("addingTimeArray.csv");
      PrintWriter addingTimeQueue = new PrintWriter("addingTimeQueue.csv");
      PrintWriter runningTimeArray = new PrintWriter("runningTimeArray.csv");
      PrintWriter runningTimeQueue = new PrintWriter("runningTimeQueue.csv");
      for (int i = 1; i < 21; i++) {
        for (int j = 0; j < 5; j++) {
          int seed = random.nextInt();
          addingTimeArray.println(generateCustomers(10000*i, array, seed));
          addingTimeQueue.println(generateCustomers(10000*i, queue, seed));
          runningTimeArray.println(shopRun(0, array));
          runningTimeQueue.println(shopRun(0, queue));
        }
      }
      addingTimeArray.close();
      addingTimeQueue.close();
      runningTimeArray.close();
      runningTimeQueue.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }

  public void noonAndBefore(){
    try{
      PrintWriter shopRunAtNoon = new PrintWriter("shopRunAtNoon.csv");
      PrintWriter shopRunAt11 = new PrintWriter("shopRunAt11.csv");
      Random random = new Random(10);
      for (int j = 0; j < 100; j++) {
        Customers newQueue = new CustomerQueue();
        for (int i = 0; i < 100; i++) {
          Customer newCustomer = new Customer(random.nextInt(180), (2+random.nextInt(4)), (5+random.nextInt(26)));
          newQueue.add(newCustomer);
        }
        Shop shopNoon = new Shop(newQueue, 60);
        shopRunAtNoon.println(shopNoon.run());
      }
      random = new Random(10);
      for (int j = 0; j < 100; j++) {
        Customers newQueue = new CustomerQueue();
        for (int i = 0; i < 100; i++) {
          Customer newCustomer = new Customer(random.nextInt(180), (2+random.nextInt(4)), (5+random.nextInt(26)));
          newQueue.add(newCustomer);
        }
        Shop shop11 = new Shop(newQueue, 0);
        shopRunAt11.println(shop11.run());
      }

      shopRunAtNoon.close();
      shopRunAt11.close();
    } catch (Exception e) {
      System.out.print(e);
    }


  }
}
