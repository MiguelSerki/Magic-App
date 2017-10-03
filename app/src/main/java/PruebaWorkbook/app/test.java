package PruebaWorkbook.app;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JsoupRun jsoup;
	private WorkBook excel;
	private static int rowInt;
	private static int cell;
	private JScrollPane scrollPane;
	private JTable table;
	private String[]column;
	private Object [][] row;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
					jsoup = new JsoupRun ();
					cell = 1;
					rowInt = 24;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar link");
		btnAgregar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
			jsoup.getLink(textField.getText());
			int i = jsoup.getData();
			jsoup.setAmount(1);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "Invalido, intente de nuevo");
			}
			else {
				((DefaultTableModel) table.getModel()).addRow(new Object[]{jsoup.getName(),jsoup.getAmount(),jsoup.getExpansion(),jsoup.getCategory(),jsoup.getPrice(), (jsoup.getAmount()*jsoup.getPrice()), jsoup.getLink()});
/*				try {
					excel = new WorkBook (rowInt, cell, "Pedido.xls", jsoup.getName(),jsoup.getCategory(),jsoup.getPrice(),jsoup.getExpansion(),jsoup.getLink(),jsoup.getAmount() );
				} catch (IOException e) {
					e.printStackTrace();
				}
			*/
				}
			textField.setText(null);
			rowInt ++;
			}
		});
		
		column = new String []{"Nombre de la carta",
				"Cantidad", 
				"Edición",
				"Condición",
				"Precio", 
				"Subtotal", 
				"Link"};
row = new Object[][] {{}
};
		scrollPane = new JScrollPane();
		
		JLabel lblInserteElLink = new JLabel("Inserte el link de la carta");
		lblInserteElLink.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(547)
					.addComponent(btnAgregar))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInserteElLink, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblInserteElLink, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAgregar)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable(row,column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre de la carta", "Cantidad", "Edici\u00F3n", "Condici\u00F3n", "Precio", "Subtotal", "Link"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(153);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(5).setPreferredWidth(62);
		table.getColumnModel().getColumn(6).setPreferredWidth(220);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
