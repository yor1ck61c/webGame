package domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String socialAccount;
    private String ranking;
    private String gamingTime;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getGamingTime() {
        return gamingTime;
    }

    public void setGamingTime(String gamingTime) {
        this.gamingTime = gamingTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", socialAccount='" + socialAccount + '\'' +
                ", ranking='" + ranking + '\'' +
                ", gamingTime='" + gamingTime + '\'' +
                '}';
    }
}
