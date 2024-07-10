import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewStudents() {
        students.forEach(System.out::println);
    }

    public void updateStudent(int id, String newName, String newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setGrade(newGrade);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public Student searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        
        system.addStudent(new Student(1, "Alice", "A"));
        system.addStudent(new Student(2, "Bob", "B"));
        system.viewStudents();

       
        system.updateStudent(1, "Alicia", "A+");
        system.viewStudents();

       
        Student foundStudent = system.searchStudentByName("Bob");
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }

       
        system.deleteStudent(2);
        system.viewStudents();
    }
}

