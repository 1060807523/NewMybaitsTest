package main.java;


import java.util.ArrayList;
import java.util.List;

import main.dao.BillMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import main.pojo.Bill;
import main.Util.MyBatisUtil;
        

public class BillMapperTest {
    private Logger logger = Logger.getLogger(BillMapperTest.class);

    public void setUp() throws Exception {
    }

    public void testGetBillList() {
        SqlSession sqlSession = null;
        List<Bill> billList = new ArrayList<Bill>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Bill bill = new Bill();
            bill.setIsPayment(2);
            bill.setProductName("油");
            bill.setProviderId(7);
            billList = sqlSession.getMapper(BillMapper.class).getBillList(bill);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }

        for(Bill bill: billList){
            logger.debug("testGetBillList id: " + bill.getId() +
                    " and BillCode: " + bill.getBillCode() +
                    " and ProductName: " + bill.getProductName() +
                    " and ProviderName: " + bill.getProviderName() +
                    " and TotalPrice: " + bill.getTotalPrice() +
                    " and IsPayment: " + bill.getIsPayment()+
                    " and CreationDate:" + bill.getCreationDate()+
                    " and 提供商是："+bill.getProvider().toString()
            );
        }
    }


    public void getBillBySomeValue() {
        SqlSession sqlSession = null;
        List<Bill> billList = new ArrayList<Bill>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
           
            billList = sqlSession.getMapper(BillMapper.class).getBillBySomeValue(2);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }

        for(Bill bill: billList){
            logger.debug("testGetBillList id: " + bill.getId() +
                    " and BillCode: " + bill.getBillCode() +
                    " and ProductName: " + bill.getProductName() +
                    " and ProviderName: " + bill.getProviderName() +
                    " and TotalPrice: " + bill.getTotalPrice() +
                    " and IsPayment: " + bill.getIsPayment()+
                    " and CreationDate:" + bill.getCreationDate()+
                    " and 提供商是："+bill.getProvider().toString()
            );
        }
    }
    

}