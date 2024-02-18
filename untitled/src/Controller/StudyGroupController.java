package Controller;

import Domain.StudyGroup;
import Service.StudyGroupService;
import Util.InputUtil;

import java.util.List;
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
        while (true) {
            String name = inputUtil.getValue("스터디 이름: (0. 돌아가기) ");
            if(!validateName(name)){
                if(name.equals("0")) return;
                System.out.println("스터디 이름은 두 글자 이상입니다.");
                continue;
            }

            String topic = inputUtil.getValue("스터디 주제: (0. 돌아가기) ");
            if(topic.equals("0")) return;

            String room = inputUtil.getValue("스터디 룸: (0. 돌아가기) ");
            if(room.equals("0")) return;

            String period = inputUtil.getValue("스터디 기간: (0. 돌아가기) ");
            if(period.equals("0")) return;

            String save = inputUtil.getValue("등록하시겠습니까? (9. 등록, 0. 돌아가기)");

            if (save.equals("9")) {
                StudyGroup newstudy = new StudyGroup(name, topic, room, period);

                studyGroupService.register(newstudy);

                System.out.println("===========================================");
                System.out.println(">>스터디그룹 등록: " + newstudy.toString());
                System.out.println("===========================================");
                return;
            }else{
                System.out.println("스터디 등록이 취소됐습니다.");
                return;
            }
        }

    }

    public void findById() {
        StudyGroup findGroup;

        while (true) {
            String findId = inputUtil.getValue("아이디 검색: (0. 돌아가기)");
            if(findId.equals("0")) break;

            findGroup = studyGroupService.findById(findId);
            if (findGroup != null) {
                System.out.println("스터디 조회 결과: \n" + findGroup.toString());
                return;
            }else{
                System.out.println("해당 Id의 스터디 그룹이 없습니다. " + findId);
            }
        }
    }

    public void findByName() {
        while (true) {
            String findName = inputUtil.getValue("이름 검색: (0. 돌아가기)");
            if(findName.equals("0")) return;

            List<StudyGroup> groups = studyGroupService.findByName(findName);
            if(!groups.isEmpty()) {
                System.out.println("총 "+ groups.size() + "건의 스터디 그룹이 조회됩니다.");
                for (StudyGroup group : studyGroupService.findByName(findName)) {
                    System.out.println(group.toString());
                }
                return;
            } else{
                System.out.println("해당 이름의 스터디 그룹이 없습니다." + findName);
                return;
            }
        }

    }

    public boolean validateName(String name) {
        return name.length() > 2;
    }


}
