package vision;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldName;
	private JTextField txtFieldCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFieldName = new JTextField();
		txtFieldName.setBounds(87, 60, 106, 20);
		contentPane.add(txtFieldName);
		txtFieldName.setColumns(10);
		
		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(87, 89, 106, 20);
		contentPane.add(txtFieldCpf);
		txtFieldCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(31, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(31, 92, 46, 14);
		contentPane.add(lblCpf);
		
		JButton btnRegisterUser = new JButton("Cadastrar");
		btnRegisterUser.setBounds(87, 122, 106, 23);
		contentPane.add(btnRegisterUser);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(67, 22, 141, 14);
		contentPane.add(lblNewLabel_1);
	}
}
