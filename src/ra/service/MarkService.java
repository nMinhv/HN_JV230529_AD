package ra.service;

import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;

import java.util.Scanner;

public class MarkService {
    public MarkService() {
    }
    public void addStudentMark (Subject[] subjectsArr, Student[] studentsArr, int subjectCount, int studentCount, Mark[] markArr, int markCount, Scanner scanner) {
        if(studentCount == 0 || subjectCount == 0) {
            System.out.println("Subject or Student is not found, please check again!");
        }else {
            System.out.println("Student List");
            for (int i = 0; i <studentCount ; i++) {
                studentsArr[i].displayData();
            System.out.println("Enter Student Name to add point");
            String studentAdd = scanner.nextLine();
            }
            System.out.println("Subject List");
            for (int i = 0; i <subjectCount ; i++) {
                subjectsArr[i].displayData();
            }
            System.out.println("Enter Subject add point:");
            String subjectAdd = scanner.nextLine();

            markArr[markCount] = new Mark();
            markArr[markCount].inputData(scanner,markCount);
        }
    }
}
