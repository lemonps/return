
package newreturnpro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class subject {
    private int id;
    private String name;
    private String course_id;

    public subject() {
    }

    public subject(int id, String name, String course_id) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
    }
    
    public static subject findBySubId(int subId) {
        subject sub = null;
        try {
            Connection con = ConnectionBuilder.getConnection();  // Load driver + Connect 
            String sql = "select * from subject where id = " + subId;
            Statement st = con.createStatement();  // make Query
            ResultSet rs = st.executeQuery(sql);  // execute
            if (rs.next()) {
                sub = new subject();
                sub.setId(rs.getInt("id"));
                sub.setName(rs.getString("name"));
                sub.setCourse_id(rs.getString("course_id"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sub;
    }

    public static List<subject> findBySubName(String sname) {
        List<subject> subject = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select * from subject where name like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + sname + "%");
            // Statement st = con.createStatement();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                subject sub = new subject();
                sub.setId(rs.getInt("id"));
                sub.setName(rs.getString("name"));
                sub.setCourse_id(rs.getString("course_id"));
                if (subject == null) {
                    subject = new ArrayList<>();
                }
                subject.add(sub);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public static void main(String[] args) {
       List<subject> sub = findBySubName("calculus");
      for(subject s : sub){
           System.out.println(s.getName());
       }
       subject sub2 = subject.findBySubId(1);
        System.out.println(sub2.getName());
    }
}
