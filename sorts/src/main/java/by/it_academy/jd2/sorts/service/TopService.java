package by.it_academy.jd2.sorts.service;

import by.it_academy.jd2.sorts.service.dto.ListOfMusiciansDto;
import by.it_academy.jd2.sorts.service.sorters.Sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopService {

    public List<String> getTop(Map<Integer, Integer> mapResults, List<String> list) {

        Sorts sorts = new Sorts();
        List<Map.Entry<Integer, Integer>> entries = sorts.sortMap(mapResults);

        List<String> result = new ArrayList<>();


        for (Map.Entry<Integer, Integer> entry : entries) {
            result.add(list.get(entry.getKey()) + " - " + entry.getValue() );
        }
        return result;
    }
}
