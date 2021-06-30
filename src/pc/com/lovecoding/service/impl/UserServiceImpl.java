package pc.com.lovecoding.service.impl;

import pc.com.lovecoding.dao.UserDao;
import pc.com.lovecoding.service.UserService;
import pc.com.lovecoding.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;

    static {
        userDao = new UserDao();
    }
    /**
     * 注册用户
     * @param parameterMap
     * @return
     */
    @Override
    public int register(Map<String, String[]> parameterMap) {
        try {
            User user = new User();
            BeanUtils.populate(user , parameterMap);//封装好JavaBean .配合前端获取的map对象
            System.out.println("uuid = " + UUID.randomUUID().toString());
            user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
            System.out.println("user = " + user);
            return userDao.register(user);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 登录校验
     */
    @Override
    public User login(String username, String password) {

        return userDao.login(username , password);
    }
}
