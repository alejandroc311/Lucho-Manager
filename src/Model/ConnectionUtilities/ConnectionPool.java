package Model.ConnectionUtilities;

/**
 * Created by Alejandro on 6/18/2016.
 */

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private String url = "jdbc:mysql://localhost:3306/javabase?&useSSL=false";
    private String username = "java";
    private String password = "Gohanssj2";
    private DataSource mDataSource = null;
    private DriverAdapterCPDS mDriverAdapterCPDS = new DriverAdapterCPDS();
    private SharedPoolDataSource mSharedPoolDataSource = new SharedPoolDataSource();

    public ConnectionPool(){}

    public void setDriverAdapter(){
        try{
            mDriverAdapterCPDS.setDriver("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        mDriverAdapterCPDS.setUrl(url);mDriverAdapterCPDS.setUser(username);mDriverAdapterCPDS.setPassword(password);
    }

    public DriverAdapterCPDS getDriverAdapterCPDS(){
        return mDriverAdapterCPDS;
    }
    public void setDataSource(){
        setDriverAdapter();
        mSharedPoolDataSource.setConnectionPoolDataSource(getDriverAdapterCPDS());
        mSharedPoolDataSource.setMaxTotal(10);
        mSharedPoolDataSource.setDefaultMaxWaitMillis(50);
        mDataSource = mSharedPoolDataSource;
    }
    public Connection getConnection() throws SQLException {
        if(mDataSource == null){
            setDataSource();
        }
        return mDataSource.getConnection();
    }

}
