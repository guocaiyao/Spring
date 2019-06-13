package cn.edu.sysu.test;

import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("proxyAccountService")
    private IAcountService as;

    @Test
    public void testTransfer() {
        as.transfer("ccc","aaa",300f);
    }
}
