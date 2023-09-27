package ra.model;

import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }


    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData(Scanner scanner, Subject[] subjectsArr, int subjectCount) {
        while (true) {
            while (true) {
                System.out.println("Enter Subject ID:");
                this.subjectId = scanner.nextLine();
                if (this.subjectId.startsWith("MH")) {
                    if (validSubjectID(this.subjectId, subjectsArr, subjectCount)) {
                        break;
                    } else {
                        System.out.println("invalid or already in used");
                    }
                } else {
                    System.out.println("Start with MH");
                }
            }
            ;
            while (true) {
                System.out.println("Enter Subject:");
                this.subjectName = scanner.nextLine();
                if (validSubject(this.subjectName, subjectsArr, subjectCount)) {
                    return;
                } else {
                    System.out.println("invalid or already in used");
                }
            }
        }
    }


    public void displayData() {
        System.out.printf("ID: %s\nSubject: %s\n", this.subjectId, this.subjectName);
    }

    public boolean validSubjectID(String subjectId, Subject[] subjectsArr, int subjectCount) {
        boolean isID = subjectId.matches("MH[0-9]{3}");
        if (isID) {
            System.out.println(subjectCount);
            for (int i = 0; i < subjectCount; i++) {
                if (subjectId.equalsIgnoreCase(subjectsArr[i].getSubjectId())) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return isID;
    }

    public boolean validSubject(String subjectName, Subject[] subjectsArr, int subjectCount) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjectName.equalsIgnoreCase(subjectsArr[i].getSubjectName())) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
}
