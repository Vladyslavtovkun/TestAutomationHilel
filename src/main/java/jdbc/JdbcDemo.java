package jdbc;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/world";
        Connection conn = DriverManager.getConnection(url, "root", "admin");

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select city.name As names, country.continent\n" +
                        "from city\n" +
                        "join country\n" +
                        "on city.countrycode = country.code;");

        System.out.println("Insertion successful");

        while (resultSet.next()) {
            String name = resultSet.getString("names");
            String continents = resultSet.getString("continent");
            System.out.println("Name: " +name+ " Continents: " + continents);
        }
    }
}
