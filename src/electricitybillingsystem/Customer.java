


package electricitybillingsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;




public class Customer extends Person implements Serializable{
    
    
    private int MeterCode  ;
    private String Apartment ,Governorate , Region , Address;
    public  double Reading = 0 ; // el 9rayh bt3'l lma bdf3 bt9l , lma b3ml reading btzyed
    public  double TotalCollected =0 ; // elly btgm3 el flos 
    private static ArrayList<Customer>customers = new ArrayList<Customer>();
    private String DateStr;
    private final String FilePath = "Customer.bin";
    private  int NoOfCustomerInGiza [] = new int[7];
    private  int NoOfCustomerInCairo [] = new int[8];
    private  int NoOfCustomerInCairoAndGiza [] = new int[2];
    
    
    public Customer(){
    }
    public Customer(int mc ,  String Apartment , float cp , float tc ,String datestr , String d)
    {
        this.MeterCode = mc;
        this.Apartment=Apartment;
        //this.CollectPayment=cp;
        //this.Month=m;
        this.TotalCollected=tc; //fyha klam
        this.DateStr=datestr;
        this.Address = d;
    }
    public void setNoOfCustomerInGiza()
    {
        LoadFile();
        for(Customer c : customers){
            if(c.Governorate.equals("Giza")){
                if(c.Region.equals("Warraq"))
                    NoOfCustomerInGiza[0]++;
                else if(c.Region.equals("Agouza"))
                    NoOfCustomerInGiza[1]++;
                else if(c.Region.equals("Al Salam"))
                    NoOfCustomerInGiza[2]++;
                else if(c.Region.equals("Dokii"))
                    NoOfCustomerInGiza[3]++;
                else if(c.Region.equals("El Haram"))
                    NoOfCustomerInGiza[4]++;
                else if(c.Region.equals("Imbaba"))
                    NoOfCustomerInGiza[5]++;
                else if(c.Region.equals("Zamalek"))
                    NoOfCustomerInGiza[6]++;
            }
        }
    }
    public void setNoOfCustomerInCairo()
    {
        LoadFile();
        for(Customer c : customers){
            if(c.Governorate.equals("Cairo")){
                if(c.Region.equals("Old Misr"))
                    NoOfCustomerInCairo[0]++;
                else if(c.Region.equals("Rawd Al-Faraj"))
                    NoOfCustomerInCairo[1]++;
                else if(c.Region.equals("Nasr City"))
                    NoOfCustomerInCairo[2]++;
                else if(c.Region.equals("Downtown Cairo"))
                    NoOfCustomerInCairo[3]++;
                else if(c.Region.equals("Ahmed Helmy"))
                    NoOfCustomerInCairo[4]++;
                else if(c.Region.equals("Sakakini"))
                    NoOfCustomerInCairo[5]++;
                else if(c.Region.equals("Peace"))
                    NoOfCustomerInCairo[6]++;
                else if(c.Region.equals("Khalafawi"))
                    NoOfCustomerInCairo[7]++;
            }
        }
    }
    public final int [] getNoOfCustomerInGiza()
    {
        setNoOfCustomerInGiza();
        return NoOfCustomerInGiza;
    }
    
     public void setNoOfCustomerInCairoAndGiza()
    {
        LoadFile();
        for(Customer c : customers){
            if(c.Governorate.equals("Cairo"))
                NoOfCustomerInCairoAndGiza[0]++;
            else if(c.Governorate.equals("Giza"))
                NoOfCustomerInCairoAndGiza[1]++;
        }
    }
    public int []getNoOfCustomerInCairoAndGiza()
    {
        setNoOfCustomerInCairoAndGiza();
        return NoOfCustomerInCairoAndGiza;
    }
    public int []getNoOfCustomerInCairo()
    {
        setNoOfCustomerInCairo();
        return NoOfCustomerInCairo;
    }
    
    public void setReading(double r)
    {
        this.Reading=r;
    }
    public double getReading()
    {
        return this.Reading;
    }
    public void setAddress(String a)
    {
        this.Address=a;
    }
    public String getAddress()
    {
        return this.Address;
    }
    public void setGovernorate(String d)
    {
        this.Governorate=d;
    }
    public void setRegion(String r)
    {
        this.Region=r;
    }
    public String getGovernorate()
    {
        return this.Governorate;
    }
    public String getRegion()
    {
        return this.Region;
    }
    
    public void setDate(String dateStr)
    {
        this.DateStr=dateStr;
    }
    public String getDate()
    {
        return this.DateStr;
    }
    public void setMeterCode(int mc)
    {
        this.MeterCode=mc;
    }
    public void setApartment(String a)
    {
        this.Apartment=a;
    }
    
    public void setTotalCollected(double tc)
    {
        this.TotalCollected=tc;
    }
    
    public int getMeterCode()
    {
        return this.MeterCode;
    }
    public String getApartment()
    {
        return this.Apartment;
    }
    
    public double getTotalCollected()
    {
        return this.TotalCollected;
    }
    
    
    public boolean CommitToFile()
    {
        return FManager.writeBinary(FilePath, customers);
        
    }
    public void LoadFile()
    {
        customers = (ArrayList<Customer>)FManager.readBinary(FilePath);

        
    }
    public boolean addCustomer()
    {
        LoadFile();
        customers.add(this);
        return CommitToFile();
    }
    public boolean removeCustomer(int MeterCode)
    {
        if(searchCustomer(MeterCode)){
            customers.remove(this);
            return CommitToFile();
        }
        return false;
    }
    public Customer getCustomer(int MeterCode)
    {
        LoadFile();
        for(Customer c : customers)
            if(c.MeterCode==MeterCode)
                return c;
        return null;
    }
    public boolean searchCustomer(int MeterCode)
    {
        LoadFile();
        for(Customer c : customers)
            if(c.MeterCode==MeterCode)
                return true;
        return false;
    }
    public ArrayList<Customer> ListAllCustomer()
    {
        LoadFile();
        return customers;
    }
    
    public int getIndexCustomer(int MeterCode)
    {
        for(int i=0;i<customers.size();i++)
            if(customers.get(i).MeterCode==MeterCode)
                return i;
        return -1;
    }
    public boolean EditInCustomers(int MeterCode)
    {
        if(searchCustomer(MeterCode))
        {
            int index = getIndexCustomer(MeterCode);
            customers.set(index, this);
            return CommitToFile();
        }
        return false;
    }
    public boolean Dublicate(int MeterCode)
    {
        LoadFile();
        for(Customer a : customers)
            if(a.MeterCode==MeterCode)
                return true;
        return false;
    }
    public double CalcTheconsumption(double r)
    {
        if(r<0)
            r*=-1;
        if(r<=50)
            return r*0.13;
        else if(r<=100)
            return r*0.22;
        else if(r<=200)
            return r*0.27;
        else if(r<=350)
            return r*0.55;
        else if(r<=650)
            return r*0.75;
        else if(r<1000)
            return r*1.25;
        else 
            return r*1.35;
            
    }
    public double CalcTotalCollected()
    {
        LoadFile();
        double d =0.0;
        for(Customer c : customers)
            d+=c.getTotalCollected();
        return d;
    }
    
    public boolean EmailAuto(int read)
    {
        if(read<0){
            read*=-1;
            if(read>=500)
                return true;
        }
        return false;
    }
    @Override
    public boolean LogIn(String user , String pass) {
        if(user.equals("Customer@yahoo.com")&&pass.equals("12345678"))
            return true;
        LoadFile();
        for(Customer a : customers)
            if(a.Email.equals(user)&&a.Password.equals(pass))
                return true;
        return false;
    }
    
}
