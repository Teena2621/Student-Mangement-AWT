 public class Student {
    private String name;
    private String rollNo;
    private String department;

    public Student(String name, String rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Department: " + department;
    }
}
