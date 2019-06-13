package main;

import unistudent.UniStudentUI;
import unistudent.UniStudent;

public class Main {
    public static void main(String[] args) {
        UniStudent us = new UniStudent();
        UniStudentUI.init(us);
    }
}
