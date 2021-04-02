import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommentGenerator {
    public static List<String> comments = new ArrayList<>(Arrays.asList(
            "Крутое видео, спасибо.",
            "Приятно слушать, взвешенные и ясные ответы на вопросы",
            "Портясающе комфортный темп, чистота и продуманности речи.",
            "Интервью не впечатлило, гость отвечал на вопросы не полностью.",
            "Тема под видео не раскрыта, двоякое мнение об интервью.",
            "Классное интервью, приятные ребята, в общем все супер.",
            "Какой он живой, очаровательный и при этом содержательный.",
            "Интервью не понравилось, отписываюсь.",
            "Даааа, докатились. Смотришь зашитую в ролик рекламу."
    ));

    private Random random;

    public CommentGenerator() {
        this.random = new Random();
    }

    public Comment[] getComments(int n) {
        Comment[] comment = new Comment[n];
        if (n > comments.size()) {
            throw new IllegalArgumentException("Can't generate comments");
        }
        for (int i = 0; i < n; i++) {
            comment[i] = getComment(i);
        }
        return comment;
    }

    public Comment getComment(int i) {
        return new Comment(comments.get(random.nextInt(comments.size())), random.nextInt(100), random.nextInt(100));
    }
}
