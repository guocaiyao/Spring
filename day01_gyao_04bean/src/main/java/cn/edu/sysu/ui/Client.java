package cn.edu.sysu.ui;

import cn.edu.sysu.service.IAccountService;
import cn.edu.sysu.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gyao
 * @create date 2019-05-28 10:17 AM
 * 模拟一个表现层，用于调用业务层
 **/
public class Client {
    /**
     ** @param args
     */
    public static void main(String [] args){
        //1.获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取Bean对象
        IAccountService as1= (IAccountService) ac.getBean("accountService");
//        IAccountService as2= (IAccountService) ac.getBean("accountService");
        System.out.println(as1);
//        System.out.println(as2);
//        System.out.println(as1==as2);
        as1.saveAccount();
//        as2.saveAccount();
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
