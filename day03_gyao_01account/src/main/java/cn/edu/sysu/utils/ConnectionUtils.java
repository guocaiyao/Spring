package cn.edu.sysu.utils;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.Connection;

/**
 * @author gyao
 * @create date 2019-05-31 8:54 PM
 *  连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 **/
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        /**
         * 获取当前线程上的连接
         * @return
         */

        try {
            //1.先从ThreadLocal上获取
            Connection conn=tl.get();
            //2.判断当前线程上是否有连接
            if(conn==null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
