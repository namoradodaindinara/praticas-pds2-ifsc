package questao10;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Questao10 extends JFrame {
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public Questao10() {
        super("Tabela");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuração da tabela
        modeloTabela = new DefaultTableModel();
        tabela = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);

        // Conexão com o banco de dados
        try {
            String url = "jdbc:mysql://localhost:3306/dbpds";
            String usuario = "root";
            String senha = "aluno";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Consulta na tabela
            String sql = "SELECT nome, idade FROM pessoa";
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            // Preenchimento da tabela com os dados da consulta
            modeloTabela.addColumn("Nome");
            modeloTabela.addColumn("Idade");

            while (resultado.next()) {
                String[] linha = new String[2];
                linha[0] = resultado.getString("nome");
                linha[1] = resultado.getString("idade");
                modeloTabela.addRow(linha);
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Questao10());
    }
}
