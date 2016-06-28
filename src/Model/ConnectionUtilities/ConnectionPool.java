package Model.ConnectionUtilities;

/**
 * Created by Alejandro on 6/18/2016.
 */

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//This is a utility class that will be used to create a connection pool that will provide
//several connections for the other classes in the program that will require a connection.

public class ConnectionPool {
    //All pertinent member variables.

    private String url = "jdbc:mysql://localhost:3306/javabase?&useSSL=false";
    private String username = "java";
    private String password = "Gohanssj2";
    private DataSource mDataSource = null;
    //these are the classes from the apache library.
    //the driver adapter makes a connection pool by adapting the driver from the jdbc
    private DriverAdapterCPDS mDriverAdapterCPDS = new DriverAdapterCPDS();
    private SharedPoolDataSource mSharedPoolDataSource = new SharedPoolDataSource();

    public ConnectionPool(){}

    //method for setting up the driver that will be the data source. it needs to be fed the url for the jdbc driver so that
    //it can adapt it
    public void setDriverAdapter(){
        try{
            mDriverAdapterCPDS.setDriver("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //set the fields for the adapter to set up the data source
        mDriverAdapterCPDS.setUrl(url);mDriverAdapterCPDS.setUser(username);mDriverAdapterCPDS.setPassword(password);
    }

    //this is kind of unnecessary, but I don't really like referencing members directly.
    public DriverAdapterCPDS getDriverAdapterCPDS(){
        return mDriverAdapterCPDS;
    }
    public void setDataSource(){
        //before setting up the data source that will contain the shared connection pool, the driver must be set up
        setDriverAdapter();
        //set up the shared data source that will contain the shared connection pool
        mSharedPoolDataSource.setConnectionPoolDataSource(getDriverAdapterCPDS());
        //only 10 connections in the pool, to not use too much memory
        mSharedPoolDataSource.setMaxTotal(10);
        mSharedPoolDataSource.setDefaultMaxWaitMillis(50);
        //the data source now has access to the shared connection pool from the non-null data source
        mDataSource = mSharedPoolDataSource;
    }
    //this method gets a connection from the connection pool that was set up in the data source from
    //the original shared data source
    public Connection getConnection() throws SQLException {
        //if the data source doesn't have any connections from the pool then it needs to be set up
        if(mDataSource == null){
            setDataSource();
        }
        //this will return a single connection from the shared connection pool.
        return mDataSource.getConnection();
    }

}
