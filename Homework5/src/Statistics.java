import java.util.*;

public class Statistics {
    public void getSortByLikeVideo(Video[] videos) {
        Arrays.sort(videos, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                if (o1.getNumberOfLike() == o2.getNumberOfDislike()) {
                    return o2.getNumberOfLike() - o1.getNumberOfLike();
                } else {
                    return o1.getNumberOfLike() - o2.getNumberOfLike();
                }
            }
        });

    }

    public void getSortByDisLikeVideo(Video[] videos) {
        Arrays.sort(videos, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });
    }

    public void getSortByLikeComment(Comment[] comments) {
        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });
    }

    public void getSortByDisLikeComment(Comment[] comments) {
        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getNumberOfDislike() - o2.getNumberOfDislike();
            }
        });

    }

    public void getSortedVideo(Video[] videos) {
          Arrays.sort(videos);
    }
}
