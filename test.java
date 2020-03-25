import java.util.*;
/**
* Write a description of class test here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class test
{
  // instance variables - replace the example below with your own
  public Shop newShop;
  public Customers customerline;

  public static void main(String[] args) {
    test ex = new test();
    ex.testing(18000);
  }

  /**
  * Constructor for objects of class test
  */
  public test()
  {

  }

  /**
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
  */
  public void testing(int number)
  {
    Random random = new Random();
    customerline = new CustomerQueue();
    for (int i = 0; i < number; i++) {
      Customer newCustomer = new Customer(random.nextInt(180), (2+random.nextInt(3)), (5+random.nextInt(25)));
      customerline.add(newCustomer);
    }

    newShop = new Shop(customerline, 0);
    System.out.println(newShop.run());
  }
}
