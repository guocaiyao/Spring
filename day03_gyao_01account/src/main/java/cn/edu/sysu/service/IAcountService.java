package cn.edu.sysu.service;

import cn.edu.sysu.domain.Account;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 1:12 PM
 * 账户的业务层接口
 * 事务控制应该都是在业务层
 **/
public interface IAcountService {
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
    /**
     * 转账
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
