package main.java;

import main.Util.MyBatisUtil;
import main.dao.BillMapper;
import main.dao.ProviderMapper;
import main.pojo.Bill;
import main.pojo.Provider;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ProviderMapperTest {
    private Logger logger = Logger.getLogger(BillMapperTest.class);
    public void setUp() throws Exception {
    }

    public void testGetAdd() {
        SqlSession sqlSession = null;
        List<Bill> billList = new ArrayList<Bill>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Provider provider = new Provider();
            provider.setProCode("Bbbbb");
            provider.setProName("山东建筑大学");
            provider.setProDesc("长期合作伙伴，主营产品:饮料、水饮料、植物蛋白饮料、休闲食品、果汁饮料、功能饮料等");
            sqlSession.getMapper(ProviderMapper.class).add(provider);
            logger.debug("自增主键"+provider.getId());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    
    public void testGetUpdate(){
        SqlSession sqlSession = null;
        List<Bill> billList = new ArrayList<Bill>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Provider provider = new Provider();
            provider.setId(9);
            provider.setProName("新增山东建筑大学");
            sqlSession.getMapper(ProviderMapper.class).modify(provider);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    
    public void deleteProviderById(){
        SqlSession sqlSession = null;
        List<Bill> billList = new ArrayList<Bill>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            sqlSession.getMapper(ProviderMapper.class).deleteProviderById(9);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        
    }

    public void getProviderById(){
        SqlSession sqlSession = null;
        List<Provider> billList = new ArrayList<Provider>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Provider p = new Provider();
            p.setId(3);
            billList =sqlSession.getMapper(ProviderMapper.class).getProviders(p);
            logger.debug(billList.size());
            for (Provider pitem:billList) {
                logger.debug(pitem.toString()+"\n"+
                       "该供货商有"+ pitem.getBillList().size() +"条单子" 
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }

    }
}
