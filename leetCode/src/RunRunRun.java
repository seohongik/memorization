import java.util.LinkedHashMap;
import java.util.Map;

public class RunRunRun {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        callings = new String[]{"kai", "kai", "mine", "mine"};

        Map<String, Integer > run_map = new LinkedHashMap<>();

        Map<Integer, String > call_map = new LinkedHashMap<>();

        Map<Integer, String > players_map = new LinkedHashMap<>();

        for(int i=0; i<callings.length; i++){
            call_map.put(i,callings[i]);
        }

        for(int i=0; i<players.length; i++){
            run_map.put(players[i],i);

            players_map.put (i, players[i]);
        }

        System.out.println(call_map);
        System.out.println(run_map);


        for(int i=0; i< callings.length; i++){

            if(run_map.containsKey(callings[i])){

               int ahead= run_map.get(callings[i]);

               String catch_runner=players_map.get(ahead);

                System.out.println(catch_runner);


               System.out.println(ahead +"player ::" + callings[i]);

            }

        }





        return answer;
    }
}
