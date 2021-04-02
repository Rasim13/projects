import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserGenerator {
    public static List<String> names = new ArrayList<>(Arrays.asList(
            "Никита Матвеев",
            "Евгений Степанов",
            "Вера Романова",
            "София Новикова",
            "София Савина",
            "Илья Никулин",
            "Ольга Лебедева",
            "Алёна Емельянова",
            "Анна Васильева",
            "Святослав Зубков",
            "Руслан Кочетков",
            "Матвей Григорьев",
            "Арина Давыдова",
            "Ярослав Наумов",
            "Екатерина Софронова",
            "Кира Петрова",
            "Вера Ермолова",
            "Михаил Елисеев",
            "Павел Смирнов",
            "Иван Петров"
    ));

    private Random random;

    public UserGenerator(){
        this.random = new Random();
    }

    public User[] getUsers(int n){
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            users[i] = getUser(i);
        }
        return users;
    }

    public User getUser(int i) {
        return new User(names.get(random.nextInt(names.size())));
    }
}
