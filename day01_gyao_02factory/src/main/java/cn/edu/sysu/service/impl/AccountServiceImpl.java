package cn.edu.sysu.service.impl;

import cn.edu.sysu.dao.IAccountDao;
import cn.edu.sysu.dao.impl.AccountDaoImpl;
import cn.edu.sysu.factory.BeanFactory;
import cn.edu.sysu.service.IAccountService;

/**
 * @author gyao
 * @create date 2019-05-28 10:07 AM
 * 账户的业务层实现类
 **/
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao=new AccountDaoImpl();
    private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");
//    private int i=1;
    public void saveAccount(){
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
