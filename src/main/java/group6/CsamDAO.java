package group6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CsamDAO {
    public CsamDAO() {
        // TODO Auto-generated constructor stub
    }
    public static Connection getConnection(){
        Connection connection=null;
        try {
            // Registering the MySQL Driver with Class.forName() is required to work with
            // Tomcat Server
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/test",
                    "test_user",
                    "secret");
        } catch (SQLException ex) {
            System.out.println("Failed to create a connection to database.\n" + ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static int save(Csam e){
        int status=0;
        try{
            Connection con = getConnection();
            System.out.println("after connection done");
            PreparedStatement ps=con.prepareStatement(
                    "insert into lambton(sid,sname,gpa,grade) values (?,?,?,?)");
            System.out.println("after insert statement");
            ps.setString(1,e.getSid());
            ps.setString(2,e.getSName());
            ps.setDouble(3,e.getGpa());
            ps.setString(4,e.getGrade());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }
    public static Csam getStudentById(String id){
        Csam e=new Csam ();
        try{
            Connection con= getConnection();
            PreparedStatement ps=con.prepareStatement("select * from lambton where sid=?");
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setSName(rs.getString(2));
                e.setGpa(Double.parseDouble(rs.getString(3)));
                e.setGrade(rs.getString(4));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return e;
    }
    public static int update(Csam p){
        int status=0;
        try{
            Connection con = getConnection();
            String sql="update lambton set sname='"+p.getSName()+"',gpa="+p.getGpa()+",grade='"+p.getGrade()+"' where sid='"+p.getSid()+"'";
            System.out.println(sql);
            PreparedStatement ps=con.prepareStatement(sql);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();
        }
        return 0;
    }
    public static int delete(String sid){
        int status=0;
        try{
            Connection con=getConnection();
            String sql="delete from lambton where sid='"+sid+"'";
            System.out.println(sql);
            PreparedStatement ps=con.prepareStatement(sql);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return status;
    }
    /* public Emp getEmpById(int id){
    String sql="select * from Emp99 where id=?";
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
    } */
    public static List<Csam> getAllStudents(){
        List<Csam> list=new ArrayList<Csam>();
        try{
            Connection con=getConnection();
            System.out.println("Inside get all students");
            PreparedStatement ps=con.prepareStatement("select * from lambton");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Csam e=new Csam();
                e.setSid(rs.getString(1));
                e.setSName(rs.getString(2));
                e.setGrade(rs.getString(4));
                e.setGpa(Double.parseDouble(rs.getString(3)));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();
        }
        return list;
    }
}
