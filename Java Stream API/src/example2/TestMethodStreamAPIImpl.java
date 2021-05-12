package example2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethodStreamAPIImpl implements TestMethod {

    private final Collection<People> peoples = Arrays.asList(
            new People("Вася", 16, Sex.MAN),
            new People("Петя", 23, Sex.MAN),
            new People("Елена", 42, Sex.WOMEN),
            new People("Иван Иванович", 69, Sex.MAN));

    private final Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

    @Override
    public void testFilterAndCount() {

        //вернуть количество вхождений
        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("Count = " + count);

        // выбрать все элементы по шаблону
        List<String> select = collection.stream().filter(s -> s.contains("1")).collect(Collectors.toList());
        System.out.println("Select = " + select);

        // выбрать военнообязанных
        List<People> militaryService = peoples.stream()
                .filter(people -> people.getAge() >= 18 && people.getAge() < 27
                && people.getSex() == Sex.MAN)
                .collect(Collectors.toList());
        System.out.println("MilitaryService = " + militaryService);

        // Найти средний возраст среди мужчин
        double manAverageAge = peoples.stream()
                .filter(people -> people.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge);

        //Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и
        // учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long peopleHowCanWork = peoples.stream().filter(people -> people.getAge() >= 18)
                .filter(people -> (people.getSex() == Sex.WOMEN && people.getAge() < 55)
                || (people.getSex() == Sex.MAN && people.getAge() < 60))
                .count();
        System.out.println("peopleHowCanWork =" + peopleHowCanWork);

    }

    @Override
    public void testFindFirstSkipCount() {
        //вернуть первый элемет колллекции
        String first = collection.stream().findFirst().orElse("1");
        System.out.println("first = " + first);

        // вернуть последний элементо колллекции
        String last = collection.stream().skip(collection.size() - 1)
                .findAny()
                .orElse("1");
        System.out.println("last = " + last);

        // найти элемент в коллекции
        String find = collection.stream().filter("a3"::equals)
                .findFirst()
                .get();
        System.out.println("find = " + find);

        // вернуть третий элемент коллекции по порядку
        String third = collection.stream().skip(2)
                .findFirst()
                .get();
        System.out.println("third = " + third);
    }

    @Override
    public void testLimit() {
        // вернуть два элемента
        List<String> limit = collection.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("limit = " + limit);

        //вернуть два элемента начиная со второго
        List<String> fromTo = collection.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("fromTo = " + fromTo);
    }
}
