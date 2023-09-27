package ra.service;

import ra.model.Student;

import java.util.Scanner;

public class StudentService {
    public StudentService() {
    }

    public void displayStudent(Student[] students, int studentCount) {
        System.out.println("Student information");
        System.out.println(studentCount);
        for (int i = 0; i < studentCount; i++) {
            students[i].displayData();
        }
    }

    public Student[] createStudent(Scanner sc, Student[] arrStudents, int studentCount) {
        arrStudents[studentCount] = new Student();
        arrStudents[studentCount].inputData(sc, studentCount, arrStudents);
        return arrStudents;
    }

    public int getIndexById(int id, int studentCount, Student[] arrStudents) {
        for (int i = 0; i < studentCount; i++) {
            if (arrStudents[i].getStudentId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Student[] updateStudent(Scanner sc, Student[] studentsArr, int studentCount) {

        System.out.println("Enter Student id want Update");
        Student valid = new Student();
        int id = Integer.parseInt(sc.nextLine());
        int indexUpdate = getIndexById(id, studentCount, studentsArr);
        if (indexUpdate >= 0) {
            // update information
            System.out.println("update student name:");
            String name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                studentsArr[indexUpdate].setStudentName(name);
            }
            System.out.println("update student birth day:");
            String birthDayU = sc.nextLine();
            if (!birthDayU.trim().isEmpty()) {
                boolean isDay = valid.validDate(birthDayU);
                if (isDay) {
                    studentsArr[indexUpdate].setBirthDay(birthDayU);
                } else {
                    System.out.println("Invalid date Birth will be same");
                }
            }
            System.out.println("update student sex:");
            String gender = sc.nextLine();
            if (!gender.trim().isEmpty()) {
                studentsArr[indexUpdate].setGender(Boolean.parseBoolean(gender));
            }
            System.out.println("update Student address:");
            String addr = sc.nextLine();
            if (!addr.trim().isEmpty()) {
                studentsArr[indexUpdate].setAddress(addr);
            }
            System.out.println("update Student phone:");
            String uPhone = sc.nextLine();
            if (!uPhone.trim().isEmpty()) {
                boolean isPhone = valid.validPhone(studentsArr, studentCount, uPhone);
                if (isPhone) {
                    studentsArr[indexUpdate].setPhone(uPhone);
                } else {
                    System.out.println("invalid or someone already used phone will not change");
                }
            }
        } else {
            System.err.println("Student id not exist");
        }
        return studentsArr;
    }

    public Student[] deleteStudent(Scanner sc, Student[] arrStudents, int studentCount) {
        System.out.println("Enter id student want delete:");
        int id = Integer.parseInt(sc.nextLine());
        int indexDelete = getIndexById(id, studentCount, arrStudents);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < studentCount - 1; i++) {
                arrStudents[i] = arrStudents[i + 1];
            }
            arrStudents[studentCount - 1] = null;
        } else {
            System.err.println("Student id not exist");
        }
        return arrStudents;
    }
}

