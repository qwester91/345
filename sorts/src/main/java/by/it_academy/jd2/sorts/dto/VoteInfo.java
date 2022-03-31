package by.it_academy.jd2.sorts.dto;

import java.text.DateFormat;
import java.util.*;

public class VoteInfo {
    public static VoteInfo resultInfo;
    private Map<String, Long> mapResultsInfo;

    private VoteInfo(){
        mapResultsInfo = new HashMap<>();
    }

    public static void isResultInfo(){
        if (resultInfo == null){
            resultInfo = new VoteInfo();
        }
    }

    public Map<String, Long> addInfo(String[] info, Long time){
        String format = DateFormat.getDateTimeInstance().format(new Date(time));
        mapResultsInfo.put(format + "<br>" + info[0] + "<br><br>", time);
        return mapResultsInfo;
    }

    public Map<String, Long> getMapResultsInfo() {

        return mapResultsInfo;
    }
}
