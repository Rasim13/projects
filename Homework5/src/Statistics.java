import java.util.*;

public class Statistics {
    public void getSortByLikeVideo(Video[] videos) {
        Arrays.sort(videos, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o1.getNumberOfLike() - o2.getNumberOfLike();
            }
        });

//        Video temp;
//        boolean isSorted = false;
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < videos.length - 1; i++) {
//                if (videos[i].getNumberOfLike() > videos[i + 1].getNumberOfLike()) {
//                    isSorted = false;
//                    temp = videos[i];
//                    videos[i] = videos[i + 1];
//                    videos[i + 1] = temp;
//                }
//            }
//        }
    }

    public void getSortByDisLikeVideo(Video[] videos) {
        Arrays.sort(videos, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });

        //        Video temp;
//        boolean isSorted = false;
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < videos.length - 1; i++) {
//                if (videos[i].getNumberOfDislike() > videos[i + 1].getNumberOfDislike()) {
//                    isSorted = false;
//                    temp = videos[i];
//                    videos[i] = videos[i + 1];
//                    videos[i + 1] = temp;
//                }
//            }
//        }
    }

    public void getSortByLikeComment(Comment[] comments) {
        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });

//        Comment temp;
//        boolean isSorted = false;
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < comments.length - 1; i++) {
//                if (comments[i].getNumberOfLike() > comments[i + 1].getNumberOfLike()) {
//                    isSorted = false;
//                    temp = comments[i];
//                    comments[i] = comments[i + 1];
//                    comments[i + 1] = temp;
//                }
//            }
//        }
    }

    public void getSortByDisLikeComment(Comment[] comments) {
        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });

    }
//        Comment temp;
//        boolean isSorted = false;
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < comments.length - 1; i++) {
//                if (comments[i].getNumberOfLike() > comments[i + 1].getNumberOfLike()) {
//                    isSorted = false;
//                    temp = comments[i];
//                    comments[i] = comments[i + 1];
//                    comments[i + 1] = temp;
//                }
//            }
//        }
//    }
}
