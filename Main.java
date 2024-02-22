package CSV_file_handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static double calculateAverageSalary() throws FileNotFoundException//to calculate average sallary
    {
        File myfile = new File("C:/Users/HP/Downloads/employees.csv");// give file path to read file
        int averageSalary = 0;//initially averageSalary 0
        Scanner sc = new Scanner(myfile);// pass the file which you want to read
        String line=sc.nextLine();
            while (sc.hasNext())
            {
                line = sc.nextLine();
                String arr[] = line.split(",");// split the information on the bases of ,
                String emp_id = arr[0];//giving index value
                String emp_first_name = arr[1];
                String emp_last_name = arr[2];
                String emp_email = arr[3];
                String emp_phoneNum= arr[4];
                String emp_hire_date = arr[5];
                String emp_job_id = arr[6];
                int emp_salary = Integer.parseInt(arr[7]);
                String manager_id = arr[8];
                String Dep_id = arr[9];
               averageSalary+=emp_salary;// add empoyee salary in average salary
                System.out.println("\n"+"emp_id : " + emp_id + "\n" + "emp_firstName :"+ emp_first_name+ "\n" + " emp_last_name: "+ emp_last_name
                        +"\n"+ "emp_email :" + emp_email);
            }
        System.out.println("Average Salary"+ averageSalary/50);// divide by total number of emp
        sc.close();
        return averageSalary/50;// return average salary/50
    }
    public static void aboveaverageSalary(double average) throws IOException // to calculate above average sallary
    {
        File file = new File("C:/Users/HP/Downloads/employees.csv");//give file path
        Scanner sc = new Scanner(file);
        File file1 = new File("C:/Users/HP/Desktop/AVI Software/CSV_file_handler/emp.csv");// give filename and path to create file
        //file1.createNewFile();
        FileWriter filewriter = new FileWriter(file1);// file writer to perform writting operation in new file
        filewriter.write("emp_id" + ", first name" + " , last name " + " , salary"); // write empid,name ,salary
        String line=sc.nextLine();
        while (sc.hasNext())
        {
            line = sc.nextLine();
            String s[] = line.split(",");
            String emp_id = s[0];
            String first_name = s[1];
            String last_name = s[2];
            int salary = Integer.parseInt(s[7]);
            if(salary>average)//codition to check wheather the salary is greater than average salary
            {
                //if true than print empid, name and salary
                filewriter.write(emp_id+ ","+first_name + "," + last_name + "," + salary+"\n");
            }
        }
        filewriter.close();//filewriter close
    }

    public static void main(String[] args) throws IOException
    {
        double average = calculateAverageSalary();// call calculated avragesalary function
        aboveaverageSalary(average);// pass average in aboveaveragesalary
    }
}
