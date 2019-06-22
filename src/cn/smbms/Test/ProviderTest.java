package cn.smbms.Test;

import cn.smbms.dao.ProviderMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test.class);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
        SqlSessionFactory sqlSessionFactory;
        SqlSession sqlSession;
        String configFile = "mybatis-config.xml";
        //上机练习2
        /*try {
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            logger.debug("-------查询用户列表--------");
            List<Provider> list = sqlSession.getMapper(ProviderMapper.class).selectProviderList("BJ","北京");
            for (Provider provider : list) {
                System.out.println(provider.getId()+"\t"
                                    +provider.getProCode()+"\t"
                                    +provider.getProName()+"\t"
                                    +provider.getProContact()+"\t"
                                    +provider.getProPhone()+"\t"
                                    +provider.getProFax()+"\t"
                                    +provider.getCreationDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
       /* //上机练习3、4
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            logger.debug("---修改供应商----");
            Provider provider = new Provider();
            provider.setProCode("ZJ GYS002");
            provider.setProName("乐摆日用品");
            provider.setProDesc("长期合作伙伴，主营产品：各种中、高档塑料杯，塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯");
            provider.setProContact("王世杰");
            provider.setId(15);
            int i = sqlSession.getMapper(ProviderMapper.class).updatePrvoder(provider);
            sqlSession.commit();
            if(i>0){
                System.out.println("修改成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
       /* //上机练习5
        try{
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            logger.debug("---修改供应商----");
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Bill> list1 = sqlSession.getMapper(ProviderMapper.class).selectByPrimaryKey2(list);
            for (Bill bill : list1) {
                System.out.println(bill.getId()+"\t"
                                    +bill.getBillCode()+"\t"
                                    +bill.getProvider().getId()+"\t"
                                    +bill.getProvider().getProName()+"\t"
                                    +bill.getTotalPrice()+"\t"
                                    +bill.getIsPayment()+"\t"
                                    +bill.getCreationDate());
            }

        }catch (Exception e){
            e.printStackTrace();
        }*/
        //练习6
        try {
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            logger.debug("---修改供应商----");
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(2);
            list2.add(3);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("billCode", 2016);
            map.put("proList1", list2);
            List<Bill> list3 = sqlSession.getMapper(ProviderMapper.class).selectByPrimaryKey3(map);
            for (Bill bill : list3) {
                System.out.println(bill.getId() + "\t"
                        + bill.getBillCode() + "\t"
                        + bill.getProvider().getId() + "\t"
                        + bill.getProvider().getProName() + "\t"
                        + bill.getTotalPrice() + "\t"
                        + bill.getIsPayment() + "\t"
                        + bill.getCreationDate());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
