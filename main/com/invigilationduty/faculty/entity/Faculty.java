package main.com.invigilationduty.faculty.entity;

public class Faculty {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String qualification;
    private String emailId;
    private String password;
    private String leisureTime;
    private String blockName;
    private String floorNumber;
    private String roomNumber;
    private String examName;
    private String examTime;
    private String examDate;

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyFirstName='" + firstName + '\'' +
                ", facultyEmailId='" + emailId + '\'' +
                ", facultyAllocatedRoomNumber='" + roomNumber + '\'' +
                ", facultyAllocatedBlockName='" + blockName + '\'' +
                ", facultyAllocatedFloorNumber='" + floorNumber + '\'' +
                ", facultyExamName='" + examName + '\'' +
                ", facultyExamTime='" + examTime + '\'' +
                ", facultyExamDate='" + examDate + '\'' +
                '}';
    }

    public Faculty(){}

    public Faculty(String id) {
        id = id;
    }

    public Faculty(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Faculty(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public Faculty(String firstName, String emailId, String leisureTime) {
        this.firstName = firstName;
        this.emailId = emailId;
        this.leisureTime = leisureTime;
    }

    public Faculty(String firstName, String lastName, String emailId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
    }

    public Faculty(String firstName, String lastName, String gender, String phoneNumber, String qualification, String emailId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.qualification = qualification;
        this.emailId = emailId;
        this.password = password;
    }

    public Faculty(int id, String firstName, String lastName, String emailId, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
    }

    public Faculty(String firstName, String emailId, String examName, String examTime, String examDate) {
        this.firstName = firstName;
        this.emailId = emailId;
        this.examName = examName;
        this.examTime = examTime;
        this.examDate = examDate;
    }

    // Getters and Setters for other fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLeisureTime() {
        return leisureTime;
    }

    public void setLeisureTime(String leisureTime) {
        this.leisureTime = leisureTime;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}
