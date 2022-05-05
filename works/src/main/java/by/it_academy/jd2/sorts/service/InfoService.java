package by.it_academy.jd2.sorts.service;

import by.it_academy.jd2.sorts.service.dto.VoteDto;
import by.it_academy.jd2.sorts.service.sorters.SortsInfo;

import java.text.DateFormat;
import java.util.*;

public class InfoService {

    public List<String> getInfo(){

        SortsInfo sorts = new SortsInfo();
        List<Map.Entry<Long, String>> entries = sorts.sortMap(VoteService.getVoteService().getInfoTime());
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, String> entry : entries) {
            String format = DateFormat.getDateTimeInstance().format(new Date(entry.getKey()));
            result.add(format + "---" + entry.getValue());
        }

        return result;
    }
}
