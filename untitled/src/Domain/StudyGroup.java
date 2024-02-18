package Domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class StudyGroup {
    private static final int MIN_NAME_LENGTH = 2; //스터디 그룹 이름의 최소 길이

    private String id;     //강의 고유 id
    private String name;   //스터디 그룹 이름
    private String topic;  //스터디 주제
    private String room;   //스터디 룸
    private String period; //스터디 기간
    private String foundation; //등록일

    //고유 id 같은 경우, 생성자를 private로 지정
    private StudyGroup() {
        this.id = UUID.randomUUID().toString();
    }

    public StudyGroup(String name, String topic, String room, String period) {
        this(); //고유 id
        setName(name);
        this.topic = topic;
        this.room = room;
        this.period = period;
        this.foundation= setFoundation("yyyy.MM.dd a HH:mm:ss");
    }

    public String setFoundation(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public void setName(String name) {
        if(name.length() < MIN_NAME_LENGTH){
            System.out.println("스터디 그룹 명은 2자리 이상입니다.");
            return;
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String getRoom() {
        return room;
    }

    public String getPeriod() {
        return period;
    }

    public String getFoundation() {
        return foundation;
    }

    //StudyGroup.toString 하면 해당 그룹 정보가 나옴
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[스터디 그룹]");
        sb.append("\n - 아이디: ").append(getId());
        sb.append("\n - 스터디 이름: ").append(getName());
        sb.append("\n - 스터디 주제: ").append(getTopic());
        sb.append("\n - 스터디 룸: ").append(getRoom());
        sb.append("\n - 스터디 기간: ").append(getPeriod());
        sb.append("\n - 스터디 등록일: ").append(getFoundation());

        return sb.toString();
    }
}
