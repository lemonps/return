package newreturnpro;

import java.sql.*;

public class admin {

    private String username;
    private String password;
    private int id;

    public static void insertSubject(subject[] s) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();
        int insertRound = 0;
        PreparedStatement ps = con.prepareStatement("insert into subject values(?,?,?)");
        for (int i = 0; i < s.length; i++) {
            ps.setInt(1, s[i].getId());
            ps.setString(2, s[i].getName());
            ps.setString(3, s[i].getCourse_id());
            insertRound += ps.executeUpdate();
        }
        System.out.println(insertRound + " recs inserted");
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

    public static void main(String[] args) throws SQLException {
        subject mySub[] = {new subject(3, "Mth101", "Calculus"),
            new subject(4, "Int105", "ComPro")};
        admin.insertSubject(mySub);
    }
}
