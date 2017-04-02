package return_allclass;

import java.sql.*;

public class admin {

    private String username;
    private String password;
    private int id;

    public admin() {
    }

    public static void EditSubjectById(int id, String name, String co_id) throws SQLException, ClassNotFoundException, NullPointerException {
        Connection con = ConnectionBuilder.getConnection();
        Statement st = con.createStatement();
        String sql = "update subject set name=?,course_id=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, co_id);
            ps.setInt(3, id);
        int rs = ps.executeUpdate();
            System.out.println(rs + " updated !!");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        admin.EditSubjectById(1, "a", "b");
    }

}
