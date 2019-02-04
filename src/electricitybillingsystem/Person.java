


package electricitybillingsystem;

import java.io.Serializable;



public abstract class Person implements Serializable{
    
    protected int ID;
    protected String Email , PhoneNo ,Gender;
    protected double Salary;
    protected String UserName,Password;
    protected FileMangerBinary FManager = new FileMangerBinary();
    public Person(){
        
    }
    public Person(int id, String e , String PN , double s,String UserName,String Password ,String g)
    {
        this.Email=e;
        this.ID=id;
        this.PhoneNo=PN;
        this.Salary=s;
        this.UserName=UserName;
        this.Password=Password;
        this.Gender=g;
    }
   
    public void setGender(String g)
    {
        this.Gender=g;
    }
    public String getGender()
            
    {
        return this.Gender;
    }
    public void setUserName(String un)
    {
        this.UserName=un;
    }
    public void setPassword(String p)
    {
        this.Password=p;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public void setID(int id)
    {
        this.ID=id;
    }
    
    public void setPhoneNo(String pn)
    {
        this.PhoneNo=pn;
    }
    public void setSalary(double s)
    {
        this.Salary=s;
    }
    public void setEmail(String e)
    {
        this.Email=e;
    }
    
    public String getEmail()
    {
        return this.Email;
    }
    public String getPhoneNo()
    {
        return this.PhoneNo;
    }
    public int getID()
    {
        return this.ID;
    }
    public double getSalary()
    {
        return this.Salary;
    }
    
    
    public abstract boolean LogIn(String user , String pass);
    
    
}
