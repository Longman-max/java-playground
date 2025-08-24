package school.management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class SchoolManagement {

    // ===== Base class =====
    static abstract class Person {
        protected String name;
        protected int age;
        protected String id;

        public Person(String name, int age, String id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public abstract void displayInfo(); // polymorphic
    }

    // ===== Student =====
    static class Student extends Person {
        private String gradeLevel;
        private List<Course> enrolledCourses;

        public Student(String name, int age, String id, String gradeLevel) {
            super(name, age, id);
            this.gradeLevel = gradeLevel;
            this.enrolledCourses = new ArrayList<>();
        }

        public void enrollCourse(Course course) {
            enrolledCourses.add(course);
            System.out.println(name + " enrolled in " + course.getCourseName());
        }

        @Override
        public void displayInfo() {
            System.out.println("Student: " + name + " | Grade: " + gradeLevel + " | ID: " + id);
        }
    }

    // ===== Teacher =====
    static class Teacher extends Person {
        private String subject;
        private double salary;

        public Teacher(String name, int age, String id, String subject, double salary) {
            super(name, age, id);
            this.subject = subject;
            this.salary = salary;
        }

        public void teachCourse(Course course) {
            System.out.println(name + " is teaching " + course.getCourseName());
        }

        @Override
        public void displayInfo() {
            System.out.println("Teacher: " + name + " | Subject: " + subject + " | Salary: $" + salary);
        }
    }

    // ===== Course =====
    static class Course {
        private String courseCode;
        private String courseName;
        private Teacher teacher;

        public Course(String courseCode, String courseName, Teacher teacher) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.teacher = teacher;
        }

        public String getCourseName() {
            return courseName;
        }

        public void assignTeacher(Teacher teacher) {
            this.teacher = teacher;
            System.out.println(teacher.getName() + " assigned to " + courseName);
        }

        public void displayCourseInfo() {
            System.out.println(courseCode + " - " + courseName + " | Teacher: " + teacher.getName());
        }
    }

    // ===== Department =====
    static class Department {
        private String deptName;
        private List<Course> courses;

        public Department(String deptName) {
            this.deptName = deptName;
            this.courses = new ArrayList<>();
        }

        public void addCourse(Course course) {
            courses.add(course);
            System.out.println(course.getCourseName() + " added to " + deptName + " department.");
        }

        public void displayDepartmentInfo() {
            System.out.println("Department: " + deptName);
            for (Course c : courses) {
                c.displayCourseInfo();
            }
        }
    }

    // ===== Main School Class =====
    static class School {
        private String schoolName;
        private List<Student> students;
        private List<Teacher> teachers;
        private List<Department> departments;

        public School(String schoolName) {
            this.schoolName = schoolName;
            this.students = new ArrayList<>();
            this.teachers = new ArrayList<>();
            this.departments = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
            System.out.println(student.getName() + " added to school.");
        }

        public void addTeacher(Teacher teacher) {
            teachers.add(teacher);
            System.out.println(teacher.getName() + " joined the school.");
        }

        public void addDepartment(Department dept) {
            departments.add(dept);
            System.out.println("Department " + dept + " added to school.");
        }

        public void displaySchoolInfo() {
            System.out.println("\n=== " + schoolName + " Management System ===");

            System.out.println("\nStudents:");
            for (Student s : students) s.displayInfo();

            System.out.println("\nTeachers:");
            for (Teacher t : teachers) t.displayInfo();

            System.out.println("\nDepartments:");
            for (Department d : departments) d.displayDepartmentInfo();
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        School mySchool = new School("Rehoboth International School");

        Teacher t1 = new Teacher("Mr. John", 40, "T001", "Mathematics", 50000);
        Teacher t2 = new Teacher("Ms. Mary", 35, "T002", "Physics", 48000);

        Student s1 = new Student("Alice", 15, "S001", "10th Grade");
        Student s2 = new Student("Bob", 16, "S002", "11th Grade");

        Course c1 = new Course("MATH101", "Algebra", t1);
        Course c2 = new Course("PHY101", "Mechanics", t2);

        Department d1 = new Department("Science");
        d1.addCourse(c1);
        d1.addCourse(c2);

        mySchool.addTeacher(t1);
        mySchool.addTeacher(t2);
        mySchool.addStudent(s1);
        mySchool.addStudent(s2);
        mySchool.addDepartment(d1);

        s1.enrollCourse(c1);
        s2.enrollCourse(c2);

        mySchool.displaySchoolInfo();
    }
}
