package cn.edu.sysu.service.impl;

import cn.edu.sysu.dao.IAccountDao;
import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import cn.edu.sysu.utils.TransactionManager;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-06-07 10:24 PM
 **/

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl_OLD implements IAcountService {
    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            txManager.beginTransaction1();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            txManager.beginTransaction();
            Account account=accountDao.findAccountById(accountId);
            txManager.commit();
            return account;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            txManager.beginTransaction();
            accountDao.saveAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            txManager.beginTransaction();
            accountDao.updateAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            txManager.beginTransaction();
            accountDao.deleteAccount(accountId);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            e.printStackTrace();
            System.out.println("transfer over");
        }finally {
            //5.释放连接
            txManager.release();
        }
    }
}
