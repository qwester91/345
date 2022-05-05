package by.it_academy.jd2.sorts.service.sorters;

import by.it_academy.jd2.sorts.service.comparators.MapComparatorInfo;

import java.util.*;

public class SortsInfo {

        public List<Map.Entry<Long, String>> sortMap(Map<Long, String> choose) {

            List<Map.Entry<Long, String>> entries = new ArrayList<>(choose.entrySet());

            Comparator<Map.Entry<Long, String>> comparator = new MapComparatorInfo();
            Comparator<Map.Entry<Long, String>> reversed = comparator.reversed();
            entries.sort(reversed);
            return entries;
        }
}
