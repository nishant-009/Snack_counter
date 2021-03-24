import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;


import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SnackC {

	private JFrame frame;
	private JTable table;
	private JTextField textTableNO;
	private JTextField textSpBiryani;
	private JTextField textMurgMaslam;
	private JTextField textShawrma;
	private JTextField textRoti;
	private JTextField textNaan;
	

	
	Connection conn =null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	
	public void updateTable() 
	{
		conn = restoData.ConnectDB();
		if (conn != null)
		{
			String sql = "Select TableNO,SpBiryani,MurgMaslam,Roti,Naan,Shawrma from entry";
			
			
			try 
			{
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[6];
				
				while(rs.next()) {
					columnData[0] = rs.getInt("TableNO");
					columnData[1] = rs.getString("SpBiryani");
					columnData[2] = rs.getString("MurgMaslam");
					columnData[3] = rs.getInt("Roti");
					columnData[4] = rs.getInt("Naan");
					columnData[5] = rs.getString("Shawrma");
					
					model.addRow(columnData);
					
				}
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		
		}
		
	
		
	}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnackC window = new SnackC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		}

	/**
	 * Create the application.
	 */
	public SnackC() {
		initialize();
		
		Object col[] = {"TableNO","SpBiryani","Murgmaslam","Roti","Naan","Shawrma"};
		
		model.setColumnIdentifiers(col);
		table.setModel(model);
		conn = restoData.ConnectDB();
		
		 updateTable() ;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1202, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 13, 353, 317);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTableNO = new JLabel("TableNO");
		lblTableNO.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTableNO.setBounds(12, 13, 78, 16);
		panel.add(lblTableNO);
		
		textTableNO = new JTextField();
		textTableNO.setBounds(156, 10, 116, 22);
		panel.add(textTableNO);
		textTableNO.setColumns(10);
		
		JLabel lblSpBiryani = new JLabel("SpBiryani");
		lblSpBiryani.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpBiryani.setBounds(12, 55, 78, 19);
		panel.add(lblSpBiryani);
		
		JLabel lblMurgMaslam = new JLabel("MurgMaslam");
		lblMurgMaslam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMurgMaslam.setBounds(12, 105, 99, 16);
		panel.add(lblMurgMaslam);
		
		JLabel lblRoti = new JLabel("Roti");
		lblRoti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoti.setBounds(12, 155, 88, 16);
		panel.add(lblRoti);
		
		JLabel lblNaan = new JLabel("Naan");
		lblNaan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNaan.setBounds(12, 205, 56, 16);
		panel.add(lblNaan);
		
		textSpBiryani = new JTextField();
		textSpBiryani.setBounds(156, 52, 116, 22);
		panel.add(textSpBiryani);
		textSpBiryani.setColumns(10);
		
		textMurgMaslam = new JTextField();
		textMurgMaslam.setBounds(156, 104, 116, 22);
		panel.add(textMurgMaslam);
		textMurgMaslam.setColumns(10);
		
		JLabel lblShawrma = new JLabel("Shawrma");
		lblShawrma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblShawrma.setBounds(12, 255, 88, 16);
		panel.add(lblShawrma);
		
		textShawrma = new JTextField();
		textShawrma.setText("");
		textShawrma.setBounds(156, 254, 170, 22);
		panel.add(textShawrma);
		textShawrma.setColumns(10);
		
		textRoti = new JTextField();
		textRoti.setBounds(156, 154, 116, 22);
		panel.add(textRoti);
		textRoti.setColumns(10);
		
		textNaan = new JTextField();
		textNaan.setBounds(156, 204, 116, 22);
		panel.add(textNaan);
		textNaan.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(404, 13, 768, 584);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 744, 558);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TableNO", "SpBiryani", "MurgMaslam", "Roti", "Naan", "Shawrma"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(12, 353, 353, 215);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnTOTAL = new JButton("TOTAL");
		btnTOTAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		btnTOTAL.setBounds(12, 31, 97, 25);
		panel_2.add(btnTOTAL);
		
		JButton btnUPDATE = new JButton("UPDATE");
		btnUPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "INSERT INTO entry(TableNO,SpBiryani,MurgMaslam,Roti,Naan,Shawrma)VALUES(?,?,?,?,?,?)";
				
				try
				{
					pst = conn.prepareStatement(sql);
					pst.setString(1,textTableNO.getText());
					pst.setString(2,textSpBiryani.getText());
					pst.setString(3,textMurgMaslam.getText());
					pst.setString(4,textRoti.getText());
					pst.setString(5,textNaan.getText());
					pst.setString(6,textShawrma.getText());
					
					pst.execute();
					rs.close();
					pst.close();
				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, ev);
				}
				
				if(table.getSelectedRow() == -1) {
					if(table.getSelectedRow() == 0) {
						JOptionPane.showMessageDialog(null,"data updated","resto system", JOptionPane.OK_OPTION);
					}
			}
				updateTable();
			}	
		});
		btnUPDATE.setBounds(12, 97, 97, 25);
		panel_2.add(btnUPDATE);
		
		JButton btnRESET = new JButton("RESET");
		btnRESET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					textTableNO.setText(null);
					textSpBiryani.setText(null);
					textMurgMaslam.setText(null);
					textRoti .setText(null);
					textNaan.setText(null);
					textShawrma.setText(null);
				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null,ev);
				}
			}
			
		});
		btnRESET.setBounds(12, 165, 97, 25);
		panel_2.add(btnRESET);
		
		JButton btnDELETE = new JButton("DELETE");
		btnDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				
				if(table.getSelectedRow() == -1) {
					if(table.getSelectedRow() == 0) {
						JOptionPane.showMessageDialog(null,  "No data to delete","resto system", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null,  "Select row to delete","resto system", JOptionPane.OK_OPTION);
					}
						
				}else {
					mod.removeRow(table.getSelectedRow());
				}
				
			}
		});
		btnDELETE.setBounds(185, 31, 97, 25);
		panel_2.add(btnDELETE);
		
		JButton btnEXIT = new JButton("EXIT");
		btnEXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame = new JFrame("EXit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if u want to exit", "Resto System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
					System.exit(0);
			}
		});
		btnEXIT.setBounds(185, 165, 97, 25);
		panel_2.add(btnEXIT);
		
		JButton btnPRINT = new JButton("PRINT");
		btnPRINT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					table.print();
				}
				catch(java.awt.print.PrinterException ev)
				{
					System.err.format("No Printer found", ev.getMessage());
				}
			}
		});
		btnPRINT.setBounds(185, 97, 97, 25);
		panel_2.add(btnPRINT);
	}
}
