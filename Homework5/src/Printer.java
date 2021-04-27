
public class Printer {
    public void printVideos(Video[] videos) {
        System.out.printf("|%42s|%4s|%7s|%8s|\n", "Name Video", "Like", "DisLike", "Duration");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < videos.length; i++) {
            System.out.printf("|%42s|%4d|%7d|%8s|\n", videos[i].getName(), videos[i].getNumberOfLike(),
                    videos[i].getNumberOfDislike(), videos[i].getVideoDuration());
        }
        System.out.println("==================================================================");
    }

    public void printComments(Comment[] comments) {
        System.out.printf("|%66s|%4s|%7s|\n", "Text comment", "Like", "DisLike");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < comments.length; i++) {
            System.out.printf("|%70s|%4d|%7d|\n", comments[i].getText(), comments[i].getNumberOfLike(),
                    comments[i].getNumberOfDislike());
        }
        System.out.println("=====================================================================================");
    }

    public void printUsers(User[] users) {
        System.out.printf("|%20s|%15s|\n", "Name", "Profit");
        System.out.println("-------------------------------------");
        for (int i = 0; i < users.length; i++) {
            System.out.printf("|%20s|%15d|\n", users[i].getName(), users[i].getProfit());
        }
        System.out.println("=====================================");
    }

    public void printGenerally(Video[] videos, Comment[] comments, User[] users) {
        System.out.printf("|%42s|%4s|%7s|%8s|%20s|%65s|%4s|%7s|%6s|\n", "Name video", "Like", "DisLike", "Duration",
                "Name commentator", "Text comment", "Like", "DisLike","Profit");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < comments.length; i++) {
            System.out.printf("|%42s|%4d|%7d|%8s|%20s|%65s|%4d|%7d|%6d|\n", videos[i].getName(), videos[i].getNumberOfLike(),
                    videos[i].getNumberOfDislike(), videos[i].getVideoDuration(),users[i].getName(),comments[i].getText(),
                    comments[i].getNumberOfLike(), comments[i].getNumberOfDislike(),users[i].getProfit());
        }
        System.out.println("=============================================================================================================================================================================");
    }

    public void printSortedVideos(Video[] videos) {
        System.out.printf("|%42s|\n", "Name Video");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < videos.length; i++) {
            System.out.printf("|%40s|\n", videos[i].getName());
        }
        System.out.println("==================================================================");
    }

}
