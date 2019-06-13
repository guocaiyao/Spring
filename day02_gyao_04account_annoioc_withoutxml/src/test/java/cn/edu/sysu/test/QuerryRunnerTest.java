package cn.edu.sysu.test;

import cn.edu.sysu.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gyao
 * @create date 2019-05-30 6:20 PM
 * 测试queryrunner是否单例
 **/
public class QuerryRunnerTest {
    @Test
    public void testQueryRunner() {
        //1.获取容器
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner runner=ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1=ac.getBean("runner",QueryRunner.class);
        System.out.println(runner==runner1);
    }
}
