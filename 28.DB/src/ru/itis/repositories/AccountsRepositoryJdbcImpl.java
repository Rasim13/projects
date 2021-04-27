package ru.itis.repositories;

import ru.itis.models.Account;

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

    private Connection connection;

    public AccountsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Account> accountRowMapper = row -> new Account(
            row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getBoolean("is_active"));

    @Override
    public List<Account> findAll() {
        Statement statement = null;
        ResultSet rows = null;
        try {

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
        }
    }

    @Override
    public Account findById(Long id) {
        PreparedStatement statement = null;
        ResultSet rows = null;
        try {
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
        }
    }

    @Override
    public void save(Account account) {
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getActive());

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
        }
    }

    @Override
    public void update(Account account) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setBoolean(3, account.getActive());
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
        }

    }

    @Override
    public void delete(Account account) {
        PreparedStatement statement = null;
        try {
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
        }
    }


    @Override
    public void deleteById(Long id) {
        PreparedStatement statement = null;
        try {
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
        }
    }

    @Override
    public void sortById() {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL_ORDER_BY_ID);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" +
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
        }
    }
}
