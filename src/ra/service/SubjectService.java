package ra.service;

import ra.model.Subject;

import java.util.Scanner;

public class SubjectService {
    public SubjectService() {
    }

    public Subject[] createSubject(Scanner scanner, Subject[] subjectsArr, int subCount) {
        subjectsArr[subCount] = new Subject();
        subjectsArr[subCount].inputData(scanner, subjectsArr, subCount);
        System.out.println(subCount);
        return subjectsArr;
    }

    public void displaySubject(Subject[] subjectsArr, int subjectCount) {
        for (int i = 0; i < subjectCount; i++) {
            subjectsArr[i].displayData();
        }
    }

    public Subject[] updateSubject(Scanner scanner, Subject[] subjectsArr, int subjectCount) {
        System.out.println("Enter Subject ID:");
        String id = scanner.nextLine();
        int indexUpdate = getIndexSubById(id, subjectsArr, subjectCount);
        if (indexUpdate >= 0) {
            Subject subject = new Subject();
            while (true) {
                System.out.println("Subject update:");
                String uSub = scanner.nextLine();
                if (subject.validSubject(uSub, subjectsArr, subjectCount)) {
                    subjectsArr[indexUpdate].setSubjectName(uSub);
                    break;
                }
            }
        }else {
            System.out.println("Subject not found");
        }
            return subjectsArr;
    }

    public int getIndexSubById(String id, Subject[] subjectsArr, int subjectCount) {
        System.out.println(id);
        for (int i = 0; i < subjectCount; i++) {
            if (subjectsArr[i].getSubjectId().equals(id)) {
                System.out.println(subjectsArr[i].getSubjectId().equals(id));
                return i;
            }
        }
        return -1;
    }

    public Subject[] deleteSubject(Scanner scanner, Subject[] subjectsArr, int subjectCount) {
        System.out.println("Enter id Subject want delete:");
        String id = scanner.nextLine();
        int indexDelete = getIndexSubById(id, subjectsArr, subjectCount);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < subjectCount - 1; i++) {
                subjectsArr[i] = subjectsArr[i + 1];
            }
            subjectsArr[subjectCount - 1] = null;
        } else {
            System.err.println("Subject id not exist");
        }
        return subjectsArr;
    }
}

