import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        YearningScore yearningScore = new YearningScore();

        String [] name = new String[]{ "may", "kein", "kain", "radi" };

        int[] yearning= new int[]{ 5, 10, 1, 3 };

        String[][] photo = new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        yearningScore.solution(name, yearning,photo);

    }

}
