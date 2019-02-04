


package electricitybillingsystem;

import java.io.Serializable;
import java.util.ArrayList;





public class Admin extends Person implements Serializable{
    
    
    private static ArrayList<Admin>admins = new ArrayList<Admin>();    
    private final String FilePath = "Admin.bin";

        
        
        
    public boolean CommitToFile()
    {
        return FManager.writeBinary(FilePath, admins);
        
    }
    public void LoadFile()
    {
        admins = (ArrayList<Admin>)FManager.readBinary(FilePath);
    }
    public boolean addAdmin()
    {
        LoadFile();
        admins.add(this);
        return CommitToFile();
    }
    public boolean removeAdmin(int id)
    {
        if(searchAdmin(id)){
            int index = getIndexAdmin(id);
            admins.remove(index);
            return CommitToFile();
        }
        return false;
    }
    public Admin getAdmin(int id)
    {
        LoadFile();
        for(Admin c : admins)
            if(c.ID == id)
                return c;
        return null;
    }
    public boolean searchAdmin(int id)
    {
        LoadFile();
        for(Admin c : admins)
            if(c.ID==id)
                return true;
        return false;
    }
    public ArrayList<Admin> ListAllAdmin()
    {
        LoadFile();
        return admins;
    }
   
//    public String getFileData() // ID ` Age ` Salary ` Name ` Email ` PhoneNo ` username ` password ` gender ` Qualification
//    {
//        return this.ID+"`"+this.Age+"`"+this.Salary+"`"+this.Name+"`"+this.Email+"`"+this.PhoneNo+"`"+this.UserName+"`"+this.Password+"`"+this.Gender+"`"+this.Qualification+"`";
//    }
    public int getIndexAdmin(int id)
    {
        for(int i=0;i<admins.size();i++)
            if(admins.get(i).ID==id)
                return i;
        return -1;
    }
    public boolean EditInAdmins(int id)
    {
        if(searchAdmin(id))
        {
            int index = getIndexAdmin(id);
            admins.set(index, this);
            return CommitToFile();
        }
        return false;
    }
    public boolean Dublicate(int ID)
    {
        LoadFile();
        for(Admin a : admins)
            if(a.ID==ID)
                return true;
        return false;
    }
        
    @Override
    public boolean LogIn(String user , String pass) {
        if(user.equals("Admin@yahoo.com")&&pass.equals("12345678"))
            return true;
        LoadFile();
        for(Admin a : admins)
            if(a.Email.equals(user)&&a.Password.equals(pass))
                return true;
        return false;
    }
    
}
