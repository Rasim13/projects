public class Main {
    public static void main(String[] args) {
        VideoGenerator videoGenerator = new VideoGenerator();
        CommentGenerator commentGenerator = new CommentGenerator();
        UserGenerator userGenerator = new UserGenerator();
        Printer printer = new Printer();
        Statistics statistics = new Statistics();
        Video[] videos = videoGenerator.getVideos(5);
        Comment[] comments = commentGenerator.getComments(5);
        User[] users = userGenerator.getUsers(5);
        printer.printGenerally(videos, comments, users);
        statistics.getSortByDisLikeVideo(videos);
        printer.printGenerally(videos, comments, users);
    }
}
