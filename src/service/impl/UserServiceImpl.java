package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.Rank;
import domain.User;
import org.junit.Test;
import service.UserService;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public boolean findUsername(String username) {
        return dao.findUserByUsername(username) == null;
    }

    @Override
    public int userRegister(User user) {
        return dao.userRegister(user);
    }

    @Override
    public User loginCheck(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return dao.findUserByUP(username,password);
    }

    @Override
    public void addOnline(int id) {
        dao.addOnline(id);
    }

    @Override
    public int findOnlinePlayers() {
        return dao.findOnlinePlayers();
    }

    @Override
    public void quit(int id) {
        dao.quit(id);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public void changeUserInfoById(User user, int id) {
        dao.changeUserInfoById(user,id);
    }


    @Override
    public void uploadGamingTime(String uploadTime, int id) {
        Rank rankById = dao.findRankById(id);

        User userById = dao.findUserById(id);
        String username = userById.getUsername();
        if (rankById == null){
            rankById = new Rank();
            rankById.setGamingTime("0");
            dao.insertUserIntoRank(id,username);
        }
        rankById.setId(id);
        rankById.setUsername(username);
        String gamingTime = rankById.getGamingTime();

        if (Double.parseDouble(uploadTime) > Double.parseDouble(gamingTime)){
            if(Double.parseDouble(uploadTime) >= 0 && Double.parseDouble(uploadTime) <= 20){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("英勇黄铜");
            }
            if(Double.parseDouble(uploadTime) > 20 && Double.parseDouble(uploadTime) <= 30){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("不屈白银");
            }
            if(Double.parseDouble(uploadTime) > 30 && Double.parseDouble(uploadTime) <= 40){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("荣耀黄金");
            }
            if(Double.parseDouble(uploadTime) > 40 && Double.parseDouble(uploadTime) <= 50){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("华贵铂金");
            }
            if(Double.parseDouble(uploadTime) > 50 && Double.parseDouble(uploadTime) <= 70){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("璀璨钻石");
            }
            if(Double.parseDouble(uploadTime) > 70 && Double.parseDouble(uploadTime) < 100){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("最强王者");
            }
            if(Double.parseDouble(uploadTime) >=100){
                rankById.setGamingTime(uploadTime);
                rankById.setRanking("真男人");
            }
        }
        dao.updateRank(rankById,id);
        dao.updateUser(rankById.getRanking(),rankById.getGamingTime(),id);
    }

    @Override
    public PageBean<Rank> findUserByPage(String _currentPage, String _rows) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        PageBean<Rank> rankPageBean = new PageBean<Rank>();

        rankPageBean.setCurrentPage(currentPage);
        rankPageBean.setRows(rows);

        List<Rank> allRankPage = dao.findAllRankPage();
        Collections.sort(allRankPage);

        int totalCount = dao.findAllRank();
        rankPageBean.setTotalCount(totalCount);

        if( currentPage * rows > totalCount){
            rankPageBean.setList(allRankPage.subList((currentPage-1) * rows, totalCount));
        }else {
            rankPageBean.setList(allRankPage.subList((currentPage-1) * rows, (currentPage * rows)));
        }

        int totalPage = totalCount % rows == 0? (totalCount / rows) : (totalCount/rows) + 1;
        rankPageBean.setTotalPage(totalPage);

        return rankPageBean;
    }

    @Test
    public void test(){
        List<Rank> rankByPage = dao.findRankByPage(1, 10);
        Collections.sort(rankByPage);
        for (Rank rank:rankByPage) {
            System.out.println(rank.toString());
        }
    }
}
