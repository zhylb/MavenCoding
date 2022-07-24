import com.lihd.imperial.court.dao.BaseDAO;
import com.lihd.imperial.court.entity.Emp;
import com.lihd.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/22 22:40
 */
public class MyTest {


    private BaseDAO<Emp> dao = new BaseDAO<>();


    @Test
    public void testUpdate() {
        String sql = "update  t_emp set emp_name = ? where emp_id = ?";
        int update = dao.update(sql,"唐太宗",1);
        System.out.println("update = " + update );
    }

    @Test
    public void testGetBeanList() {
        String sql = "select emp_id empId, emp_name empName, emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp";
        List<Emp> beanList = dao.getBeanList(sql, Emp.class);
        beanList.forEach(System.out::println);
    }

    @Test
    public void testGetBean(){
        String sql = "select emp_id empId, emp_name empName, emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp where emp_id = ?";
        Emp bean = dao.getBean(sql, Emp.class, 1);
        System.out.println(bean);
    }





    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);
        JDBCUtils.closeConnection(connection);
    }
}
