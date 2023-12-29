/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
public class Product 
{
    long number;
    String name;
    String openDate;
    int overDue;
    int bucket;
    double amount;
    
    public Product(long id, String n, String d, int date, double a )
    {
        number = id;
        name = n;
        openDate = d;
        overDue = date;
        amount = a;
        if(0<date&& date <= 30)
        {
            bucket = 1;
        }
        
        else if(30<date&& date <= 60)
        {
            bucket = 2;
        }
        
        else if(60<date && date <= 90)
        {
            bucket = 3;
        }
        
        else if(90<date&& date <= 120)
        {
            bucket = 4;
        }
        
        else
        {
            bucket = 5;
        }
    }
    
    
    public long getID()
    {
        return number;
    }
    
    public int daysOver()
    {
        return overDue;
    }
    
    public String getName()
    {
        return name;
    }
    public double amountOver()
    {
        return amount;
    }
}
