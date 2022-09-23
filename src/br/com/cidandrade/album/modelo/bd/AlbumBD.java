package br.com.cidandrade.album.modelo.bd;

import br.com.cidandrade.album.modelo.dao.FigurinhaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlbumBD {

    public static void popular() {
        int qtdeFigurinhas = FigurinhaDAO.selecionarTodos().size();
        if (qtdeFigurinhas < 300) {
            for (int i = 1; i <= 300; i++) {
                FigurinhaDAO.inserir(i);
            }
        }
    }

    public static void execute(String sql, boolean continuaNoErro) {
        // Fazer versão para conexões seguidas não desconectar
        Connection con = conectar();
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
        desconectar(con);
    }

    public static Connection conectar() {
        Connection con = null;
        final String USUARIO = "cidandrade";
        final String SENHA = "123456";
        final String URL = "jdbc:mysql://localhost/albumDaCopa2022";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }

}