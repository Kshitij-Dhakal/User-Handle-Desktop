package userHandleDesktop;

import java.sql.*;

public class UserDao {

    public static UserBean login(UserBean bean) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionManager.getConnection();
        String userHandle = bean.getUser_handle();
        String password = bean.getPassword();
        String sql = "SELECT * FROM users WHERE user_handle='" + userHandle + "' AND password=sha2('" + password
                + "',512)";
//		System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            bean.setFirst_name(rs.getString("first_name"));
            bean.setLast_name(rs.getString("last_name"));
            bean.setStatus(STATUS.getStatus(rs.getString("status")));
            bean.setValid(true);
        } else {
            bean.setValid(false);
        }
//		rs.close();
//		st.close();
        con.close();
        return bean;
    }

    public static UserHandleModel login(UserHandleModel model) throws SQLException, ClassNotFoundException {
        UserBean bean = new UserBean();
        bean.setUser_handle(model.getUserHandle());
        bean.setPassword(model.getPassword());
        bean = login(bean);
        return new UserHandleModel(bean.getFirst_name(), bean.getLast_name(), bean.getUser_handle(), bean.getPassword(), bean.isValid());
    }

    public static UserBean register(UserBean bean) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionManager.getConnection();
        String userHandle = bean.getUser_handle();
        String sql = "SELECT * FROM users WHERE user_handle='" + userHandle + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
//			System.out.println("if");
            bean.setValid(false);
        } else {
//			System.out.println("else");
            sql = "INSERT INTO users(user_handle, first_name, last_name, password) VALUES(?,?,?,sha2(?,512))";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bean.getUser_handle());
            pst.setString(2, bean.getFirst_name());
            pst.setString(3, bean.getLast_name());
            pst.setString(4, bean.getPassword());
//			pst.setString(5, "user");
            pst.execute();
            bean.setValid(true);
        }
//		rs.close();
//		st.close();
        con.close();
        return bean;
    }

}
