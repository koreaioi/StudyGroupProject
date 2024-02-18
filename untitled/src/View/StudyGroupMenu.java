package View;

import Controller.StudyGroupController;

import java.util.Scanner;

public class StudyGroupMenu {

    Scanner sc;

    StudyGroupController studyGroupController;

    public StudyGroupMenu() {
        sc = new Scanner(System.in);
        studyGroupController = new StudyGroupController();
    }

    public void showMenu() { //보여지는 화면
        int selectNum = 0;

        while (selectNum != -1) {
            displayMenu();

            selectNum = selectMenu();

            switch (selectNum) {
                case 1:
                    studyGroupController.register();
                    break;
                case 2:
                    studyGroupController.findAll();
                    break;
                case 3:
                    studyGroupController.findById();
                    break;
                case 4:
                    studyGroupController.findByName();
                    break;
                case 0:
                    System.out.println("작업을 종료합니다.");
                    return;
            }
        }

    }

    private void displayMenu() {
        System.out.println("..............................");
        System.out.println("[스터디그룹 HOME] 메뉴를 선택하세요");
        System.out.println("..............................");
        System.out.println("[1] 등록");
        System.out.println("[2] 검색(All)");
        System.out.println("[3] 검색(Id)");
        System.out.println("[4] 검색(Name)");
        System.out.println("[5] 수정(Id)");
        System.out.println("[6] 삭제(Id)");
        System.out.println("..............................");
        System.out.println("[0] 종료");
        System.out.println("..............................");
    }

    private int selectMenu() {
        System.out.print("Select: ");

        int num = sc.nextInt();

        if (0 <= num && num <= 6) {
            return num;
        }else{
            System.out.println("입력한 번호를 다시 확인해주십시오: " + num);
            return -1; //입력값 오류
        }

    }

}
