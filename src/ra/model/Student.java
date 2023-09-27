package ra.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private int studentId;
    private String studentName;
    private String birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
    }

    public Student(int studentId, String studentName, String birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputData(Scanner scanner, int count, Student[] arrStudent) {
        this.studentId = count + 1;
        boolean isExit = false;
        do {
            while (true) {
                System.out.println("Student Name:");
                this.studentName = scanner.nextLine();
                if (this.validEmpty(this.studentName)) {
                    break;
                } else {
                    System.out.println("Name can't be empty");
                }
            }
            while (true) {
                System.out.println("Birth Day(yyyy-mm-dd):");
                this.birthDay = scanner.nextLine();
                if (validDate(this.birthDay)) {
                    break;
                } else {
                    System.out.println("Must be yyyy/mm/dd)");
                }
            }
            while (true) {
                System.out.println("Address:");
                this.address = scanner.nextLine();
                if (validEmpty(this.address)) {
                    break;
                } else {
                    System.out.println("Address can't be empty");
                }
            }
            System.out.println("Gender (true: male /false: female):");
            this.gender = Boolean.parseBoolean(scanner.nextLine());
            while (true) {
                System.out.println("Phone Number(At least 10 numbers):");
                this.phone = scanner.nextLine();
                if (validPhone(arrStudent, count,this.phone)) {
                    return;
                } else {
                    System.out.println("invalid Phone number or someone already used");
                }
            }
        } while (isExit);
    }

    public void displayData() {
        System.out.printf("ID: %d -  Name: %s - Gender: %s\n", this.studentId, this.studentName, this.gender ? "male" : "female");
        System.out.printf("Address : %s - Phone - %s\n", this.address, this.phone);
    }

    public boolean validEmpty(String input) {
        return !input.isEmpty();
    }

    public boolean validDate(String birthDay) {
        String regex = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(birthDay);
        return m.matches();
    }

    public boolean validPhone(Student[] arrStudent, int studentCount,String phone) {
        String pattern = "^\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(phone);
        if (m.matches()) {
            for (int i = 0; i < studentCount - 1; i++) {
                if (arrStudent[i].getPhone().equals(phone)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return m.matches();
    }
}
