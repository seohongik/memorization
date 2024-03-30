package facade;

public class Projector {

    final String KIND_OF_PROJECTOR = "프로젝터";

    public void on() {
        System.out.println(KIND_OF_PROJECTOR+"가 켜졌습니다.");
    }

    public void off() {
        System.out.println(KIND_OF_PROJECTOR+"가 꺼졌습니다.");
    }

    public void wideScreenMode() {
        System.out.println(KIND_OF_PROJECTOR+"화면 비율을 와이드 모드로 설정합니다.(16:9 비율)");
    }
}
