/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cins;
import entity.Mama;
import entity.Musteri;
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
public class MamaDAO extends DBConnect{
    
    
    
    public void create(Mama c) {
        try {
            PreparedStatement pst=this.connect().prepareStatement("insert into mama (mama_adi) values (?)");
            pst.setString(1, c.getMamaad());
            pst.executeUpdate();
          /*  Statement st = connect().createStatement();
            st.executeUpdate("insert into mama (mama_adi) values ('" + c.getMamaad()+ "')");*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Mama> read() {
        List<Mama> list = new ArrayList<>();
        try {
             PreparedStatement pst=this.connect().prepareStatement("select * from mama order by mama_id asc");
              ResultSet rs =pst.executeQuery(); 
            /*Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("select * from mama order by mama_id asc");*/
            while (rs.next()) {
              
                Mama tmp = new Mama(rs.getInt("mama_id"), rs.getString("mama_adi"));
                list.add(tmp);
            }
            pst.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Mama c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("update mama set mama_adi='"+ c.getMamaad() +"' where mama_id="+ c.getMamaID());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }

    public void delete(Mama c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("delete from mama where mama_id=" + c.getMamaID());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  Mama getById(int id){
        Mama m=null;
        try{
            
            Statement st=this.connect().createStatement();
            ResultSet rs=st.executeQuery("select * from mama where mama_id="+id);
            rs.next();
           
            m=new Mama(rs.getInt("mama_id"),rs.getString("mama_adi"));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return m;
    }
    
}
