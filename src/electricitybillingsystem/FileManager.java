


package electricitybillingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class FileManager {
    
    public boolean Write(String Query , String FilePath , boolean Appeand)
    {
        PrintWriter writter = null;
        try
        {
            System.out.print("\nWritting from ' "+FilePath);
            writter = new PrintWriter(new FileWriter (new File(FilePath),Appeand));
            writter.println(Query);
            System.out.println(" ' Done ... !");
            return true;
        }
        catch(IOException e)
        {
            System.out.println("Error in writting : "+e.getMessage());
        }
        finally
        {
            writter.close();
        }
        return false;
    }
    
    public ArrayList<Object> Read(String FilePath)
    {
        Scanner Reader = null;
        try
        {
            System.out.print("\nReading From "+FilePath);
            Reader = new Scanner(new File(FilePath));
            System.out.println("  ...! ");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error in Reading ... !");
        }
        if(FilePath.equals("Admin.txt"))
        {
            ArrayList<Admin> admins = new ArrayList<Admin>();
            Admin a ;
            while(Reader.hasNext()){
                a = new Admin();
                String Line = Reader.nextLine();
                String Sepreted [] = Line.split("`");
                // ID ` Age ` Salary ` Name ` Email ` PhoneNo ` username ` password ` Gender ` Quali `
                a.setID(Integer.parseInt(Sepreted[0]));
                a.setSalary(Double.parseDouble(Sepreted[2]));
                a.setEmail(Sepreted[4]);
                a.setPhoneNo(Sepreted[5]);
                a.setUserName(Sepreted[6]);
                a.setPassword(Sepreted[7]);
                a.setGender(Sepreted[8]);
                admins.add(a);
            }
            return (ArrayList<Object>)(Object)admins;
        }
        else if(FilePath.equals("Employee.txt"))
        {
            ArrayList<Employee> employees = new ArrayList<Employee>();
            Employee e ;
            while(Reader.hasNext()){
                e = new Employee();
                String Line = Reader.nextLine();
                String Sepreted [] = Line.split("`");
                // ID ` Age ` Salary ` Name ` Email ` PhoneNo ` username ` password `  gender ` qual `
                e.setID(Integer.parseInt(Sepreted[0]));
                e.setSalary(Double.parseDouble(Sepreted[2]));
                e.setEmail(Sepreted[4]);
                e.setPhoneNo(Sepreted[5]);
                e.setUserName(Sepreted[6]);
                e.setPassword(Sepreted[7]);
                e.setGender(Sepreted[8]);
                employees.add(e);
            }
            return (ArrayList<Object>)(Object)employees;
        }
        else if(FilePath.equals("Customer.txt"))
        {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            Customer c ;
            while(Reader.hasNext()){
                c = new Customer();
                String Line = Reader.nextLine();
                String Sepreted [] = Line.split("`");
// ID ` Age ` Name ` Email ` PhoneNo ` username ` password ` MesterCode ` 
// Apartment ` TotalCollected ` gender ` qual ` Date ` Governorate ` Region `
// Address ` Reading `
                c.setID(Integer.parseInt(Sepreted[0]));
                c.setEmail(Sepreted[3]);
                c.setPhoneNo(Sepreted[4]);
                c.setUserName(Sepreted[5]);
                c.setPassword(Sepreted[6]);
                c.setMeterCode(Integer.parseInt(Sepreted[7]));
                c.setApartment(Sepreted[8]);
                c.setTotalCollected(Double.parseDouble(Sepreted[9]));
                c.setGender(Sepreted[10]);
                c.setDate(Sepreted[12]);
                //c.setGovernorate(Sepreted[13]);
                /* if(Sepreted[13].equals("Giza")){
                    c.setNoOfCustomerInGiza(Sepreted[14]);
                    c.setNoOfCustomerInCairoAndGiza(Sepreted[13]);
                }
                else if(Sepreted[13].equals("Cairo")){
                    c.setNoOfCustomerInCairo(Sepreted[14]);
                    c.setNoOfCustomerInCairoAndGiza(Sepreted[13]);
                } */
                c.setRegion(Sepreted[14]);
                c.setAddress(Sepreted[15]);
                c.setReading(Double.parseDouble(Sepreted[16]));
                customers.add(c);
            }
            return (ArrayList<Object>)(Object)customers;
        }
        else if(FilePath.equals("Email.txt")){
            ArrayList<Mail> mails = new ArrayList<Mail>();
            Mail m ;
            while(Reader.hasNext()){
                m = new Mail();
                String Line = Reader.nextLine();
                String Seprated[]=Line.split("`");
                
                // ToEmail ` CcEmail ` Subject ` Emailbody `
                
                m.setToEmail(Seprated[0]);
                m.setCcEmail(Seprated[1]);
                m.setSubject(Seprated[2]);
                m.setEmailbody(Seprated[3]);
                mails.add(m);
            }
            return (ArrayList<Object>)(Object)mails;
            
        }
        
        return null;
    }
    
}
