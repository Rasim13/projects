package repositories;

import models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoriesJdbcImpl implements StudentRepositories {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from students order by id;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from students where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into" +
            "students (first_name, last_name, age, phone, raiting) values (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update students set first_name = ?," +
            "last_name = ?, age = ?, phone = ?, raiting = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from students where id = ?";

    //language=SQL
    private static final String SQL_ORDER_BY_ID = "select * from students order by id";

    //language=SQL
    private static final String SQL_ORDER_BY_RAITING = "select * from students order by raiting DESC";

    //language=SQL
    private static final String SQL_ORDER_BY_AGE = "select * from students order by age";


    private Connection connection;

    public StudentRepositoriesJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public StudentRepositoriesJdbcImpl() {

    }

    @Override
    public List<Student> findAll() {
            Statement statement = null;
            ResultSet rows = null;
            try {
                List<Student> students = new ArrayList<>();
                statement = connection.createStatement();
                rows = statement.executeQuery(SQL_SELECT_ALL);
                while (rows.next()) {
                    Student student = new Student(
                            rows.getInt("id"),
                            rows.getString("first_name"),
                            rows.getString("last_Name"),
                            rows.getInt("age"),
                            rows.getString("phone"),
                            rows.getInt("raiting")
                    );
                    students.add(student);
                }
                return students;

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
        public Student findById (Integer id) {
            PreparedStatement statement = null;
            ResultSet rows = null;
            try {
                statement = connection.prepareStatement(SQL_SELECT_BY_ID);
                statement.setInt(1, id);
                rows = statement.executeQuery();
                if (rows.next()) {
                    return new Student(
                            rows.getInt("id"),
                            rows.getString("first_name"),
                            rows.getString("last_Name"),
                            rows.getInt("age"),
                            rows.getString("phone"),
                            rows.getInt("raiting")
                    );

                } else {
                    return null;
                }

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
        public void save (Student student) {
            PreparedStatement statement = null;
            ResultSet generatedKeys = null;
            try {
                statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setInt(3, student.getAge());
                statement.setString(4, student.getPhone());
                statement.setInt(5, student.getRaiting());

                int affectedRows = statement.executeUpdate();

                if (affectedRows != 1) {
                    throw new SQLException("Can't insert");
                }
                // получаем сгенериррованные ключи
                generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    student.setId(generatedKeys.getInt("id"));
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
            }
        }

        @Override
        public void update (Student student){
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(SQL_UPDATE);
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setInt(3, student.getAge());
                statement.setString(4, student.getPhone());
                statement.setInt(5, student.getRaiting());

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
        public void deleteById (Integer id){
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(SQL_DELETE_BY_ID);
                statement.setInt(1, id);
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
        public void sortById () {
            Statement statement = null;
            ResultSet rs = null;
            try {
                statement = connection.createStatement();
                rs = statement.executeQuery(SQL_ORDER_BY_ID);
                while (rs.next()) {
                    show(rs);
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

    private void show(ResultSet rs) {
        try {
            System.out.printf("%3d|%10s|%10s|%5d|%13s|%4d\n", rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6));
        } catch (SQLException e) {
            throw new IllegalStateException("Couldn't show");
        }
    }

    @Override
    public void sortByRaiting() {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL_ORDER_BY_RAITING);
            while (rs.next()) {
                show(rs);
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
    public void sortByAge() {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL_ORDER_BY_AGE);
            while (rs.next()) {
                show(rs);
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


