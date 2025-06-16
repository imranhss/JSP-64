/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emp;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class EmpDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static int saveEmp(Emp e) {
        int status = 0;
        sql = "insert into emp(name, salary) values(?,?)";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setFloat(2, e.getSalary());

            status = ps.executeUpdate();

            ps.close();
            DbUtil.getCon().close();
            
            System.out.println("------------------------");

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

    public static List<Emp> getAllEmp() {
        List<Emp> emps = new ArrayList<>();
        sql = "select * from emp";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Emp e = new Emp(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("salary")
                );

                emps.add(e);

            }

            rs.close();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return emps;
    }

   public static void deleteEmp(int id) {
        sql = "delete from emp where id= ?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
   
   public static Emp getById(int id) {
        Emp e = null;
        sql = "select * from emp where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
               e = new Emp(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("salary")
                        
                );
            }

            rs.close();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
   
   
   public static int updateEmp(Emp s) {
        int status = 0;
        sql = "update emp set name= ?, salary= ? where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());           
            ps.setFloat(2, s.getSalary());          
            ps.setInt(3, s.getId());

            status = ps.executeUpdate();

            System.out.println(status);

            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
   
    
    
}
