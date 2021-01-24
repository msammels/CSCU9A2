/**
 * StudentRecord
 *
 * A class to hold and manage a student record's data
 *
 * Note that this class does not have any direct appearance on the screen, and "understands" no events - that
 * is the responsibility of the associated main program GUI class
 *
 * @author Simon Jones (SBJ) April 2014
 * @author Michael Sammels (MIS) Spring 2019
 */
public class StudentRecord {
    /**
     * Personal details
     */
    private final String name;
    private String address;                 // Will initially be blank; modifiable
    private final String registrationNo;
    private final String degree;

    /**
     * Academic details
     */
    private int creditsObtained;            // Will start at 0; increment-able

    /**
     * This constructor is called to setup the student record with essential information
     * @param theName the students name
     * @param theRegistrationNo the students registration number
     * @param theDegree the students degree
     */
    public StudentRecord(String theName, String theRegistrationNo, String theDegree) {
        name = theName;
        address = "";                       // Initially unknown
        registrationNo = theRegistrationNo;
        degree = theDegree;
        creditsObtained = 0;                // None obtained at start
    }

    /**
     * This method is called to obtain the name of the student
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * This method is called to change the address held to that given as a parameter
     * @param theAddress the new address
     */
    public void setAddress(String theAddress) {
        address = theAddress;
    }

    /**
     * This method is called to obtain the current address of the student
     * @return the current address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method is called to obtain the registration number of the student
     * @return the student's registration number
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * This method is called to obtain the registration number of the student
     * @return the student's registration number
     */
    public String getDegree() {
        return degree;
    }

    /**
     * This method is called to add one more credit to the student's record
     */
    public void addACredit() {
        creditsObtained++;
    }

    /**
     * This method is called to add multiple credits to the student's record
     */
    public void addMultipleCredits(int credits) {
        creditsObtained = credits + creditsObtained;
    }

    /**
     * This method is called to obtain the current number of credits held by the student
     * @return the current number of credits
     */
    public int getCreditsObtained() {
        return creditsObtained;
    }
}