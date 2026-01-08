package Buoi5.bai3;

import Buoi5.bài1.DataCleaner;

class Student {
    String id;
    String name;
    double attendanceScore;
    double examScore;

    public Student(String id, String name, double attendanceScore, double examScore) {
        this.id = id;
        this.name = DataCleaner.formatName(name); // Chuẩn hóa tên từ Bài 1 (nếu tích hợp)
        this.attendanceScore = attendanceScore;
        this.examScore = examScore;
    }

    public double calculateFinalScore() {
        return (attendanceScore * 0.3) + (examScore * 0.7);
    }

    public String getGrade() {
        double finalScore = calculateFinalScore();
        if (finalScore >= 8.5) {
            return "A";
        } else if (finalScore >= 7.0) {
            return "B";
        } else if (finalScore >= 5.5) {
            return "C";
        } else {
            return "D";
        }
    }
}
