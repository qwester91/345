package by.it_academy.jd2.sorts.service.dto;

import java.util.Arrays;
import java.util.List;

public class ListOfStylesDto {
    private List<String> styles = Arrays.asList("фолк", "кантри", "блюз", "RnB" ,
            "джаз" ,"шансон", "электронщина", "рок", "хип-хоп", "поп");
    private static ListOfStylesDto listOfStyles;

    private ListOfStylesDto() {}

    public static ListOfStylesDto getListOfStyles(){
        if (listOfStyles == null){
            listOfStyles = new ListOfStylesDto();
        }
        return listOfStyles;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void addStyles(String styles) {
        this.styles.add(styles);
    }
}
