package cn.edu.sysu.dao.impl;

import cn.edu.sysu.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author gyao
 * @create date 2019-05-28 10:13 AM
 * 账户的持久层实现类
 **/
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户2222222222");
    }
}
