package tech.huning.aurora.util.async.dto;

public class VideoDTO {

    private String title;
    private long duration;

    public VideoDTO(String title, long duration) {
        this.duration = duration;
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
