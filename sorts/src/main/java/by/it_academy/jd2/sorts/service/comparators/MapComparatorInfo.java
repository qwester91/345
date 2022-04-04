package by.it_academy.jd2.sorts.service.comparators;

import java.util.Comparator;
import java.util.Map;

public class MapComparatorInfo implements Comparator<Map.Entry<Long, String>> {
    @Override
    public int compare(Map.Entry<Long, String> o1, Map.Entry<Long, String> o2) {
        if(o1.getKey() - o2.getKey() > 0){
            return 1;
        }else if(o1.getKey() - o2.getKey() < 0){
            return -1;
        }else return 0;
    }
}

