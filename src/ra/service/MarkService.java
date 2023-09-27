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

            markArr[markCount] = new Mark();
            markArr[markCount].inputData(scanner,markCount,studentsArr,studentCount,subjectsArr,subjectCount);
        }
    }
}
