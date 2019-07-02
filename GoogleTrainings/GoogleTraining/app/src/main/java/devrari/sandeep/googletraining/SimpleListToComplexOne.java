package devrari.sandeep.googletraining;


import java.util.ArrayList;

/**
 * Created by user on 27/3/18.
 */

class SimpleListToComplexOne {
    private ArrayList<String> firstName;
    private ArrayList<String> experience;
    private ArrayList<String> jobTitle;
    private ArrayList<EmployeeOfRV> employees;

    SimpleListToComplexOne() {
        firstName=new ArrayList<>();
        firstName.add("Rahul");
        firstName.add("Rohan");
        firstName.add("Ram");
        firstName.add("Syam");
        firstName.add("Arjun");
        firstName.add("Mukesh");
        firstName.add("Ravi");
        firstName.add("Om");
        experience=new ArrayList<>();
        experience.add("1");
        experience.add("2");
        experience.add("3");
        experience.add("6");
        experience.add("5");
        experience.add("4");
        experience.add("7");
        experience.add("8");


        jobTitle=new ArrayList<>();
        jobTitle.add("Android");
        jobTitle.add("Game");
        jobTitle.add("Project Manager");
        jobTitle.add("Director");
        jobTitle.add("Sportsman");
        jobTitle.add("Actor");
        jobTitle.add("Marketing");
        jobTitle.add("IOs");
        employees=new ArrayList<>();
        for(int index=0;index<firstName.size();index++){
            EmployeeOfRV employeeOfRV=new EmployeeOfRV(firstName.get(index),experience.get(index),jobTitle.get(index));
            employees.add(employeeOfRV);
        }
    }


    public ArrayList<String> getFirstName() {
        return this.firstName;
    }
    public void addFirstName(String name){firstName.add(name);};
    public void addExperience(String exper){experience.add(exper);};
    public void addJob(String job){jobTitle.add(job);};

    public ArrayList<String> getExperience() {
        return this.experience;
    }

    public ArrayList<String> getJobTitle() {
        return this.jobTitle;
    }
    public ArrayList<EmployeeOfRV> getEmployees() {
        return this.employees;
    }
}
