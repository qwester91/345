package by.it_academy.jd2.sorts.Comparators;

import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

        return o1.getValue() - o2.getValue();
    }
}

