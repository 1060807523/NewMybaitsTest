package main.dao;

import main.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    
    
    public List<Bill> getBillList(Bill bill);

    public List<Bill> getBill(Integer id);
    
    public List<Bill> getBillBySomeValue(
           @Param("id1") Integer id1
    );
}
