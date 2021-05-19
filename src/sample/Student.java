package sample;

public class Student {
    private int SID;
    private String Sname;
    private String Sphone;
    private String Saddress;
    private String Major;

    public Student() {
    }

    public Student(int SID, String sname, String sphone, String saddress, String major) {
        this.SID = SID;
        Sname = sname;
        Sphone = sphone;
        Saddress = saddress;
        Major = major;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public String getSaddress() {
        return Saddress;
    }

    public void setSaddress(String saddress) {
        Saddress = saddress;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }
}
