/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cins;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author Acer
 */
public class CinsDAO extends DBConnect{
    public Cins getById(int id){
        Cins l=null;
        try{
            
            Statement st=this.connect().createStatement();
            ResultSet rs=st.executeQuery("select * from cins where cins_id="+id);
            rs.next();
            l=new Cins(rs.getInt("cins_id"), rs.getString("cins_ad"));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
    public void create(Cins c) {
        try {
            PreparedStatement pst=this.connect().prepareStatement("insert into cins (cins_ad) values (?)");
            pst.setString(1,c.getCinsad());
            pst.executeUpdate();
            /*Statement st = connect().createStatement();
            st.executeUpdate("insert into cins (cins_ad) values ('" + c.getCinsad()+ "')");*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Cins> read() {
        List<Cins> list = new ArrayList<>();
        try {
            PreparedStatement pst=this.connect().prepareStatement("select * from cins order by cins_id asc");
            /*Statement st = connect().createStatement();*/
            ResultSet rs =pst.executeQuery();  /*st.executeQuery("select * from cins order by cins_id asc");*/
            while (rs.next()) {
                Cins tmp = new Cins(rs.getInt("cins_id"), rs.getString("cins_ad"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Cins c) {
        try {
            PreparedStatement pst=this.connect().prepareStatement("update cins set cins_ad=? where cins_id=?");
            pst.setString(1, c.getCinsad());
            pst.setInt(2, c.getCinsID());
            pst.executeUpdate();
            /*Statement st = connect().createStatement();
            st.executeUpdate("update cins set cins_ad='" + c.getCinsad()+  "' where cins_id=" + c.getCinsID());*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Cins c) {
        try {
             PreparedStatement pst=this.connect().prepareStatement("delete from cins where cins_id=?");
             pst.setInt(1, c.getCinsID());
             pst.executeUpdate();
           /* Statement st = connect().createStatement();
            st.executeUpdate("delete from cins where cins_id=" + c.getCinsID());*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    
}
