package models;



public class Registration {
    private String company;
    private int payroll;
    private String fullname;
    private String jobtitle;
    private String room;
    private String building;
    private String location;
    private String sector;
    private int requestertel;
    private String hashedpayroll;
    private String hashedrequestertel;

    // Getters and Setters
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getRequesterTel() {
        return requestertel;
    }

    public void setRequesterTel(int requestertel) {
        this.requestertel = requestertel;
    }
    
    public String getHashedPayroll() {
        return hashedpayroll;
    }

    public void settHashedPayroll(String hashedpayroll) {
        this.hashedpayroll = hashedpayroll;
    }
    
    public String getHashedRequestertel() {
        return hashedrequestertel;
    }

    public void setHashedRequestertel(String hashedrequestertel) {
        this.hashedrequestertel = hashedrequestertel;
    }

    
}

