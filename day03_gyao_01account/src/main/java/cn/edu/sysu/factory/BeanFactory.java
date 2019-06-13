package cn.edu.sysu.factory;

/**
 * @author gyao
 * @create date 2019-06-08 12:07 PM
 **/

import cn.edu.sysu.domain.Account;
import cn.edu.sysu.service.IAcountService;
import cn.edu.sysu.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private IAcountService accountservice;
    private TransactionManager txManager;

    public final void setAccountservice(IAcountService accountservice) {
        this.accountservice = accountservice;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAcountService getAccountservice() {
        return (IAcountService)Proxy.newProxyInstance(accountservice.getClass().getClassLoader(),
                accountservice.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test".equals(method.getName())) {
                            return method.invoke(accountservice, args);
                        }
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction1();
                            //2.执行操作
                            rtValue = method.invoke(accountservice, args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
