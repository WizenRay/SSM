package Evangelion.test;


import Evangelion.dao.UserMapper;
import Evangelion.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

public class Mytest {
    @Test
    public void testAddUser() {
        try {
            // 加载mybatis的全局配置文件
            InputStream inputStream = TestUserMapper.class.getResourceAsStream("/mybatis_config.xml");

            // 创建SqlSessionFactoryBuilder对象，目的是为了获取SqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);

            // 获取SqlSession对象
            SqlSession session = factory.openSession();

            // 获取dao接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println("userMapper:" + userMapper);

            // 创建新用户对象
            User newUser = new User();
            newUser.setName("新用户");
            newUser.setPassword("新密码");
            newUser.setAge(25);
            newUser.setBirthday(new Date());

            // 调用添加用户的方法
            Boolean rowsAffected = userMapper.addUser(newUser);

            if (!rowsAffected) {
                System.out.println("新用户添加成功！");
            } else {
                System.out.println("新用户添加失败！");
            }

            //提交事务（如果需要的话）
            session.commit();

            // 关闭SqlSession
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser() {
        try {
            // 加载mybatis的全局配置文件
            InputStream inputStream = TestUserMapper.class.getResourceAsStream("/mybatis_config.xml");

            // 创建SqlSessionFactoryBuilder对象，目的是为了获取SqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);

            // 获取SqlSession对象
            SqlSession session = factory.openSession();

            // 获取dao接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println("userMapper:" + userMapper);

            // 创建要删除的用户的ID
            int userIdToDelete = 15; // 请将要删除的用户ID替换为实际值

            // 调用删除用户的方法
            Boolean rowsAffected = userMapper.deleteUser(userIdToDelete);

            if (!rowsAffected) {
                System.out.println("用户删除成功！");
            } else {
                System.out.println("用户删除失败或未找到该用户！");
            }

            // 提交事务（如果需要的话）
            session.commit();

            // 关闭SqlSession
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
