package cn.edu.sysu.test;

import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 3:16 PM
 * 使用Junit单元测试：测试我们的配置
 **/
public class AccountServiceTest {
    @Test
    public void testFindAll() {
//        1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务对象
        IAcountService as=ac.getBean("accountService",IAcountService.class);
//        3.执行方法
        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAcountService as=ac.getBean("accountService",IAcountService.class);
        Account account=as.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("test1");
        account.setMoney(2000f);
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAcountService as=ac.getBean("accountService",IAcountService.class);

        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAcountService as=ac.getBean("accountService",IAcountService.class);

        Account account=as.findAccountById(5);
        account.setMoney(4000f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAcountService as=ac.getBean("accountService",IAcountService.class);
        as.deleteAccount(4);
    }
}
