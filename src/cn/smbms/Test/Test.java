package cn.smbms.Test;

import cn.smbms.dao.UserMapper;
import cn.smbms.dao.impl.UserMapperImpl;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test.class);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
        SqlSessionFactory sqlSessionFactory;
        SqlSession sqlSession;
        String configFile = "mybatis-config.xml";
       // List<User> list = null;
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            User user = new User();
           // logger.debug("---------列表------------");
            //根据条件查询
            List<Bill> list=sqlSession.getMapper(UserMapper.class).getBillList("大豆油",6,2);
            for (Bill bill : list) {
                System.out.println(bill.getId()+"\t"
                        +bill.getBillCode()+"\t"
                        +bill.getProductName()+"\t"
                        +bill.getProvider().getProName()+"\t"
                        +bill.getProvider().getId()+"\t"
                        +bill.getTotalPrice()+"\t"
                        +bill.getIsPayment()+"\t"
                        +bill.getCreationDate()+"\t");
            }
           /* //实现类里的查询
            UserMapperImpl userMapper = new UserMapperImpl();
            list =userMapper.selectUserList();
            for(User user1:list){
                System.out.println(user1.getId()+"\t"+user1.getAddress()+"\t"+user1.getCreationDate());
            }*/
            //查询的方法
            /*list=sqlSession.getMapper(UserMapper.class).selectUserList();
            for(User user:list){
                System.out.println(user.getId()+"\t"+user.getAddress()+"\t"+user.getCreationDate());
            }*/
           /* //实现类里的添加
            UserMapperImpl userMapper = new UserMapperImpl();
            user.setUserCode("liyaozong");
            user.setUserName("黎耀宗");
            int i = userMapper.addUser(user);
            if(i>0){
                System.out.println("添加成功");
            }*/

           /* //添加的方法
            user.setUserCode("zhangjiyuan");
            user.setUserName("张继元");
            int add=sqlSession.getMapper(UserMapper.class).addUser(user);*/

          /*  //实现类里的修改
            UserMapperImpl userMapper = new UserMapperImpl();
            user.setUserCode("libing");
            user.setUserName("李斌");
            user.setUserPassword("123456");
            int update =userMapper.updateUser(user);
            if(update>0){
                System.out.println("修改成功");
            }*/


           /* //修改的方法
            user.setUserCode("zhangjiyuan");
            user.setUserName("张继元");
            user.setUserPassword("654321");
            int update=sqlSession.getMapper(UserMapper.class).updateUser(user);*/

          /* //删除的方法实现类里的
            UserMapperImpl userMapper = new UserMapperImpl();
            int delete = userMapper.deleteUser(19);
            if(delete>0){

                System.out.println("删除成功");
            }*/

           //删除的方法
          /*  user.setId(20);
            int delete=sqlSession.getMapper(UserMapper.class).deleteUser(user.getId());
            sqlSession.commit();*/
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
