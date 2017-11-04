/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase.project;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Milos Dragovic
 */
public class JavaDataBaseProject {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        try (Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root", "")) {
            System.out.println("Is connection to database broke? " + conn.isClosed());

            /**
             * -------OBICNAN UPIT------- iz statementa dobijenog iz conn
             * promenljive sa execute metodom i prosledjenim odmah izvrsavamo
             * query
             */
//        Statement st = conn.createStatement();
//        st.execute("create table testTable (id int primary key auto_increment, name varchar(256))");
            /**
             * --------PARAMETARSKI UPIT------ Slicno kao prethodno samo sto
             * dodajemo neke promenljive parametre u upit koji zelimo da
             * izvrsimo , s tim sto sa ? postavljamo poziciju te promenljive
             * koja ce se pojaviti * sa st.setSring(pozicija parametra u upitu,
             * vrednost parametra)
             */
//            String name = "Marko"; 
//            PreparedStatement st = conn.prepareStatement("insert into testTable  values(?)");
//            st.setString(3, name);
//            st.execute();

            System.out.println("Konekcija uspesna");
            Statement ste = conn.createStatement();
            ste.executeQuery("select * from testTable");
            ResultSet rs = ste.getResultSet();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            rs.close();
        }
    }

}
