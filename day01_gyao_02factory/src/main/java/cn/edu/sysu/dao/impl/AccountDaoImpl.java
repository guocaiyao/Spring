package cn.edu.sysu.dao.impl;

import cn.edu.sysu.dao.IAccountDao;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author gyao
 * @create date 2019-05-28 10:13 AM
 * 账户的持久层实现类
 **/
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
