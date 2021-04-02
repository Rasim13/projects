import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VideoGenerator {
    public static List<String> videos = new ArrayList(Arrays.asList(
            "Николай Давыдов о сделке MSQRD.",
            "Юрий Мильнер о космических инвестияциях.",
            "Netflix по - русски.",
            "Сергей Галицкий. Магнит.",
            "Основатель ВкусВиллла.Андрей Кривиенко.",
            "Миллиардеры из Вологды.Братья Бухманы.",
            "Профессор Пристона в 26 лет.",
            "Леонид Богуславский о яндексе, Ozon.",
            "Микита Микадо о белорусах в долине."
    ));

    private Random random;

    public VideoGenerator() {
        this.random = new Random();
    }

    public Video[] getVideos(int n) {
        Video[] video = new Video[n];
        if (n > videos.size()) {
            throw new IllegalArgumentException("Can't generate videos");
        }
        for (int i = 0; i < n; i++) {
            video[i] = getVideo(i);
        }
        return video;
    }

    public Video getVideo(int i) {
        return new Video(videos.get(random.nextInt(videos.size())), random.nextInt(100), random.nextInt(100), random.nextInt(300));
    }
}
