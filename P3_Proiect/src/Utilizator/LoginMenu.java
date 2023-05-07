package Utilizator;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu frame = new LoginMenu();
					frame.setVisible(true);
					Toolkit toolkit = frame.getToolkit();
					Dimension size = toolkit.getScreenSize();
					frame.setLocation(size.width/2 - frame.getWidth()/2, size.height/2 - frame.getHeight()/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginMenu() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setBounds(342, 134, 363, 39);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(142, 260, 772, 241);
		contentPane.add(panel);
		
		JLabel textfield = new JLabel("Username:");
		textfield.setFont(new Font("Tahoma", Font.BOLD, 20));
		textfield.setBounds(113, 50, 109, 19);
		panel.add(textfield);
		
		JLabel passwordtxt = new JLabel("Password:");
		passwordtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordtxt.setBounds(117, 155, 105, 19);
		panel.add(passwordtxt);
		
		JLabel uEmpty = new JLabel("");
		uEmpty.setForeground(new Color(255, 0, 0));
		uEmpty.setBounds(232, 91, 417, 14);
		panel.add(uEmpty);
		
		JLabel pEmpty = new JLabel("");
		pEmpty.setForeground(new Color(255, 0, 0));
		pEmpty.setBackground(new Color(255, 255, 255));
		pEmpty.setBounds(232, 196, 417, 14);
		panel.add(pEmpty);
		
		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				uEmpty.setText("");
			}
		});
		
		username.setText("admin");
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(232, 40, 417, 40);
		panel.add(username);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pEmpty.setText("");
			}
		});
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(232, 145, 417, 40);
		panel.add(password);
		
		
		
		JButton btnNewButton = new JButton("LOGIN");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().trim().isEmpty() && password.getText().trim().isEmpty()) {
					uEmpty.setText("Username is empty!");
					pEmpty.setText("Password is empty!");
				}
				else if(username.getText().trim().isEmpty()) {
					uEmpty.setText("Username is empty!");
				}
				else if(password.getText().trim().isEmpty())
				{
					pEmpty.setText("Password is empty!");
				}
				else {
					try {
						Connection con = Connect.connection();
						String sql = "Select * from users where username=? and password=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, username.getText());
						pst.setString(2, password.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Conectare cu succes!");
							MainMenu menu = new MainMenu();
							menu.setVisible(true);
							Toolkit toolkit = menu.getToolkit();
							Dimension size = toolkit.getScreenSize();
							menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
							setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Numele de utilizator sau parola gresite!");
							username.setText("");
							password.setText("");
						}
						con.close();
						
					}
					catch(Exception except){
						JOptionPane.showMessageDialog(null, except);
						
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(408, 540, 230, 61);
		contentPane.add(btnNewButton);
	}
}
