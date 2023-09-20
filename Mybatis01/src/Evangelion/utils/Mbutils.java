package Evangelion.utils;

import Evangelion.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mbutils
{
    private static SqlSessionFactory factory;//默认值为空

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        List<User> list = session.selectList("Evangelion.dao.UserMapper.findALL");
        for (User user : list) {
            System.out.println(user);
        }
    }

    public static SqlSessionFactory getFactory() //创建sql
    {
        return factory;
    }
}
