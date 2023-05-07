package Utilizator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditMenu extends JFrame {

	private JPanel contentPane;
	private JTextField denumireField;
	private JTextField autorField;
	private JTextField stocField;
	private JTextField pretField;
	static String denumire;
	static String autor;
	static int stoc;
	static double pret;
	/**
	 * @wbp.nonvisual location=1082,599
	 */
	private final JTextField idField = new JTextField();
	private JTextField categorieField;
	
	

	/**
	 * Create the frame.
	 */
	public EditMenu() {
		idField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditBook = new JLabel("EDIT BOOK");
		lblEditBook.setBounds(444, 61, 159, 25);
		lblEditBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEditBook);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(139, 129, 772, 505);
		contentPane.add(panel);
		
		JLabel denumireTxt = new JLabel("Titlu:");
		denumireTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		denumireTxt.setBounds(113, 50, 109, 19);
		panel.add(denumireTxt);
		
		JLabel autorTxt = new JLabel("Autor:");
		autorTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		autorTxt.setBounds(113, 115, 105, 19);
		panel.add(autorTxt);
		
		JLabel categorieTxt = new JLabel("Categorie:");
		categorieTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		categorieTxt.setBounds(113, 177, 105, 25);
		panel.add(categorieTxt);
		
		JLabel stocTxt = new JLabel("Stoc:");
		stocTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		stocTxt.setBounds(113, 245, 105, 19);
		panel.add(stocTxt);
		
		JLabel pretTxt = new JLabel("Pret:");
		pretTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		pretTxt.setBounds(113, 308, 105, 19);
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
		cEmpty.setBackground(Color.WHITE);
		cEmpty.setBounds(232, 210, 417, 14);
		panel.add(cEmpty);
		
		JLabel sEmpty = new JLabel("");
		sEmpty.setForeground(Color.RED);
		sEmpty.setBackground(Color.WHITE);
		sEmpty.setBounds(232, 275, 417, 14);
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
		denumireField.setText(denumire);
		
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
		autorField.setText(autor);
		
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
		//stocField.setText(stoc);
		
		pretField = new JTextField();
		pretField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pEmpty.setText("");
			}
		});
		pretField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pretField.setColumns(10);
		pretField.setBounds(232, 298, 417, 40);
		panel.add(pretField);
		//pretField.setText(pret);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.addActionListener(new ActionListener() {
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
						String sql = "update stoc set denumire=?, autor=?, categorie=?, stoc=?, pret=? where ID=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, denumireField.getText());
						pst.setString(2, autorField.getText());
						pst.setString(3, categorieField.getText());
						pst.setString(4, stocField.getText());
						pst.setString(5, pretField.getText());
						pst.setString(6, idField.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated!");
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
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateBtn.setBounds(332, 417, 117, 63);
		panel.add(updateBtn);
		
		
		
		
		
		
		
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
	
	public void load_Table(int selectedID) {
		
		try {
			Connection con = Connect.connection();
			PreparedStatement pst = con.prepareStatement("select * from stoc where ID=?");
			pst.setInt(1,selectedID);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				idField.setText(rs.getString("ID"));
				denumireField.setText(rs.getString("denumire"));;
				autorField.setText(rs.getString("autor"));;
				categorieField.setText(rs.getString("categorie"));;
				stocField.setText(rs.getString("stoc"));;
				pretField.setText(rs.getString("pret"));;
				

			}
			
			
			con.close();
			
		}
		catch(Exception except){
			except.printStackTrace();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMenu frame = new EditMenu();
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


