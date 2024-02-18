package Controller;

import Domain.StudyGroup;
import Service.StudyGroupService;
import Util.InputUtil;

import java.util.Scanner;

public class StudyGroupController {
    StudyGroupService studyGroupService;
    Scanner sc;
    InputUtil inputUtil;

    public StudyGroupController() {
        inputUtil = new InputUtil();
        sc = new Scanner(System.in);
        studyGroupService = new StudyGroupService();
    }

    public void register() {
        String name = inputUtil.getValue("스터디 이름: (0. 돌아가기) ");
        if(name.equals("0")) return;

        String topic = inputUtil.getValue("스터디 주제: (0. 돌아가기) ");
        if(topic.equals("0")) return;

        String room = inputUtil.getValue("스터디 룸: (0. 돌아가기) ");
        if(room.equals("0")) return;

        String period = inputUtil.getValue("스터디 기간: (0. 돌아가기) ");
        if(period.equals("0")) return;

        String save = inputUtil.getValue("등록하시겠습니까? (9. 등록, 0. 돌아가기");

        if (save.equals("9")) {
            StudyGroup newstudy = new StudyGroup(name, topic, room, period);

            String newId = studyGroupService.register(newstudy);

            System.out.println("===========================================");
            System.out.println(">>스터디그룹 등록: " + newstudy.toString());
            System.out.println("===========================================");


        }else{
            System.out.println("스터디 등록이 취소됐습니다.");
            return;
        }


    }



}
