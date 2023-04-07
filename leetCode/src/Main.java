import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
         * int getYear() - 년도 반환 Month getMonth() - 달 반환 int getDayOfMonth() - 일 반환
         * DayOfWeek getDayOfWeek() - 요일 반환 int getDayOfYear() - 1년 중 며칠인지 반환
         *
         */

        Scanner sc = new Scanner(System.in);
        // 4,8,8,8,8,8,6,12,2,4,4,2,4,4,4,4,2,4,4,4,4
        Deque<Integer> maxList = new LinkedList<>(
                Arrays.asList(8, 8, 6, 12, 8, 8, 8, 8, 8, 6, 12, 2, 4, 4, 2, 4, 4, 4, 4, 2, 4, 4, 4, 4));

        List<Integer> backList = new ArrayList<>(
                Arrays.asList(8, 8, 6, 12, 8, 8, 8, 8, 8, 6, 12, 2, 4, 4, 2, 4, 4, 4, 4, 2, 4, 4, 4, 4));

        System.out.println(" :::::현재 듣고있는 쳅터의 전의 주를 입력 1부터 시작:::::  ");
        System.out.println("과정 주단위 :::::::   8[1], 8[2], 6[3], 12[4], 8[5], 8[6], 8[7], 8[8], 8[9], " +
                "6[10], 12[11], 2[12], 4[13], 4[14], 2[15], 4[16], 4[17], " +
                "4[18], 4[19], 2[20], 4[21], 4[22], 4[23], 4[24] " +
                "::::::");
        int length=sc.nextInt();

        for (int i = 1; i <= length; i++) {
            maxList.poll();
        }

        System.out.println("::::현재 듣고 있는 쳅터 의 주 중 몇 주 까지 들었는지 입력::::");

        LocalDateTime todayDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime finishedDate = LocalDateTime.now(ZoneId.of("Asia/Seoul")).of(2024, 3, 30, 0, 0, 0);

        System.out.println("d_day ::::"+ChronoUnit.DAYS.between(todayDate,finishedDate));


        int sum = maxList.stream().mapToInt(i -> i).sum();
        System.out.println("주 단위로 들었을 때 총 합" + sum);

        int calc_day = 0;

        for (int i = 0; i < backList.size()-length; i++) {


            System.out.println("번호 ::"+(i+1));

            calc_day += maxList.poll();

            System.out.println( "calcDay"+ calc_day);
            LocalDateTime maxLocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul")).plusDays(calc_day);
            LocalDateTime maxLocalDateTimeWeek = LocalDateTime.now(ZoneId.of("Asia/Seoul")).plusWeeks(calc_day);
            LocalDateTime maxLocalDateTimeMyCalcDay = LocalDateTime.now(ZoneId.of("Asia/Seoul")).plusDays(calc_day*2);

            System.out.println("=================================================");
            System.out.println("오늘 기준   " + dateStr(todayDate));
            System.out.println();
            System.out.println("주->일 단위로 들었을 때 할당량   " + dateStr(maxLocalDateTime));
            System.out.println();
            System.out.println("주->일 단위로 나눠 들었을 때 할당량 (현재 학습 속도)  " + dateStr(maxLocalDateTimeMyCalcDay));
            System.out.println();
            System.out.println("주->주 단위로 들었을 때 할당량    " + dateStr(maxLocalDateTimeWeek));
            System.out.println();
            System.out.println("끝나는 날짜   " + dateStr(finishedDate));
            System.out.println("=================================================");
        }

    }

    private static String dateStr(LocalDateTime localDateTime) {

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
    }

}
