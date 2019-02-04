

package electricitybillingsystem;

import GUI.Login;
import java.io.File;

public class ElectricityBillingSystem {


    public static void main(String[] args) {
        // TODO code application logic here
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); 				
	checkDirectoryContents(currentDir);
        new Login().setVisible(true);
        
        
    }
    
    public static void checkDirectoryContents(File dir)
    {
        File[] files = dir.listFiles();
        boolean AdminFile = true;
        boolean EmployeeFile = true;
        boolean CustomerFile = true;
        boolean EmailFile = true;
        for (File file : files) {
            if (file.getName().contains("Admin.bin"))
                AdminFile = false;
            else if (file.getName().contains("Employee.bin"))
                EmployeeFile=false;
            else if(file.getName().contains("Customer.bin"))
                CustomerFile=false;
            else if (file.getName().contains("Email.bin"))
                EmailFile=false;
        }
        if (AdminFile) 
            new Admin().CommitToFile();
        if(EmployeeFile)
            new Employee().CommitToFile();
        if(CustomerFile)
            new Customer().CommitToFile();
        if(EmailFile)
            new Mail().commitToFile();
    }
    
}
