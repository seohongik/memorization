package facade;

public class PopcornPopper {

    final String KIND_OF_POPPER = "팝곤 기계";

    public void on() {
        System.out.println(KIND_OF_POPPER+"가 켜졌습니다.");
    }

    public void off() {
        System.out.println(KIND_OF_POPPER+"가 꺼졌습니다.");
    }

    public void pop() {

        System.out.println(KIND_OF_POPPER+"에서 팝콘을 튀기고 있습니다.");
    }
}
