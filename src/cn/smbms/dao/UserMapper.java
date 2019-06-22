package cn.smbms.dao;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询的方法
    List<User> selectUserList();
    //添加的方法
    public int addUser(User user);
    //修改的方法
    public int updateUser(User user);
    //删除的方法
    public int deleteUser(@Param("id") int id);
    //根据条件查询
    List<Bill> getBillList(@Param("productName") String productName,
                           @Param("providerId") int providerId,
                           @Param("isPayment") int isPayment);
}
