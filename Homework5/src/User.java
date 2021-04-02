import java.util.List;

public class User {
    private String name;
    private List<Video> listVideo;
    private List<Comment> listUser;

    public User(String name,List<Video> listVideo, List<Comment> listUser) {
        this.name = name;
        this.listUser = listUser;
        this.listVideo = listVideo;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Comment> getListUser() {
        return listUser;
    }

}
