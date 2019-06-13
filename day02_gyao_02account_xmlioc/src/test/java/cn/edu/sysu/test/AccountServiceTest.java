package cn.edu.sysu.test;

import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 3:16 PM
 * 使用Junit单元测试：测试我们的配置
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAcountService as=null;
    @Test
    public void testFindAll() {
//        1.获取容器
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务对象
//        IAcountService as=ac.getBean("accountService",IAcountService.class);
//        3.执行方法
        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        Account account=as.findAccountById(31);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("test1");
        account.setMoney(2000f);

        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account=as.findAccountById(31);
        account.setMoney(4000f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}
