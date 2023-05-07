package Utilizator;

import java.awt.EventQueue;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
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
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;


public class AdaugaMenu extends JFrame {

	private JPanel contentPane;
	private JTextField denumireField;
	private JTextField stocField;
	private JTextField pretField;
	private JTextField autorField;
	private JTextField categorieField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugaMenu frame = new AdaugaMenu();
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
	public AdaugaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD BOOK");
		lblNewLabel.setBounds(440, 49, 173, 53);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(142, 131, 772, 491);
		contentPane.add(panel);
		
		JLabel denumireTxt = new JLabel("Titlu");
		denumireTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		denumireTxt.setBounds(113, 50, 109, 19);
		panel.add(denumireTxt);
		
		JLabel autorTxt = new JLabel("Autor:");
		autorTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		autorTxt.setBounds(113, 115, 105, 19);
		panel.add(autorTxt);
		
		JLabel categorieTxt = new JLabel("Categorie:");
		categorieTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		categorieTxt.setBounds(113, 180, 105, 25);
		panel.add(categorieTxt);
		
		JLabel stocTxt = new JLabel("Stoc:");
		stocTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		stocTxt.setBounds(113, 245, 105, 19);
		panel.add(stocTxt);
		
		JLabel pretTxt = new JLabel("Pret:");
		pretTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		pretTxt.setBounds(113, 309, 105, 19);
		panel.add(pretTxt);
		
		JLabel dEmpty = new JLabel("");
		dEmpty.setForeground(Color.RED);
		dEmpty.setBounds(232, 80, 417, 14);
		panel.add(dEmpty);
		
		JLabel aEmpty = new JLabel("");
		aEmpty.setForeground(Color.RED);
		aEmpty.setBackground(Color.WHITE);
		aEmpty.setBounds(232, 145, 417, 14);
		panel.add(aEmpty);
		
		JLabel cEmpty = new JLabel("");
		cEmpty.setForeground(Color.RED);
		cEmpty.setBounds(232, 210, 417, 14);
		panel.add(cEmpty);
		
		JLabel sEmpty = new JLabel("");
		sEmpty.setForeground(Color.RED);
		sEmpty.setBackground(Color.WHITE);
		sEmpty.setBounds(232, 274, 417, 14);
		panel.add(sEmpty);
		
		JLabel pEmpty = new JLabel("");
		pEmpty.setForeground(Color.RED);
		pEmpty.setBackground(Color.WHITE);
		pEmpty.setBounds(232, 339, 417, 14);
		panel.add(pEmpty);
		
		denumireField = new JTextField();
		denumireField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dEmpty.setText("");
			}
		});
		denumireField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		denumireField.setColumns(10);
		denumireField.setBounds(232, 40, 417, 40);
		panel.add(denumireField);
		
		autorField = new JTextField();
		autorField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				aEmpty.setText("");
			}
		});
		autorField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		autorField.setColumns(10);
		autorField.setBounds(232, 105, 417, 40);
		panel.add(autorField);
		
		categorieField = new JTextField();
		categorieField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cEmpty.setText("");
			}
		});
		categorieField.setText((String) null);
		categorieField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		categorieField.setColumns(10);
		categorieField.setBounds(232, 170, 417, 40);
		panel.add(categorieField);
		
		stocField = new JTextField();
		stocField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				sEmpty.setText("");
			}
		});
		stocField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stocField.setColumns(10);
		stocField.setBounds(232, 235, 417, 40);
		panel.add(stocField);
		
		pretField = new JTextField();
		pretField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pEmpty.setText("");
			}
		});
		pretField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pretField.setColumns(10);
		pretField.setBounds(232, 299, 417, 40);
		panel.add(pretField);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(denumireField.getText().trim().isEmpty() && autorField.getText().trim().isEmpty() && stocField.getText().trim().isEmpty() && pretField.getText().trim().isEmpty()) {
					dEmpty.setText("Denumire is empty!");
					aEmpty.setText("Autor is empty!");
					cEmpty.setText("Categorie is empty!");
					sEmpty.setText("Stoc is empty!");
					pEmpty.setText("Pret is empty!");
				}
				else if(denumireField.getText().trim().isEmpty()) {
					dEmpty.setText("Denumire is empty!");
				}
				else if(autorField.getText().trim().isEmpty()){
					aEmpty.setText("Autor is empty!");
				}
				else if(categorieField.getText().trim().isEmpty()){
					cEmpty.setText("Categorie is empty!");
				}
				else if(stocField.getText().trim().isEmpty()){
					sEmpty.setText("Stoc is empty!");
				}
				else if(pretField.getText().trim().isEmpty()) {
					pEmpty.setText("Pret is empty!");
				}
				else {
					try {
						Connection con = Connect.connection();
						String sql = "insert into stoc(denumire,autor,categorie,stoc,pret)values(?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, denumireField.getText());
						pst.setString(2, autorField.getText());
						pst.setString(3, categorieField.getText());
						pst.setString(4, stocField.getText());
						pst.setString(5, pretField.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Adaugat!");
						dEmpty.setText("");
						aEmpty.setText("");
						cEmpty.setText("");
						sEmpty.setText("");
						pEmpty.setText("");
						/*
						denumireField.setText("");
						autorField.setText("");
						stocField.setText("");
						pretField.setText("");
						*/
					}
					catch (Exception except) {
						except.printStackTrace();
					}
					
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(328, 417, 117, 63);
		panel.add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu;
				try {
					menu = new MainMenu();
					menu.setVisible(true);
					Toolkit toolkit = menu.getToolkit();
					Dimension size = toolkit.getScreenSize();
					menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
					setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 11, 98, 34);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
