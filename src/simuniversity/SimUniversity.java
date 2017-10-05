/**
	File name: SimUniversity.java
	Short description:  Assignment to simulate a University's
            clerical system. Students and Employees at a virtual
            university are subclasses of abstract class Person,
            while Faculty and Staff respectively are subclasses
            of class Employee. Each Student and Employee has his own
            personal data stored in an object of his respective type.
            Inherited overridden method toString prints parts of
            a person's personal data. Interface Changeable formats the
            program so that Employees and Students can have their names changed,
            though this is never used in the program's main method.
	@author Howard John Rolleston
	@version 1.01 Friday, 8 September 2017
*/
package simuniversity;

import java.util.ArrayList;
import java.util.Arrays;

public class SimUniversity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Hardcoding the required testing variables (I hate this part):
        Staff bob = new Staff("Bob", "Smith",
                "illuminatidorito420@psu.edu", "999-999-9999",
                "120 Vairo", "444-444-4444", "4/04/44", "Captain");
        Staff aay = new Staff("Aayla", "Secura",
                "originalcharacter@verizon.com", "215-948-2294",
                "120 Vairo", "345-567-3456", "9/11/01", "Knight");
        Staff lmao = new Staff("Gene", "Belcher",
                "beefsquatch666@outlook.com", "218-460-3011",
                "200 Main", "625-456-3865", "6/03/89", "Emperor");
        
        Faculty fca = new Faculty("Adam", "Smith",
                "lkgjsdlfg@outlook.com", "1-545-647-6786",
                "960 Tesla", "2-345-567-6987", "7/27/89", "Custodian, 1st class");
        Faculty fwd = new Faculty("Jim", "Ackbar",
                "itsatrap440@psu.edu", "8-968-456-2275",
                "220 Tesla", "5-345-456-6658", "2/24/02", "Mascot");
        Faculty asa = new Faculty("Apollo", "Gauntlet",
                "infringement@gmail.com", "012-345-6789",
                "229 Horten", "999-979-9797", "9/07/89", "Gladiator");
        
        Student dan = new Student("Dan", "Reinmann", "josefstalin@gmail.com", "1-888-888-8888", "Freshman");
        Student jil = new Student("Jill", "Witherspoon", "loremipsum@gmail.com", "215-756-9984", "Senior Citizen");
        Student geo = new Student("Ron", "Neeson", "ronneeson@psu.edu", "453-889-4786", "Sophomore");
        
        
        // Let's roll.
        ArrayList<Person> all = new ArrayList<Person>(Arrays.asList(bob, aay, lmao, fca, fwd, asa, dan, jil, geo));
        
        while(all.size() > 0) {
            System.out.println(all.get(0).toString());
            all.remove(0);
        }   
    }
}

// Interface to allow user alteration of the First and Last Name variables.
// Unused in main method.
interface Changeable {void setName(String fName, String lName);}

// Abstract class to establish this system's most basic variables.
// Highest superclass in this program's main class hierarchy.
abstract class Person {
    String firstName, lastName, email, phoneNum;
    Person(String fName, String lName, String em, String phn) {
        this.firstName = fName; this.lastName = lName;
        this.email = em; this.phoneNum = phn;
    }
    
    // Overriding method "toString(): String" of class Object
    // to display a given person's first and last names.
    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
    
}

class Employee extends Person {
    String office, employDate, officePhone;
    // Running required parameters through abstract superclass's constructor,
    // then setting variables for this class
    Employee(String fName, String lName, String em, String phn, String ofc, String ofph, String emdt){
        super(fName, lName, em, phn);
        this.office = ofc; this.employDate = emdt;
        this.officePhone = ofph;
    }
    
    // For the purposes of this assignment, method toString
    // of class Person is identical in the scope of its subclass.
    // It is commented out of the actual source code for this reason.
    /*@Override
    public String toString() {
        return super.toString();
    }*/
}


class Student extends Person implements Changeable {
    String classStatus;
    Student(String fName, String lName, String em, String phn, String clst) {
        super(fName, lName, em, phn);
        this.classStatus = clst;
    }
    
    // Overriding method setName to implement interface
    // Changeable.
    @Override
    public void setName(String fName, String lName) {
        this.firstName = fName; this.lastName = lName;
    }
    
    // Overriding method toString() of class Person
    // to display a Student's class status as well
    // as their name.
    @Override
    public String toString() {
        return super.toString() + ", " + classStatus;
    }
    
}

class Faculty extends Employee implements Changeable {
    String rank;
    Faculty(String fName, String lName, String em, String phn, String ofc, String ofph, String emdt, String rnk) {
        super(fName, lName, em, phn, ofc, ofph, emdt);
        this.rank = rnk;
    }
    
    // Implementing interface Changeable.
    @Override
    public void setName(String fName, String lName) {this.firstName = fName; this.lastName = lName;}
    
    // Overriding method toString of class Person
    // to display rank of faculty member
    @Override
    public String toString() {
        return super.toString() + ", " + rank;
    }
}

class Staff extends Employee {
    String title;
    Staff(String fName, String lName, String em, String phn, String ofc, String ofph, String emdt, String ttl) {
        super(fName, lName, em, phn, ofc, ofph, emdt);
        this.title = ttl;
    }
    
    // Overriding method toString of class Person
    // to display job title of staff member
    @Override
    public String toString() {
        return super.toString() + ", " + title;
    }
}