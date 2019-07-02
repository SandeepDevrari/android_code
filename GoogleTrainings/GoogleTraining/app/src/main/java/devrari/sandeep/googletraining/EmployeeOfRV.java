package devrari.sandeep.googletraining;

/**
 * Created by user on 27/3/18.
 */

class EmployeeOfRV {
    private String firstName;
    private String experience;
    private String jobTitle;

    EmployeeOfRV(String firstName, String experience, String jobTitle) {
        this.firstName = firstName;
        this.experience = experience;
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
