package ra.run;

import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;
import ra.service.MarkService;
import ra.service.StudentService;
import ra.service.SubjectService;

import java.util.Scanner;

public class SchoolManagement {
    Student[] studentsArr = new Student[10];
    int studentCount = 0;
    Subject[] subjectsArr = new Subject[10];
    int subjectCount = 0;
    Mark[] markArr = new Mark[10];
    int markCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolManagement schoolManagement = new SchoolManagement();
        do {
            System.out.println("************************SCHOOL-MANAGEMENT*************************");
            System.out.println("1: STUDENT-MANAGEMENT");
            System.out.println("2: SUBJECT-MANAGEMENT");
            System.out.println("3: MARK-MANAGEMENT");
            System.out.println("4: Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    schoolManagement.studentManagement(scanner);
                    break;
                case 2:
                    schoolManagement.subjectManagement(scanner);
                    break;
                case 3:
                    schoolManagement.markManagement(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Please Select 1 to 4");
                    break;
            }
        } while (true);
    }

    public void studentManagement(Scanner scanner) {
        StudentService studentService = new StudentService();
        while (true) {
            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1.Thêm mới học sinh");
            System.out.println("2.Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học sinh theo mã id");
            System.out.println("4.Xóa học sinh theo mã id");
            System.out.println("5.Exits");
            int SM = Integer.parseInt(scanner.nextLine());
            switch (SM) {
                case 1:
                    studentsArr = studentService.createStudent(scanner, studentsArr, studentCount++);
                    break;
                case 2:
                    studentService.displayStudent(studentsArr, studentCount);
                    break;
                case 3:
                    studentsArr = studentService.updateStudent(scanner, studentsArr, studentCount);
                    break;

                case 4:
                    studentsArr = studentService.deleteStudent(scanner, studentsArr, studentCount);
                    studentCount--;
                    break;

                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void subjectManagement(Scanner scanner) {
        SubjectService subjectService = new SubjectService();
        do {
            System.out.println("**********************SUBJECT-MANAGEMENT************************");
            System.out.println("1.Thêm mới môn học");
            System.out.println("2.Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học môn học theo mã id");
            System.out.println("4.Xóa môn học theo mã id");
            System.out.println("5.Exits");
            int SubM = Integer.parseInt(scanner.nextLine());
            switch (SubM) {
                case 1:
                    subjectsArr = subjectService.createSubject(scanner, subjectsArr, subjectCount++);
                    break;
                case 2:
                    subjectService.displaySubject(subjectsArr, subjectCount);
                    break;
                case 3:
                    subjectsArr = subjectService.updateSubject(scanner, subjectsArr, subjectCount);
                    break;
                case 4:
                    subjectsArr = subjectService.deleteSubject(scanner, subjectsArr, subjectCount);
                    subjectCount--;
                    break;

                case 5:
                    return;
                default:
                    break;
            }
        } while (true);
    }

    public void markManagement(Scanner scanner) {
        MarkService markService = new MarkService();
        do {
            System.out.println("**********************MARK-MANAGEMENT************************");
            System.out.println("1.Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3.Thay đổi điểm theo mã id");
            System.out.println("4.Xóa điểm theo mã id");
            System.out.println("5.Exits");
            int MC = Integer.parseInt(scanner.nextLine());
            switch (MC) {
                case 1:
                    markService.addStudentMark(subjectsArr, studentsArr, subjectCount, studentCount, markArr, markCount++,scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        } while (true);
    }
}
