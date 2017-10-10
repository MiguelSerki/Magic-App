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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class window extends JFrame {


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
	private JTextField nameField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
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
	public window() {
		setTitle("Pedidos MTG Rosario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(window.class.getResource("/recursos/icon.jpg")));
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
			int i = jsoup.getLink(textField.getText());

			if (i == 1) {
				JOptionPane.showMessageDialog(null, "Link invalido, sólo se aceptan links de mtgmintcard.com");
			}
			else {
				jsoup.getData();
				jsoup.setAmount(1);
				((DefaultTableModel) table.getModel()).addRow(new Object[]{jsoup.getName(),jsoup.getAmount(),jsoup.getExpansion(),jsoup.getCategory(),jsoup.getPrice(), jsoup.getLink()});
				}
			textField.setText(null);
			}
		});
		
		column = new String []{"Nombre de la carta",
				"Cantidad", 
				"Edición",
				"Condición",
				"Precio", 
				"Link"};
row = new Object[][] {{}
};
		scrollPane = new JScrollPane();
		
		JLabel lblInserteElLink = new JLabel("Inserte el link de la carta");
		lblInserteElLink.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (JOptionPane.showConfirmDialog(getComponent(0), "¿Desea terminar?") == 0) {
					FileChooser chooser = new FileChooser();
					InputStream a = null;
					File b = null;
					try {
						ClassLoader classLoader = getClass().getClassLoader();
						a = getClass().getResourceAsStream("/recursos/Pedido.xls");
						b = new File(chooser.saveMe());
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
					CopyFile copy = new CopyFile ();
					try {
						copy.copy(a, b);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					excel = new WorkBook ();
					try {
						excel.edditExcel(rowInt, cell, b.getAbsolutePath(), table,nameField.getText() );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				JOptionPane.showMessageDialog(null,"Su archivo se creó exitosamente!");
				System.exit(EXIT_ON_CLOSE);
				}

			}
		});
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNombreYApellido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
							.addComponent(btnAgregar))
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(lblInserteElLink, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(btnFinalizar))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblInserteElLink, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreYApellido)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAgregar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFinalizar)
					.addContainerGap())
		);
		
		table = new JTable(row,column);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (table.isRowSelected(table.getSelectedRow())) {
					if (e.getKeyCode()== 127 || e.getKeyCode() == 8) {
						DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
						int selectedRow = table.getSelectedRow();
						modelTable.removeRow(selectedRow);
					}
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre de la carta", "Cantidad", "Edici\u00F3n", "Condici\u00F3n", "Precio", "Link"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, Double.class, String.class
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
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
