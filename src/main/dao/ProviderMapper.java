package main.dao;

import main.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    
    public int  add(Provider provider);
    
    public int modify(Provider provider);
    
    public int deleteProviderById(@Param("id")Integer delId);
    
    public List<Provider> getProviders(Provider p);
    
    public Provider getProvidersById(Integer id);
}
