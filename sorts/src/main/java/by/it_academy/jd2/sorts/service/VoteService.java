package by.it_academy.jd2.sorts.service;

import by.it_academy.jd2.sorts.service.dto.VoteDto;

public class VoteService {
    private static VoteService voteService;

    private VoteService() {}


    public static VoteService getVoteService(){
        if(voteService == null){
            voteService = new VoteService();
        }
        return voteService;
    }

    public void check (VoteDto vote){

    }

    public void save (VoteDto vote){
        check(vote);

    }
}
