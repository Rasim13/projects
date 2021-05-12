package ru.itis.site.repositories;

import ru.itis.site.models.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepositoryJdbcImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into" +
            " account(first_name, last_name, is_active) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?," +
            "last_name = ?, is_active = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from account where id = ?";

    //language=SQL
    private static final String SQL_DELETE_ACCOUNT = "delete from account where first_name = ?";

    //language=SQL
    private static final String SQL_ORDER_BY_ID = "select * from account order by id ASC";

    private DataSource dataSource;

    public AccountsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private RowMapper<Account> accountRowMapper = row -> new Account(
            row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getBoolean("is_active"));

    @Override
    public List<Account> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rows = null;
        try {
            connection = dataSource.getConnection();
            List<Account> accounts = new ArrayList<>();

            statement = connection.createStatement();
            rows = statement.executeQuery(SQL_SELECT_ALL);

            while(rows.next()) {
                Account account = accountRowMapper.mapRow(rows);
                accounts.add(account);
            }
            return accounts;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (rows != null) {
                try {
                    rows.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public Account findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rows = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            rows = statement.executeQuery();
            if (rows.next()) {
                return accountRowMapper.mapRow(rows);
            }
            return null;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (rows != null) {
                try {
                    rows.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void save(Account account) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getIsActive());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't insert");
            }
            // получаем сгенериррованные ключи
             generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                account.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("Can't retrieve id");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void update(Account account) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getIsActive());
            statement.setLong(4, account.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't update");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }

    }

    @Override
    public void delete(Account account) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ACCOUNT);
            statement.setString(1, account.getFirstName());
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new SQLException("Couldn't delete");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }


    @Override
    public void deleteById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_ID);
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new SQLException("Couldn't delete");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void sortById() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL_ORDER_BY_ID);
            while (rs.next()) {
                System.out.println(rs.getLong(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getString(3));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }
}
