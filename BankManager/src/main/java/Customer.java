
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
public class Customer implements Comparable<Customer>
{
    long number;
    String nationality;
    int branchNum;
    Product card;
    
    public Customer(long id, String n, int b, Product p)
    {
        card = p;
        number = id;
        nationality = n;
        branchNum = b;
    }
    
    
    public long getID()
    {
        return number;
    }
    
    public String getNationality()
    {
        return nationality;
    }
    
    public int getBranch()
    {
        return branchNum;
    }
    

    @Override
    public int compareTo(Customer o)
    {
        if(this.card.bucket>o.card.bucket)
        {
            return -1;
        }
        else if(this.card.bucket<o.card.bucket)
        { 
            return 1;
        }
        else
        {
            if(this.card.amount < o.card.amount)
            {
                return 1;
            }
            else if(this.card.amount > o.card.amount)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
    
}
