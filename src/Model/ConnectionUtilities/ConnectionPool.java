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
    private Connection mConnection;
    private DataSource mDataSource;
    private DriverAdapterCPDS mDriverAdapterCPDS = new DriverAdapterCPDS();
    private SharedPoolDataSource mSharedPoolDataSource = new SharedPoolDataSource();

    public ConnectionPool(){}

    public void setDriverAdapter(){

    }


}
