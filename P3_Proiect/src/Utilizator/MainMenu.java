package Utilizator;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField searchBar;
	private JPanel contentPane;
	private JTable tabelCarti;
	DefaultTableModel model;
	int selectedID = 0;
	private JTextField maxField;
	
	public void load_Table() {
		
		try {
			Connection con = Connect.connection();
			PreparedStatement pst = con.prepareStatement("select * from stoc");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String denumire = rs.getString("denumire");
				String autor = rs.getString("autor");
				String categorie = rs.getString("categorie");
				int stoc = rs.getInt("stoc");
				double pret = rs.getDouble("pret");
				
				
				Object[] obj = {id, denumire, autor, categorie, stoc, pret};
				
				model = (DefaultTableModel) tabelCarti.getModel();
				model.addRow(obj);
				tabelCarti.setModel(model);
			}
			con.close();
			
		}
		catch(Exception except){
			except.printStackTrace();
		}
	}
	
	public void search(String str) {
		model = (DefaultTableModel) tabelCarti.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tabelCarti.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str,1,2,3));
	}
	
	public void filter(int nr) {
		model = (DefaultTableModel) tabelCarti.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tabelCarti.setRowSorter(trs);
		
		List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);

        filters.add(0, RowFilter.numberFilter(ComparisonType.EQUAL, nr,4));
        filters.add(0, RowFilter.numberFilter(ComparisonType.BEFORE, nr,4));
        
		trs.setRowFilter(RowFilter.orFilter(filters));
	}
	
	public int select_Carte() {
		ListSelectionModel model = tabelCarti.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()) {
					int selectedRow = model.getMinSelectionIndex();
					
					selectedID = (int) tabelCarti.getValueAt(selectedRow, 0);
					
				}
			}
		});
		
		return selectedID;
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public MainMenu() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 963);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchBar = new JTextField();
		searchBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchBar.getText();
				search(searchString);
			}
		});
		searchBar.setBounds(151, 67, 217, 56);
		contentPane.add(searchBar);
		searchBar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setBounds(49, 63, 80, 56);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		maxField = new JTextField();
		maxField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		maxField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || (int)e.getKeyChar() == 8) {
		               maxField.setEditable(true);
		            } else {
		               maxField.setEditable(false);
		            }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
					int filterInt = Integer.parseInt(maxField.getText());
					filter(filterInt);
				}
				else {
					search("");
				}
				
			}
		});
		maxField.setBounds(151, 134, 217, 56);
		contentPane.add(maxField);
		maxField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 199, 1353, 672);
		contentPane.add(scrollPane);
		
		tabelCarti = new JTable();
		tabelCarti.setBorder(null);
		tabelCarti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabelCarti.setRowHeight(30);
		tabelCarti.getTableHeader().setReorderingAllowed(false);
		tabelCarti.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		tabelCarti.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tabelCarti.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Denumire", "Autor", "Categorie", "Stoc", "Pret (RON)"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class,String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelCarti.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabelCarti.getColumnModel().getColumn(0).setMinWidth(10);
		tabelCarti.getColumnModel().getColumn(0).setMaxWidth(40);
		tabelCarti.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabelCarti.getColumnModel().getColumn(3).setMinWidth(150);
		tabelCarti.getColumnModel().getColumn(3).setMaxWidth(150);
		tabelCarti.getColumnModel().getColumn(4).setPreferredWidth(65);
		tabelCarti.getColumnModel().getColumn(4).setMinWidth(65);
		tabelCarti.getColumnModel().getColumn(4).setMaxWidth(100);
		tabelCarti.getColumnModel().getColumn(5).setPreferredWidth(95);
		tabelCarti.getColumnModel().getColumn(5).setMinWidth(95);
		tabelCarti.getColumnModel().getColumn(5).setMaxWidth(100);
		scrollPane.setViewportView(tabelCarti);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedID != 0) {
					try {
						Connection con = Connect.connection();
						PreparedStatement pst = con.prepareStatement("delete from stoc where ID=?");
						pst.setInt(1,selectedID);
						
						pst.executeUpdate();
						
						MainMenu menu = new MainMenu();
						menu.setVisible(true);
						Toolkit toolkit = menu.getToolkit();
						Dimension size = toolkit.getScreenSize();
						menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
						SwingUtilities.updateComponentTreeUI(menu);
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Deleted!");
						
						con.close();
						
					}
					catch(Exception except){
						except.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Select a book to delete!");
				}
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		deleteBtn.setBounds(1256, 132, 122, 56);
		contentPane.add(deleteBtn);
		
		JButton editBtn = new JButton("EDIT");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedID != 0) {
					EditMenu menu = new EditMenu();
					menu.setVisible(true);
					menu.load_Table(selectedID);
					Toolkit toolkit = menu.getToolkit();
					Dimension size = toolkit.getScreenSize();
					menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Select a book to edit!");
				}
			}
		});
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		editBtn.setBounds(1124, 132, 122, 56);
		contentPane.add(editBtn);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(992, 132, 122, 56);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugaMenu menu = new AdaugaMenu();
				menu.setVisible(true);
				Toolkit toolkit = menu.getToolkit();
				Dimension size = toolkit.getScreenSize();
				menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Max Stoc:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(49, 130, 100, 56);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(1300, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMenu menu = new LoginMenu();
				menu.setVisible(true);
				Toolkit toolkit = menu.getToolkit();
				Dimension size = toolkit.getScreenSize();
				menu.setLocation(size.width/2 - menu.getWidth()/2, size.height/2 - menu.getHeight()/2);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		load_Table();
		
		tabelCarti.setDefaultEditor(Object.class, null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		selectedID = select_Carte();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MainMenu s = new MainMenu();
		s.setVisible(true);
	}
}
