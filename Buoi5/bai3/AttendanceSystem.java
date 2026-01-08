package Buoi5.bai3;

import java.util.Scanner;


public class AttendanceSystem {
    private static Student[] students = new Student[100];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Nhập danh sách SV");
            System.out.println("2. Hiển thị bảng điểm");
            System.out.println("3. Tìm SV theo ID");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    inputStudents(scanner);
                    break;
                case 2:
                    displayScores();
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void inputStudents(Scanner scanner) {
        System.out.print("Nhập số lượng SV: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        for (int i = 0; i < num; i++) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Điểm chuyên cần: ");
            double att = scanner.nextDouble();
            System.out.print("Điểm thi: ");
            double exam = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            students[count++] = new Student(id, name, att, exam);
        }
    }

    private static void displayScores() {
        System.out.println("Bảng điểm:");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println("ID: " + s.id + ", Tên: " + s.name + ", Final Score: " + s.calculateFinalScore() + ", Grade: " + s.getGrade());
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                Student s = students[i];
                System.out.println("Tên: " + s.name + ", Final Score: " + s.calculateFinalScore() + ", Grade: " + s.getGrade());
                return;
            }
        }
        System.out.println("Không tìm thấy SV.");
    }
}

