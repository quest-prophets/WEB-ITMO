package lab3.jpa;

import lab3.UserInfo;

import java.util.List;

public class UserInfoService {
    UserInfoDao userInfoDao = new UserInfoDao();

    public UserInfo findUser(int id) {
        return userInfoDao.findById(id);
    }

    public int saveUser(UserInfo result) {
        return userInfoDao.save(result);
    }

    public void deleteUser(UserInfo result) {
        userInfoDao.delete(result);
    }

    public void updateUser(UserInfo user) {
        userInfoDao.update(user);
    }

    public List<UserInfo> findAllUsers() {
        return userInfoDao.findAll();
    }
}
