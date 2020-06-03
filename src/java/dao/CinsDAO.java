/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cins;
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
            Statement st = connect().createStatement();
            st.executeUpdate("insert into cins (cins_ad) values ('" + c.getCinsad()+ "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Cins> read() {
        List<Cins> list = new ArrayList<>();
        try {
            Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("select * from cins order by cins_id asc");
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
            Statement st = connect().createStatement();
            st.executeUpdate("update cins set cins_ad='" + c.getCinsad()+  "' where cins_id=" + c.getCinsID());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Cins c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("delete from cins where cins_id=" + c.getCinsID());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    
}
