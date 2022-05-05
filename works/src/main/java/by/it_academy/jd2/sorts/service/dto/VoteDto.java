package by.it_academy.jd2.sorts.service.dto;

public class VoteDto {
    private static VoteDto voteDto;
    private int musician;
    private int[] styles;
    private String info;
    private long time;

    public VoteDto(int musician, int[] styles, String info, Long time) {
        this.musician = musician;
        this.styles = styles;
        this.info = info;
        this.time = time;
    }

    public int getMusician() {
        return musician;
    }

    public void setMusician(int musician) {
        this.musician = musician;
    }

    public int[] getStyles() {
        return styles;
    }

    public void setStyles(int[] styles) {
        this.styles = styles;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
