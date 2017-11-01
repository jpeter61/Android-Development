package me.jamiepeterson.a21gradingtable;

public class Grade {
    int score;
    char grade;

    public Grade(int assignment, int midterm, int finalGrade){
        score = 60*assignment/200 + 15*midterm/100 + 25*finalGrade/100;
        if(score >= 90)
            grade = 'A';
        else if (score >= 80)
            grade = 'B';
        else if (score >= 70)
            grade = 'C';
        else
            grade = 'D';
    }

    public char getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }
}
