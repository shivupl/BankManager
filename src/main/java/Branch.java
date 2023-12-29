
import java.util.PriorityQueue;

public class Branch 
{
    String location;
    int number;
    PriorityQueue<Customer> list;
    
    public Branch(String l, int n)
    {
        list = new PriorityQueue<>();
        location = l;
        number = n;
    }
    
    public void add(Customer c)
    {
        list.add(c);
    }
    
}
