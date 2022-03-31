package by.it_academy.jd2.sorts.dto;

import java.util.HashMap;
import java.util.Map;

public class VoteResultsStyles {
    public static VoteResultsStyles resultsStyles;
    private Map<String, Integer> mapResultsStyles;


    private VoteResultsStyles(){
        mapResultsStyles = new HashMap<>();
    }

    public static void isResultStyles(){
        if (resultsStyles == null){
            resultsStyles = new VoteResultsStyles();
        }
    }

    public void addStyles(String[] styles){

        for (String style : styles) {
        Integer countVoice = mapResultsStyles.getOrDefault(style, 0);
        mapResultsStyles.put(style, ++countVoice);
        }

    }
    public Map<String, Integer> getMapResultsStyles() {
        return mapResultsStyles;
    }
}
