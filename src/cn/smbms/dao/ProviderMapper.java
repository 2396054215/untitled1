package cn.smbms.dao;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProviderMapper {
    List<Provider> selectProviderList(@Param("proCode") String proCode,
                                      @Param("proName") String proName);
    int updatePrvoder(Provider provider);
    List<Bill> selectByPrimaryKey2(List<Integer> providerList);
    List<Bill> selectByPrimaryKey3(Map<String, Object> map);

}
