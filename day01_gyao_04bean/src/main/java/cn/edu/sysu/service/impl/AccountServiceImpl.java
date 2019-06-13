package cn.edu.sysu.service.impl;

import cn.edu.sysu.service.IAccountService;

/**
 * @author gyao
 * @create date 2019-05-28 10:07 AM
 * 账户的业务层实现类
 **/
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("Object is created! ");
    }
    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。");
    }
    public void init(){
        System.out.println("对象初始化了。。。");
    }
    public void destroy(){
        System.out.println("对象销毁了。。。");
    }
}
