package Evangelion.test;

import Evangelion.dao.UserMapper;
import Evangelion.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

public class TestUserMapper {
    public static void main(String[] args) {
        try {
            //1.加载mybatis的全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");

            //2.创建SqlSessionFactoryBuilder对象，目的是为了获取SqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);

            //3.获取SqlSession对象
            SqlSession session = factory.openSession();

            //4.执行功能
           //List<User> list=session.selectList("mytest.findAll");

            //4.获取dao接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println("userMapper:" + userMapper);

            //5.执行功能
            List<User> list = userMapper.getAll();
            for (User user : list) {
              System.out.println("----------------------------------------------");
               System.out.println(user);
           }



            //5.事务提交
            //session.commit();

            //6.关闭SqlSession
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}