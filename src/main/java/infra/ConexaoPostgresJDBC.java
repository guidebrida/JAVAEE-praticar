/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme.bona
 */
public class ConexaoPostgresJDBC implements ConexaoJBDC {

    private Connection connection = null;

    public ConexaoPostgresJDBC() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "1153");

        this.connection = DriverManager.getConnection("jdbc:postgresql:localhost:7070/projetojavaee", properties);
        this.connection.setAutoCommit(false);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void commit() throws SQLException {
        this.connection.commit();
        this.close();
    }

    
    public void rollback() {
        if (this.connection != null) {
            try {
                this.connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.close();
            }
        }
    }

}