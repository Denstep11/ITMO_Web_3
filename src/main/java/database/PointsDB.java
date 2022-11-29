package database;


import java.sql.*;

public class PointsDB {
    Connection conn;
        public PointsDB(){

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/points", "postgres", "DenDenvv");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM pointsValue");
                while (rs.next()){
                    Point point = new Point();
                    point.setX(rs.getFloat(1));
                    point.setY(rs.getFloat(2));
                    point.setR(rs.getFloat(3));
                    point.setTime(rs.getString(4));
                    point.setLong_time(rs.getLong(5));
                    point.setResult(rs.getBoolean(6));
                    CollectionBD.collection.add(point);
                }
                System.out.println(CollectionBD.collection.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void UpdateBD(Point p){
            PreparedStatement ps;
            try {
                ps = conn.prepareStatement("INSERT INTO PointsValue VALUES (?,?,?,?,?,?)");
                ps.setFloat(1, p.getX());
                ps.setFloat(2, p.getY());
                ps.setFloat(3, p.getR());
                ps.setString(4, p.getTime() );
                ps.setString(5, String.valueOf(p.getLong_time()));
                ps.setBoolean(6, p.isResult());
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
}

