package cn.edu.sysu.factory;

import cn.edu.sysu.service.IAccountService;
import cn.edu.sysu.service.impl.AccountServiceImpl;

/**
 * @author gyao
 * @create date 2019-05-28 8:23 PM
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 **/
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
