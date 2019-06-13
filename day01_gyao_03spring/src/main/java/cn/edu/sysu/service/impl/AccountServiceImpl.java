package cn.edu.sysu.service.impl;

import cn.edu.sysu.dao.IAccountDao;
import cn.edu.sysu.dao.impl.AccountDaoImpl;
import cn.edu.sysu.service.IAccountService;

/**
 * @author gyao
 * @create date 2019-05-28 10:07 AM
 * 账户的业务层实现类
 **/
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao=new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("Object is created! ");
    }
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
