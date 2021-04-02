import java.util.List;

public class Video {
    private String name;
    private int numberOfLike;
    private int numberOfDislike;
    private List<Comment> listVideo;
    private int videoDuration;
    private User author;

    public Video(String name, int numberOfLike, int numberOfDislike,
                 int videoDuration) {
        this.name = name;
        this.numberOfLike = numberOfLike;
        this.numberOfDislike = numberOfDislike;
        this.videoDuration = videoDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public int getNumberOfDislike() {
        return numberOfDislike;
    }

    public List<Comment> getListVideo() {
        return listVideo;
    }

    public double getVideoDuration() {
        return videoDuration;
    }

    public User getAuthor() {
        return author;
    }

}
