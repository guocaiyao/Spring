package cn.edu.sysu.ui;

import cn.edu.sysu.factory.BeanFactory;
import cn.edu.sysu.service.IAccountService;
import cn.edu.sysu.service.impl.AccountServiceImpl;

/**
 * @author gyao
 * @create date 2019-05-28 10:17 AM
 * 模拟一个表现层，用于调用业务层
 **/
public class Client {
    public static void main(String [] args){
//        IAccountService as=new AccountServiceImpl();
        for (int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
