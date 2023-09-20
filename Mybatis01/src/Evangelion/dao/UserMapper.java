package Evangelion.dao;

import Evangelion.pojo.User;

import java.util.List;

/**操作数据库，实现CURD
  1.方法返回值：由查询结果记录条数决定，若最多记录为一条，则返回实体类一个对象，若多条记录则返回一个泛型集合（即表对应的实体类）
  2.方法形参：由sql语句中的占位符决定,若sql语句中无占位符则不需要形参,若Sql语句中含有多个占位符，占位符的值可以封装于一个实体类对象里（表中的一个记录，对应实体类的一个对象）
  3.添删改操作系统回默认返回一个整数，所以返回值值int,如果不需要返回值，可以配置void,所以返回值为:void/int
 */

public interface UserMapper
{
        public List<User> getAll();//查询所有用户信息

        public Boolean addUser(User user);//新增

        public Boolean deleteUser(int id);//删除

        public User getUserById(int id);//根据id查询
}
