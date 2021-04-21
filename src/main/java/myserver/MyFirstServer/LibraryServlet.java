package myserver.MyFirstServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

@WebServlet(name = "Library", value = "/library")
public class LibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/java_ee_db?useUnicode=true&serverTimezone=UTC",
                    "root",
                    "8976yd46");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books;");
            pw.println("Books");
            while (rs.next()){
                pw.print(rs.getString("title"));
                pw.print("  ");
                pw.print(rs.getString("author"));
                pw.print("  ");
                pw.println(rs.getString("quantity"));
            }
            //String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
            //String sqlCommand = "Insert into books(title, author, quantity) values('My Fun', 'Roman', 7)";
            String sqlCommand = "INSERT INTO Products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                    "('Galaxy S9', 45000), ('Nokia 9', 36000)";
            stmt.executeUpdate(sqlCommand);
            stmt.close();
        } catch (SQLException throwables) {
            pw.println(throwables.toString() + " X3");
            //throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
    public static Connection getConnection() throws SQLException, IOException{
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}