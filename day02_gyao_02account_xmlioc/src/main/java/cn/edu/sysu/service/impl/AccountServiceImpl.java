package cn.edu.sysu.service.impl;

import cn.edu.sysu.dao.IAccountDao;
import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 1:29 PM
 * 账户的业务层实现类,业务层调用持久层
 **/
public class AccountServiceImpl implements IAcountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
