package service;

import domain.PageBean;
import domain.Rank;
import domain.User;

public interface UserService {
    boolean findUsername(String username);

    int userRegister(User user);

    User loginCheck(User user);

    void addOnline(int id);

    int findOnlinePlayers();

    void quit(int id);

    User findUserById(int parseInt);

    void changeUserInfoById(User user, int parseInt);

    void uploadGamingTime(String uploadTime, int id);

    PageBean<Rank> findUserByPage(String currentPage, String rows);
}
