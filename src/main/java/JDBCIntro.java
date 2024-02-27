//import java.math.BigDecimal;
//import java.sql.*;
//
//public class JDBCIntro {
//    //load the jdbc driver
//    //1- Establish the connection
//    // 2- Create a Statement.
//    public static void main(String[] args) throws ClassNotFoundException {
//        // 1- db Url - "jdbc://localhost:3306/posDb"
//
//        String url = "jdbc:mysql://localhost:3306/cvsdb";
//        String username = "root";
//        String password = "arman2015";
//        Connection  dbConnection = null;
//        try {
//
//          dbConnection = DriverManager.getConnection(url,username,password);
//              Statement statement  = dbConnection.createStatement();
//
//    //      String sql = "INSERT INTO employees (name,age) VALUES('John Cena',30 )";
//
////            int num =  statement.executeUpdate(sql);
////
////            System.out.println("Affect number of rows "+num);
//
//// SQL injection
//            String query = "SELECT * FROM employees ";
//
//            ResultSet resultSet = statement.executeQuery(query);
//           while (resultSet.next()) {
//              int id =    resultSet.getInt("id");
//              String name = resultSet.getNString("name");
//              int age = resultSet.getInt("age");
//               System.out.println("ID: "+id +" Name "+name +" Age "+age);
//
//
//
//           } // try with resource
//            resultSet.close();
//            statement.close();
//            dbConnection.close();
//
//
//
//
//            System.out.println("Connecting to database successfully ");
//        } catch (SQLException e) {
//            System.out.println("Failed to connect "+e.getMessage());
//        }
//
//
//
//    }
//}
