package com.sh3kel.drugshop.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String DB_MAX_POOL_SIZE_KEY = "db.max.pool.size";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(PropertiesUtil.get(URL_KEY));
        config.setUsername(PropertiesUtil.get(USERNAME_KEY));
        config.setPassword(PropertiesUtil.get(PASSWORD_KEY));
        config.setMaximumPoolSize(Integer.valueOf(PropertiesUtil.get(DB_MAX_POOL_SIZE_KEY)));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    private ConnectionManager() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
