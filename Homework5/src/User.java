import java.util.List;

public class User {
    private String name;
    private List<Video> listVideo;
    private List<Comment> listUser;
    private int profit;

    public User(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }


    public int getProfit() {
        return profit;
    }

    public String getName() {
        return name;
    }

    public List<Comment> getListUser() {
        return listUser;
    }

}
