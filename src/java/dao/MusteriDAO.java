/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.Cins;
import entity.Musteri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;

/**
 *
 * @author Acer
 */
public class MusteriDAO extends DBConnect{
     public Musteri getById(int id){
        Musteri l=null;
        try{
            
            Statement st=this.connect().createStatement();
            ResultSet rs=st.executeQuery("select * from musteri where m_id="+id);
            rs.next();
            Cins m_cid = null;
            l=new Musteri(rs.getInt("m_id"),rs.getString("m_adi"),rs.getString("m_soyadi"),m_cid);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    

private CinsDAO cDao;

    public CinsDAO getcDao() {
        if(cDao==null){
            this.cDao=new CinsDAO();
        }
        return cDao;
    }

    public void setcDao(CinsDAO cDao) {
        this.cDao = cDao;
    }
 
   
 public void create(Musteri c) {
        try {
             PreparedStatement pst=this.connect().prepareStatement("insert into musteri (m_adi,m_soyadi,cins_id) values (?,?,?)");
             pst.setString(1, c.getMusteriad());
             pst.setString(2, c.getMusterisoyad());
             pst.setInt(3, c.getMustericinsID().getCinsID());
              pst.executeUpdate();
            /*Statement st = connect().createStatement();
            st.executeUpdate("insert into musteri (m_adi,m_soyadi,cins_id) values ('" + c.getMusteriad()+ "','" + c.getMusterisoyad()+ "'," + c.getMustericinsID().getCinsID() + ")");*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


 public List<Musteri> read(int page, int pagesize) {
        List<Musteri> list = new ArrayList<>();
        int start=(page-1)*pagesize;
        try {
             PreparedStatement pst=this.connect().prepareStatement("select * from musteri order by m_id asc limit "+start+","+pagesize);
              ResultSet rs =pst.executeQuery(); 
           /* Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("select * from musteri order by m_id desc");*/
            while (rs.next()) {
               Cins l= this.getcDao().getById(rs.getInt("cins_id"));
                Musteri tmp = new Musteri(rs.getInt("m_id"), rs.getString("m_adi"), rs.getString("m_soyadi"), l);
                list.add(tmp);
            }
            pst.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
 
 public int count() {
       int count=0;
        try {
             PreparedStatement pst=this.connect().prepareStatement("select count(m_id) as musteri_count from musteri");
              ResultSet rs =pst.executeQuery(); 
           /* Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("select * from musteri order by m_id desc");*/
             rs.next(); 
             count=rs.getInt("musteri_count");
               
            
            /*pst.close();
            rs.close();*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

public void update(Musteri c) {
        try {
             PreparedStatement pst=this.connect().prepareStatement("update musteri set m_adi=?, m_soyadi=?, cins_id=? where m_id=?");
            pst.setString(1, c.getMusteriad());
             pst.setString(2, c.getMusterisoyad());
             pst.setInt(3, c.getMustericinsID().getCinsID());
             pst.setInt(4, c.getMusteriID());
             pst.executeUpdate();
            /* Statement st = connect().createStatement();
            st.executeUpdate("update musteri set m_adi='" + c.getMusteriad()+ "', m_soyadi='" + c.getMusterisoyad() + "', cins_id=" + c.getMustericinsID().getCinsID() + " where m_id=" + c.getMusteriID());*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

public void delete(Musteri c) {
        try {
            /*PreparedStatement pst=this.connect().prepareStatement("delete from musteri where m_id=?");
            pst.setInt(1, c.getMusteriID());
            pst.executeUpdate();*/
            Statement st = connect().createStatement();
            st.executeUpdate("delete from musteri where m_id=" + c.getMusteriID());
            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   

    
    
}