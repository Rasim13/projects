public class Comment {
    private String text;
    private int numberOfLike;
    private int numberOfDislike;
    private User author;

    public Comment(String text, int numberOfLike,
                   int numberOfDislike, User author) {
        this.text = text;
        this.numberOfLike = numberOfLike;
        this.numberOfDislike = numberOfDislike;
        this.author = author;
    }

    public Comment(String text, int numberOfLike,
                   int numberOfDislike) {
        this.text = text;
        this.numberOfLike = numberOfLike;
        this.numberOfDislike = numberOfDislike;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public int getNumberOfDislike() {
        return numberOfDislike;
    }

}
