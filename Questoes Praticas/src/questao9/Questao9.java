package questao9;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Questao9 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCpf;
	Connection conexao = null;
	PreparedStatement statement = null;

	// Informações para conexão com o banco de dados
	String url = "jdbc:mysql://localhost/"; // endereço do servidor e porta
	String user = "root"; // nome do usuário
	String password = "aluno"; // senha do usuário

	// Nome do banco de dados a ser criado
	String databaseName = "dbpds";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questao9 frame = new Questao9();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Questao9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(32, 45, 163, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(32, 90, 163, 20);
		contentPane.add(txtCpf);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(33, 28, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(33, 73, 46, 14);
		contentPane.add(lblCpf);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Criação da conexão com o banco de dados
					conexao = DriverManager.getConnection(url, user, password);
					
					String sql = "USE " +databaseName;
					statement = conexao.prepareStatement(sql);
					statement.executeUpdate();
					
					sql = "INSERT INTO  pessoa (nome, idade) VALUES (?, ?)";
					statement = conexao.prepareStatement(sql);
					statement.setString(1, txtName.getText());
					statement.setString(2, txtCpf.getText());

					// Execução da query SQL
					statement.executeUpdate();

					JOptionPane.showMessageDialog(null, "Pessoa adicionada com sucesso!");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente.");
				} finally {
					// Fechamento da conexão com o banco de dados
					try {
						if (statement != null) {
							statement.close();
						}
						if (conexao != null) {
							conexao.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente.");
					}
				}

			}
		});
		btnNewButton.setBounds(32, 124, 164, 29);
		contentPane.add(btnNewButton);
	}
}
