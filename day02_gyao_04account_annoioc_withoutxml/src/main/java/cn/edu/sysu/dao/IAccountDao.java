package cn.edu.sysu.dao;

import cn.edu.sysu.domain.Account;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 1:34 PM
 * 账户的持久层接口
 **/
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();
    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);
    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);
    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
