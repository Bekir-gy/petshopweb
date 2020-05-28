/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Acer
 */
public abstract class DBConnect {
    private Connection connection;
    
    public Connection connect() throws SQLException{
        if(this.connection==null|| this.connection.isClosed()){//too many clients hatasının çözümü
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/petshop", "root", "12345678");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
        return this.connection;
       
    }
}
