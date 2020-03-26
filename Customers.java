
/**
* interface for CustomerArray and CustomerQueue
*
* @author Yuehao Zhu
* @version 3/25/2020
*/
public interface Customers
{

    
    public boolean add(Customer customer);
    public boolean isEmpty();
    public Customer pop();
    public Customer peek();
    public int size();
}
