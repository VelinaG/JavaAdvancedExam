package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private int capacity;
    private List<Student> students;


    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentCount() {
        return this.students.size();
    }


    public String registerStudent(Student student){
        if (students.contains(student)){
            return "Student is already in the classroom";
        } else if (students.size() < capacity){
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the classroom";
        }
    }


    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public String getSubjectInfo(String subject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Subject: ").append(subject).append(System.lineSeparator())
                .append("Students:");
        boolean hasEnrolledStudents = false;
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                hasEnrolledStudents = true;
                stringBuilder.append(System.lineSeparator())
                        .append(student.getFirstName()).append(" ")
                        .append(student.getLastName());
            }
        }

        if (hasEnrolledStudents) {
           return stringBuilder.toString();
        } else {
            return "No students enrolled for the subject";
        }
    }



    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classroom size: ").append(this.students.size());
        for (Student student : students) {
            stringBuilder.append(System.lineSeparator())
                    .append(String.format("==Student: First Name= %s , Last Name= %s , Best Subject= %s"
                    , student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }

        return stringBuilder.toString();
    }
//    • getStatistics() – returns a String in the following format:
//        ◦ "Classroom size: {added_students_count}
//   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
//   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
//   (…)"

}











