package sterams;

import comparing.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user0 = new User(100L, "User1", "User1", 44);
        User user1 = new User(22L, "User2", "User2", 30);
        User user2 = new User(3L, "User3", "User3", 25);
        User user3 = new User(1L, "User4", "User4", 48);
        User user4 = new User(40L, "User5", "User5", 10);
        User user5 = new User(33L, "User6", "User6", 15);
        User user6 = new User(44L, "User7", "User7", 35);
        User user7 = new User(8L, "User8", "User8", 44);
        User user8 = new User(9L, "User9", "User9", 21);
        User user9 = new User(7L, "User10", "User10", 40);

        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);

        List<Long> ids = users.stream()
                .filter(user -> user.getAge() > 30)
                .sorted(Comparator.comparingInt(User::getAge))
                .map(User::getId)
                .collect(Collectors.toList());

    }
}
