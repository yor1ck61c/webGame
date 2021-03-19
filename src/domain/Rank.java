package domain;

public class Rank implements Comparable<Rank>{
    private int id;
    private String username;
    private String gamingTime;
    private String ranking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGamingTime() {
        return gamingTime;
    }

    public void setGamingTime(String gamingTime) {
        this.gamingTime = gamingTime;
    }


    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gamingTime='" + gamingTime + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }

    @Override
    public int compareTo(Rank o) {
        return Double.parseDouble(this.gamingTime) > Double.parseDouble(o.getGamingTime()) ? -1 : 1 ;
    }
}
