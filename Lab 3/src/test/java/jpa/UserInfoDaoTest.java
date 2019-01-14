package jpa;

import lab3.jpa.UserInfoDao;
import org.junit.Assert;
import org.junit.Test;
import lab3.UserInfo;
import lab3.Group;
import lab3.Result;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoTest {
    @Test
    public void insertEmptyUserTest() {
        UserInfoDao userDao = new UserInfoDao();
        UserInfo user = new UserInfo();
        user.setUsername("admin");
        user.setPassword("adminPassword");

        ArrayList<Result> history = new ArrayList<Result>();
        Result newResult = new Result();
        newResult.setUser(user);
        history.add(newResult);
        user.setResults(history);

        userDao.save(user);
    }

    @Test
    public void insertOneUserTest() {
        UserInfoDao userDao = new UserInfoDao();
        UserInfo user = new UserInfo();
        user.setUsername("user1");
        user.setPassword("password1");

        ArrayList<Group> group = new ArrayList<Group>();
        group.add(new Group("user",user));
        user.setGroups(group);

        ArrayList<Result> history = new ArrayList<Result>();
        history.add(new Result(1.0, 2.0, 2.2, true, LocalDateTime.now(), user));
        history.add(new Result(2.0, 2.0, 1.2, false, LocalDateTime.now(), user));
        history.add(new Result(2.0, 3.0, 0.2, true, LocalDateTime.now(), user));
        user.setResults(history);

        userDao.save(user);
    }

    @Test
    public void findOneUserTest() {
        UserInfo user = new UserInfo();
        user.setUsername("insName");
        user.setPassword("insPassword");

        ArrayList<Result> history = new ArrayList<Result>();
        history.add(new Result(1.0, 2.0, 2.2, true, LocalDateTime.now(), user));
        history.add(new Result(2.0, 2.0, 1.2, false, LocalDateTime.now(), user));
        history.add(new Result(2.0, 3.0, 0.2, true, LocalDateTime.now(), user));
        user.setResults(history);

        UserInfoDao userDao = new UserInfoDao();

        UserInfo receivedUser = userDao.findById(userDao.save(user));
        System.out.println(receivedUser);

        Assert.assertEquals(user.getUsername(), receivedUser.getUsername());
        Assert.assertEquals(user.getPassword(), receivedUser.getPassword());

        List<Result> expectedList = (List<Result>) user.getResults();
        List<Result> recievedList = (List<Result>) receivedUser.getResults();

        for (int i=0; i<user.getResults().size(); i++) {
            Assert.assertEquals(expectedList.get(i).getX(), recievedList.get(i).getX(), 0.001);
            Assert.assertEquals(expectedList.get(i).getY(), recievedList.get(i).getY(), 0.001);
            Assert.assertEquals(expectedList.get(i).getR(), recievedList.get(i).getR(), 0.001);
            Assert.assertEquals(expectedList.get(i).isRes(), recievedList.get(i).isRes());
        }
    }

    @Test
    public void findAllUsersTest() {
        UserInfo user1 = new UserInfo();
        user1.setUsername("find1");
        user1.setPassword("pass1");

        ArrayList<Result> history1 = new ArrayList<Result>();
        history1.add(new Result(1.0, 223.2, 2.2, true, LocalDateTime.now(), user1));
        history1.add(new Result(232.0, 2.0, 1.2, false, LocalDateTime.now(), user1));
        history1.add(new Result(2.0, 34.0, 0.2, false, LocalDateTime.now(), user1));
        user1.setResults(history1);

        UserInfo user2 = new UserInfo();
        user2.setUsername("find1");
        user2.setPassword("pass1");

        ArrayList<Result> history2 = new ArrayList<Result>();
        history2.add(new Result(1.0, 24.2, 2.2, false, LocalDateTime.now(), user2));
        history2.add(new Result(23.0, 2.0, 11.2, false, LocalDateTime.now(), user2));
        history2.add(new Result(2.0, 343.0, 0.2, true, LocalDateTime.now(), user2));
        user2.setResults(history2);

        UserInfoDao userDao = new UserInfoDao();
        userDao.save(user1);
        userDao.save(user2);

        List<UserInfo> allUsers = userDao.findAll();
        for (UserInfo allUser : allUsers) {
            System.out.println("Username: " + allUser.getUsername() + ", Password: " +
                    allUser.getPassword() + ", Size: " + allUser.getResults().size());
        }
    }

    @Test
    public void updateTest() {
        UserInfo user1 = new UserInfo();
        user1.setUsername("upd");
        user1.setPassword("passUpd");

        ArrayList<Result> history1 = new ArrayList<Result>();
        history1.add(new Result(1.0, 223.2, 2.2, true, LocalDateTime.now(), user1));
        user1.setResults(history1);

        UserInfoDao userDao = new UserInfoDao();
        userDao.save(user1);
        user1.setPassword("sos");
        userDao.save(user1);

        UserInfo receivedUser = userDao.findById(user1.getId());
        Assert.assertEquals(user1.getPassword(), receivedUser.getPassword());
    }

    @Test
    public void deleteTest() {
        UserInfo user1 = new UserInfo();
        user1.setUsername("toDelete");
        user1.setPassword("toDeletePass");

        ArrayList<Result> history1 = new ArrayList<Result>();
        history1.add(new Result(145.0, 223.2, 2.2, true, LocalDateTime.now(), user1));
        user1.setResults(history1);

        UserInfoDao userDao = new UserInfoDao();
        userDao.save(user1);
        userDao.delete(user1);

        UserInfo receivedUser = userDao.findById(user1.getId());
        Assert.assertEquals(null, receivedUser);
    }

    @Test
    public void deleteAllTest() {
        UserInfoDao userDao = new UserInfoDao();
        List<UserInfo> allUsers = userDao.findAll();
        for (UserInfo allUser : allUsers) {
            userDao.delete(allUser);
        }
        List<UserInfo> recievedUsers = userDao.findAll();
        Assert.assertEquals(0, recievedUsers.size());
    }
}
