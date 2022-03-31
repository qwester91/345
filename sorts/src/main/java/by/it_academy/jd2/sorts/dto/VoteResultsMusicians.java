package by.it_academy.jd2.sorts.dto;

import java.util.HashMap;
import java.util.Map;

public class VoteResultsMusicians {
    public static VoteResultsMusicians result;
    private Map<String, Integer> mapResultsMusicians;
   
    private VoteResultsMusicians(){
        mapResultsMusicians = new HashMap<>();
    }
   
    public static void isResultMusicians(){
        if (result == null){
            result = new VoteResultsMusicians();
        }
    }

    public Map<String, Integer> addMusicians(String[] musicians){

        for (String musician : musicians) {
        Integer countVoice = mapResultsMusicians.getOrDefault(musician, 0);
        mapResultsMusicians.put(musician, ++countVoice);
    }
        return mapResultsMusicians;
    }

    public Map<String, Integer> getMapResultsMusicians() {
        return mapResultsMusicians;
    }
}
