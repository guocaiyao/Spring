package cn.edu.sysu.ui;

import cn.edu.sysu.dao.IAccountDao;
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
    * @param args
     */
    public static void main(String [] args){
        //1.获取核心容器对象
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as= (IAccountService) ac.getBean("accountService");
        IAccountService as2= (IAccountService) ac.getBean("accountService");
//        IAccountDao adao= ac.getBean("accountDao2",IAccountDao.class);

        System.out.println(as);
//        System.out.println(adao);
        System.out.println(as==as2);
        as.saveAccount();
        ac.close();
    }
}
