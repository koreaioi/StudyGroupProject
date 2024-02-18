package Controller;

import Domain.StudyGroup;
import Service.StudyGroupService;
import Util.InputUtil;

import java.util.List;
import java.util.Locale;
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

    public void findAll() {
        List<StudyGroup> groups = studyGroupService.findAll();
        if(!groups.isEmpty()){
            System.out.println("총 " +groups.size() +"건의 스터디 그룹이 조회됩니다.");
            for (StudyGroup group : groups) System.out.println(group.toString());
        }else{
            System.out.println("등록된 스터디 그룹이 없습니다.");
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

    public void delete() {
        /*
        * 삭제할 Id를 입력받는다.
        * 해당 Id가 있는지 확인한다. (findByOne)
        * 있으면 Service.delete(Id)로 삭제
        * 없으면 해당 Id인 스터디 그룹이 없다고 알리고 다시 입력
        * */
        StudyGroup findgroup = findByOne();
        if(findgroup == null) {
            System.out.println("스터디 그룹 삭제가 취소됩니다.");
            return;
        }

        String confirm = inputUtil.getValue("스터디 그룹을 삭제하겠습니까? (y/n)");

        if(confirm.equalsIgnoreCase("y")){
            System.out.println("[" + findgroup.getId() + "] 스터디 그룹이 삭제됩니다." );
            studyGroupService.delete(findgroup.getId());
        }else{
            System.out.println("스터디 그룹 삭제가 취소 됩니다.");
        }
    }

    public boolean validateName(String name) {
        return name.length() > 2;
    }

    public StudyGroup findByOne() {
        //findById의 반환 타입이 StudyGroup이고 String으로 하면 findgroup이 null일 경우 처리하기 까다로움
        StudyGroup findGroup = null;

        while (true) {
            String findId = inputUtil.getValue("삭제할 Id를 입력하세요: (0. 돌아가기)");
            if(findId.equals("0")) return findGroup;

            findGroup = studyGroupService.findById(findId);

            if (findGroup != null) break;
            else System.out.println("해당 Id로 조회되는 스터디 그룹이 없습니다." + findId);
        }
        return findGroup;
    }


}
