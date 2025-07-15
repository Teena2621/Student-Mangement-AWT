import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementApp extends Frame {
    TextField nameField, rollField, deptField;
    TextArea outputArea;
    ArrayList<Student> students = new ArrayList<>();

    public StudentManagementApp() {
        setLayout(new FlowLayout());
        setTitle("Student Management System");
        setSize(400, 400);
        setVisible(true);

        Label nameLabel = new Label("Name:");
        Label rollLabel = new Label("Roll No:");
        Label deptLabel = new Label("Department:");

        nameField = new TextField(20);
        rollField = new TextField(20);
        deptField = new TextField(20);
        outputArea = new TextArea(10, 40);

        Button addBtn = new Button("Add");
        Button viewBtn = new Button("View All");
        Button clearBtn = new Button("Clear");

        add(nameLabel); add(nameField);
        add(rollLabel); add(rollField);
        add(deptLabel); add(deptField);
        add(addBtn); add(viewBtn); add(clearBtn);
        add(outputArea);

        addBtn.addActionListener(e -> addStudent());
        viewBtn.addActionListener(e -> viewStudents());
        clearBtn.addActionListener(e -> outputArea.setText(""));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    void addStudent() {
        String name = nameField.getText();
        String roll = rollField.getText();
        String dept = deptField.getText();

        if (!name.isEmpty() && !roll.isEmpty() && !dept.isEmpty()) {
            students.add(new Student(name, roll, dept));
            outputArea.setText("Student added successfully!\n");
            nameField.setText(""); rollField.setText(""); deptField.setText("");
        } else {
            outputArea.setText("Please fill all fields.\n");
        }
    }

    void viewStudents() {
        if (students.isEmpty()) {
            outputArea.setText("No students found.\n");
        } else {
            StringBuilder sb = new StringBuilder("Student List:\n");
            for (Student s : students) {
                sb.append(s.toString()).append("\n");
            }
            outputArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        new StudentManagementApp();
    }
}
