package cn.edu.sysu.test;

import cn.edu.sysu.config.JdbcConfig;
import cn.edu.sysu.config.SpringConfiguration;
import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author gyao
 * @create date 2019-05-30 3:16 PM
 * 使用Junit单元测试：测试我们的配置
 **/
/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAcountService as=null;

    @Test
    public void testFindAll() {
//        1.获取容器
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        Account account=as.findAccountById(5);
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
        Account account=as.findAccountById(5);
        account.setMoney(4000f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(2);
    }
}
