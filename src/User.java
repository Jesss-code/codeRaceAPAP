public class User {
    
    private String firstName,lastName,course,year,gender,contactNo,eMail,StudentNum,dtr;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String geteMail() {
        return eMail;
    }

    public String getStudentNum() {
        return StudentNum;
    }

    public String getDtr() {
        return dtr;
    }
     
    public User(String fn,
            String ln,
            String course,
            String year,
            String gender,
            String Contact,
            String eMail,
            String sNum,
            String dtr) {
        this.firstName = fn;
        this.lastName = ln;
        this.course = course;
        this.year = year;
        this.gender = gender;
        this.contactNo = Contact;
        this.eMail = eMail;
        this.StudentNum = sNum;
        this.dtr = dtr;
        
    }
}