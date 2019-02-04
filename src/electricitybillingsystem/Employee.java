


package electricitybillingsystem;

import java.io.Serializable;
import java.util.ArrayList;





public class Employee extends Person implements Serializable{
    
    
    private static ArrayList<Employee>employees = new ArrayList<Employee>();
    private final String FilePath = "Employee.bin";
        
        
        
    public boolean CommitToFile()
    {
        return FManager.writeBinary(FilePath, employees);
        
    }
    public void LoadFile()
    {
        employees = (ArrayList<Employee>)FManager.readBinary(FilePath);
    }
    public boolean addEmployee()
    {
        LoadFile();
        employees.add(this);
        return CommitToFile();
    }
    public boolean removeEmployee(int id)
    {
        if(searchEmployee(id)){
            int index = getIndexEmployee(id);
            employees.remove(index);
            return CommitToFile();
        }
        return false;
    }
    public Employee getEmployee(int id)
    {
        LoadFile();
        for(Employee c : employees)
            if(c.ID==id)
                return c;
        return null;
    }
    public boolean searchEmployee(int id)
    {
        LoadFile();
        for(Employee c : employees)
            if(c.ID==id)
                return true;
        return false;
    }
    public ArrayList<Employee> ListAllEmployee()
    {
        LoadFile();
        return employees;
    }
//    public String getFileData()
//    {
//        return this.ID+"`"+this.Age+"`"+this.Salary+"`"+this.Name+"`"+this.Email+"`"+this.PhoneNo+"`"+this.UserName+"`"+this.Password+"`"+this.Gender+"`"+this.Qualification+"`";
//    }
    public int getIndexEmployee(int id)
    {
        for(int i=0;i<employees.size();i++)
            if(employees.get(i).ID==id)
                return i;
        return -1;
    }
    public boolean EditInEmployees(int id)
    {
        if(searchEmployee(id))
        {
            int index = getIndexEmployee(id);
            employees.set(index, this);
            return CommitToFile();
        }
        return false;
    }
    public boolean Dublicate(int ID)
    {
        LoadFile();
        for(Employee a : employees)
            if(a.ID==ID)
                return true;
        return false;
    }    
    @Override
    public boolean LogIn(String user , String pass) {
        if(user.equals("Employee@yahoo.com")&&pass.equals("12345678"))
            return true;
        LoadFile();
        for(Employee a : employees)
            if(a.Email.equals(user)&&a.Password.equals(pass))
                return true;
        return false;
    }
    
}
