package by.it_academy.jd2.sorts.service;

import by.it_academy.jd2.sorts.service.dto.ListOfMusiciansDto;
import by.it_academy.jd2.sorts.service.sorters.Sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopService {

    public List<String> getTop(Map<Integer, Integer> mapResults) {
        Map<Integer, Integer> mapResultsMusicians =
                VoteService.getVoteService().getMusicantsVote();

        Sorts sorts = new Sorts();
        List<Map.Entry<Integer, Integer>> entries = sorts.sortMap(mapResultsMusicians);

        List<String> result = new ArrayList<>();
        List<String> musiciants = ListOfMusiciansDto.getListOfMusicians().getMusiciants();

        for (Map.Entry<Integer, Integer> entry : entries) {
            result.add(musiciants.get(entry.getKey()) + " - " + entry.getValue() );
        }
        return result;
    }
}
