package by.it_academy.jd2.sorts.service.sorters;

import by.it_academy.jd2.sorts.service.comparators.MapComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Sorts {

        public List<Map.Entry<Integer, Integer>> sortMap(Map<Integer, Integer> choose) {

            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(choose.entrySet());

            Comparator<Map.Entry<Integer, Integer>> comparator = new MapComparator();
            Comparator<Map.Entry<Integer, Integer>> reversed = comparator.reversed();
            entries.sort(reversed);
            return entries;
        }
}
