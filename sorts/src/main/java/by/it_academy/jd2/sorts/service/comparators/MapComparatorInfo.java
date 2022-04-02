package by.it_academy.jd2.sorts.service.comparators;

import java.util.Comparator;
import java.util.Map;

public class MapComparatorInfo implements Comparator<Map.Entry<String, Long>> {
    @Override
    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        if(o1.getValue() - o2.getValue() > 0){
            return 1;
        }else if(o1.getValue() - o2.getValue() < 0){
            return -1;
        }else return 0;
    }
}

