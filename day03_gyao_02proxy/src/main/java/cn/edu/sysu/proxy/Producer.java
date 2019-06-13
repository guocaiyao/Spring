package cn.edu.sysu.proxy;

/**
 * @author gyao
 * @create date 2019-06-07 11:22 PM
 **/
/**
 * 一个生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }
    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
