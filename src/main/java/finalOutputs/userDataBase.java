/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalOutputs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cieloalynahfaereyes
 */
public class userDataBase {
         private static final String FILE_NAME = "users.txt";
         private static HashMap<String, String> userDatabase = new HashMap<>();
    
    static {
        loadUsersFromFile();
    }

     public static void addUser(String username, String password) {
        userDatabase.put(username, password);
        saveUserToFile(username, password);
        
     }
     public static boolean isValidUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
        
     }
     
    private static void saveUserToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     private static void loadUsersFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userDatabase.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



    class pointDisplay extends rewardCenter {
    private int points;

    public pointDisplay(int initialPoints) {
        this.points = initialPoints;
    }

    public int getPoints() {
        return points;
    }

    public void decreasePoints(int amount) {
        if (points >= amount) {
            points -= amount;
        } else {
            System.out.println("Not enough points to redeem this reward.");
        }
    }
}
//userDataBase
    class Student {
         {
    private String StudID, First, Lastname, middle, bday, email, number, status, gender, course, department;

    // Updated constructor
    public Student(String StudID, String first, String lastname, String middle, String bday, 
                   String email, String number, String status, String gender, String course, String department) {
        this.StudID = StudID;
        this.First = first;
        this.Lastname = lastname;
        this.middle = middle;
        this.bday = bday;
        this.email = email;
        this.number = number;
        this.status = status;
        this.gender = gender;
        this.course = course;
        this.department = department;
    }

    // Getter methods
    public String getStudID() { return StudID; }
    public String getFirst() { return First; }
    public String getLastName() { return Lastname; }
    public String getMiddle() { return middle; }
    public String getBday() { return bday; }
    public String getEmail() { return email; }
    public String getNumber() { return number; }
    public String getStatus() { return status; }
    public String getGender() { return gender; }
    public String getCourse() { return course; }
    public String getDepartment() { return department; }
    }


    class studentDatabase{
          private static List<Student> students = new ArrayList<>();
    private static Student lastAddedStudent;

    public static void addStudent(Student student) {
        students.add(student);
        lastAddedStudent = student; 
    }

    public static Student getLastAddedStudent() {
        return lastAddedStudent; 
    }

    public static Student getStudentById(String StudID) {
        for (Student s : students) {
            if (s.getStudID().equals(StudID)) {
                return s;
            }
        }
        return null;
    }
    }