public class User {
    private Long id;
    private String email;
    private String role;
    private String state;

    public User(Long id, String email, String role, String state) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getState() {
        return state;
    }
}
