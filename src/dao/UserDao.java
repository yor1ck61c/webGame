package dao;

import domain.Rank;
import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    int userRegister(User user);

    User findUserByUP(String username, String password);

    void addOnline(int id);

    int findOnlinePlayers();

    void quit(int id);

    User findUserById(int id);

    void changeUserInfoById(User user, int id);

    Rank findRankById(int id);

    void updateRank(Rank rankById, int id);

    void insertUserIntoRank(int id, String username);

    void updateUser(String ranking, String gamingTime, int id);

    List<Rank> findRankByPage(int start, int rows);

    int findAllRank();

    List<Rank> findAllRankPage();
}
