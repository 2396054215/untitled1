package cn.smbms.dao.impl;

import cn.smbms.Test.Test;
import cn.smbms.dao.UserMapper;
import cn.smbms.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.List;

public class UserMapperImpl{
    Logger logger = Logger.getLogger(Test.class);
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    String configFile = "mybatis-config.xml";


    public List<User> selectUserList() {
        //查询
        List<User> list = null;
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            list= sqlSession.getMapper(UserMapper.class).selectUserList();

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

//添加
    public int addUser(User user) {
        int add=0;
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            add= sqlSession.getMapper(UserMapper.class).addUser(user);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return add;
    }

//修改
    public int updateUser(User user) {
        int update =0;
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            update = sqlSession.getMapper(UserMapper.class).updateUser(user);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int deleteUser(int id) {
        int delete = 0;
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            delete = sqlSession.getMapper(UserMapper.class).deleteUser(id);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return delete;
    }

}
