package facade;

public class Screen {
    final String KIND_OF_SCREEN= "스크린";
    public void down() {
        System.out.println(KIND_OF_SCREEN+"이 내려옵니다.");
    }

    public void up() {
        System.out.println(KIND_OF_SCREEN+"이 올라갑니다.");
    }
}
