package comparing;

import java.util.Comparator;

public class UsersByIdComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Long.compare(o1.getId(),o2.getId());
    }
}
