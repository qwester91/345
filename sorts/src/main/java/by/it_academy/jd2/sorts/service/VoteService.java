package by.it_academy.jd2.sorts.service;

import by.it_academy.jd2.sorts.service.dto.ListOfMusiciansDto;
import by.it_academy.jd2.sorts.service.dto.ListOfStylesDto;
import by.it_academy.jd2.sorts.service.dto.VoteDto;

import java.util.HashMap;
import java.util.Map;

public class VoteService {
    private static VoteService voteService;
    private Map<Integer,Integer> musicantsVote;
    private Map<Integer,Integer> stylesVote;
    private Map<Long, String> infoTime;
    private  Integer sync = 8;

    private VoteService() {
        musicantsVote = new HashMap<>();
        stylesVote = new HashMap<>();
        infoTime = new HashMap<>();
    }


    public static VoteService getVoteService(){
        if(voteService == null){
            voteService = new VoteService();
        }
        return voteService;
    }

    public void check (VoteDto vote){
        if(vote.getStyles().length < 3 || vote.getStyles().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!ListOfMusiciansDto.getListOfMusicians().isExist(vote.getMusician())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }
        for (int style : vote.getStyles()) {
            if(!ListOfStylesDto.getListOfStyles().isExist(style)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }

    }

    public void save (VoteDto vote){
        check(vote);

        synchronized (sync){
            Integer orDefaultMusician = musicantsVote.getOrDefault(vote.getMusician(), 0);
            musicantsVote.put(vote.getMusician(), orDefaultMusician);

            for (int style : vote.getStyles()) {
                Integer orDefaultStyle = stylesVote.getOrDefault(style, 0);
                stylesVote.put(style, orDefaultStyle);
            }
            infoTime.put(vote.getTime(), vote.getInfo());

        }

    }

    public Map<Integer, Integer> getMusicantsVote() {
        return musicantsVote;
    }

    public Map<Integer, Integer> getStylesVote() {
        return stylesVote;
    }

    public Map<Long, String> getInfoTime() {
        return infoTime;
    }
}
