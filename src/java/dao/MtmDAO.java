/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Mama;
import entity.Mtm;
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
public class MtmDAO extends DBConnect{
    private MusteriDAO mDao;
    private MamaDAO mamaDao;

    public MusteriDAO getmDao() {
        if(mDao==null){
            this.mDao= new MusteriDAO();
        }
        return mDao;
    }

    public void setmDao(MusteriDAO mDao) {
        this.mDao = mDao;
    }

    public MamaDAO getMamaDao() {
        if(mamaDao==null){
            this.mamaDao=new MamaDAO();
        }
        return mamaDao;
    }

    public void setMamaDao(MamaDAO mamaDao) {
        this.mamaDao = mamaDao;
    }
    
     public void create(Mtm c) {
        try {
             PreparedStatement pst=this.connect().prepareStatement("insert into many_to (m_id,mama_id) values (?,?)");
             pst.setInt(1, c.getMusteriID().getMusteriID());
             pst.setInt(2, c.getMamaID().getMamaID());
              pst.executeUpdate();
            /*Statement st = connect().createStatement();
            st.executeUpdate("insert into many_to (m_id,mama_id) values (" + c.getMusteriID().getMusteriID() + "," + c.getMamaID().getMamaID() + ")");*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
     
     public List<Mtm> read() {
        List<Mtm> list = new ArrayList<>();
        try {
             PreparedStatement pst=this.connect().prepareStatement("select * from many_to order by many_id asc");
             ResultSet rs =pst.executeQuery(); 
           /* Statement st = connect().createStatement();
            ResultSet rs = st.executeQuery("select * from many_to order by many_id desc");*/
            while (rs.next()) {
               Musteri l= this.getmDao().getById(rs.getInt("m_id"));
               Mama m= this.getMamaDao().getById(rs.getInt("mama_id"));
                Mtm tmp = new Mtm (rs.getInt("many_id"),l,m);
                list.add(tmp);
            }
            pst.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     
      public void update(Mtm c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("update many_to set m_id=" + c.getMusteriID().getMusteriID()+", mama_id=" + c.getMamaID().getMamaID()+" where many_id=" + c.getManyid() );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
      
       public void delete(Mtm c) {
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("delete from many_to where many_id=" + c.getManyid());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
