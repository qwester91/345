package by.it_academy.jd2.sorts.service.dto;

import java.util.Arrays;
import java.util.List;

public class ListOfMusiciansDto {
    private List<String> musiciants = Arrays.asList("Ленька Агутин" , "Hurts" , "Круг" , "Ёлка");
    private static ListOfMusiciansDto listOfMusicians;

    private ListOfMusiciansDto() {}

    public static ListOfMusiciansDto getListOfMusicians(){
        if (listOfMusicians == null){
            listOfMusicians = new ListOfMusiciansDto();
        }
        return listOfMusicians;
    }

    public List<String> getMusiciants() {
        return musiciants;
    }

    public void addMusiciants(String musiciant) {
        musiciants.add(musiciant);
    }

    public boolean isExist(int index){
        int size = musiciants.size();
        return index >= 0 && index < size;

    }
}
