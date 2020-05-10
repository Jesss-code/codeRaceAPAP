
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SoloCode JSHDVR
 */
public class doStuff {
    
    private String fName,lName,contactNo,eMail,course,year,gender,studentNo,IMG,timeIn,sortQuery = "SELECT * FROM `profiler` ORDER BY `profiler`.`s_number` ASC";;
    private int rowSearch;

    public int getRowSearch() {
        return rowSearch;
    }

    public void setRowSearch(int rowSearch) {
        this.rowSearch = rowSearch;
    }
    public String getSortQuery() {
        return sortQuery;
    }

    public void setSortQuery(String sortQuery) {
        this.sortQuery = sortQuery;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void printProfile(){
        System.out.println("LAST NAME   : "+getlName());
        System.out.println("FIRST NAME  : "+getfName());
        System.out.println("COURSE/YEAR : "+getCourse()+" "+getYear());
        System.out.println("GENDER      : "+getGender());
        System.out.println("EMAIL       : "+geteMail());
        System.out.println("CONTACT NO   : "+getContactNo());
        System.out.println("CONTACT NO   : "+getIMG());

    }
    
        public static Connection doStuff(){
        
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ap_profiles","root","");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }   
                    String query = "INSERT INTO `profiler`(`first_name`, `last_name`, `course`, `year`, `gender`, `contact_no`, `email`, `s_number`,`img`) VALUES (?,?,?,?,?,?,?,?,?)";

        public void addUser(){
            
            ResultSet rs;
            PreparedStatement ps;
            String FirstName = getfName()
                    ,LastName = getlName()
                    ,Course = getCourse()
                    ,Year = getYear()
                    ,Gender = getGender()
                    ,Contact_no = getContactNo()
                    ,Email = geteMail()
                    ,sNo = getStudentNo(),imgF = getIMG();
            
             try {
                    ps = doStuff().prepareStatement(query);
                    ps.setString(1, FirstName);
                    ps.setString(2, LastName);
                    ps.setString(3, Course);
                    ps.setString(4, Year);
                    ps.setString(5, Gender);
                    ps.setString(6, Contact_no);
                    ps.setString(7, Email);
                    ps.setString(8, sNo);
                    ps.setString(9, imgF);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "New User add");
            }
        } catch (SQLException ex) {
                 System.out.println(ex);
                 System.out.println("shits");
                 JOptionPane.showMessageDialog(null, "INVALID INPUT");
                 
            
            }
        }
        public void delUser(){
        //DELETE FROM `profiler` WHERE s_number = 1
        String query = "DELETE FROM `profiler` WHERE `s_number` = ?";
        ResultSet rs;
        PreparedStatement ps;

        String studentNum = getStudentNo();

        try {
            ps = doStuff().prepareStatement(query);
            ps.setString(1, studentNum);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "STUDENT RECORD #" + studentNum + "  DELETED");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void updateUser() {
        ResultSet rs;
        PreparedStatement ps;
        String query = "UPDATE `profiler` "
                + "SET `first_name` = ?,"
                + "`last_name`= ?,"
                + "`course`= ?,"
                + "`year`= ?,"
                + "`gender`= ?,"
                + "`contact_no`= ?,"
                + "`email` = ?,"
                + "`img` = ?"
                + "	WHERE `profiler`.`s_number` = ?";
        String FirstName = getfName(), LastName = getlName(), Course = getCourse(), Year = getYear(), Gender = getGender(), Contact_no = getContactNo(), Email = geteMail(), sNo = getStudentNo(), img = getIMG();
        try {
            ps = doStuff().prepareStatement(query);
            ps.setString(1, FirstName);
            ps.setString(2, LastName);
            ps.setString(3, Course);
            ps.setString(4, Year);
            ps.setString(5, Gender);
            ps.setString(6, Contact_no);
            ps.setString(7, Email);
            ps.setString(8, img);
            ps.setString(9, sNo);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "UPDATED");
            } else {
                JOptionPane.showMessageDialog(null, "UPDATED ERROR");

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }
    
    public void sStudenetNum() {

        ResultSet rs;
        PreparedStatement ps;
        String query = "SELECT * FROM `profiler` WHERE `s_number` =?";

        try {
            ps = doStuff().prepareStatement(query);
            ps.setString(1, getStudentNo());
            rs = ps.executeQuery();

            if (rs.next()) {
                setfName(rs.getString("first_name"));
                setlName(rs.getString("last_name"));
                setCourse(rs.getString("course"));
                setContactNo(rs.getString("contact_no"));
                setYear(rs.getString("year"));
                seteMail(rs.getString("email"));
                setGender(rs.getString("gender"));
                setfName(rs.getString("first_name"));
                setIMG(rs.getString("img"));
                setTimeIn(rs.getString("timeStamp"));

            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Shits _++");
      }
    }
    
    
    public ArrayList<User> userList() {
        ArrayList<User> userList = new ArrayList<>();
        
        
        
        Statement st = null;
        PreparedStatement ps;
        ResultSet rs;

        User user;
        
        try {
            ps = doStuff().prepareStatement(sortQuery);
            
            rs = ps.executeQuery();
            while (rs.next()) {

                user = new User(rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("course"),
                                rs.getString("year"),
                                rs.getString("gender"),
                                rs.getString("contact_no"),
                                rs.getString("email"),
                                rs.getString("s_number"),
                                rs.getString("timeStamp"));

                userList.add(user);

            }
        } catch (SQLException ex) {
            
        }
        return userList;
    }
    
}
