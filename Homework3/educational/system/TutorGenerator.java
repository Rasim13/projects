package educational.system;

import java.util.Random;

public class TutorGenerator {
    public static String[] names= {
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
            "Иван Петров",
            "Иван Усов",
            "Таисия Федорова",
            "Тимур Антонов",
            "Ярослав Фролов",
            "Полина Мартынова",
            "Владимир Куликов",
            "Ангелина Данилова",
            "Анна Муравьева",
            "Ангелина Бирюкова",
            "Анна Денисова",
            "Илья Богомолов",
            "Михаил Иванов",
            "Софья Михайлова"};

    private Random random;

    public TutorGenerator(){
        this.random = new Random();
    }

    public Tutor[] getTutors(int n){
        Tutor[] tutors = new Tutor[n];
        for (int i = 0; i < n; i++) {
            tutors[i] = getTutor();
        }
        return tutors;
    }

    private Tutor getTutor() {
        return new Tutor(names[random.nextInt(20)],
                21 + random.nextInt(70),
                15000 + (150000 - 15000) * random.nextDouble());
    }
}
