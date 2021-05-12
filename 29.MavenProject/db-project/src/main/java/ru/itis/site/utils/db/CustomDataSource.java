package ru.itis.site.utils.db;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class CustomDataSource implements DataSource {
    private String user;
    private String password;
    private String url;

    public CustomDataSource(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
           this.connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new IllegalStateException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new IllegalStateException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new IllegalStateException();
    }
}
