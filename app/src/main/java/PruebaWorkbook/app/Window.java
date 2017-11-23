package PruebaWorkbook.app;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.CardLayout;

public class Window extends JFrame {


	private JPanel panelMain;
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
	private static int serial;
	private static int activacion;
	private static int trial;
	private static int key;
	private JPanel panelSerial;
	private JLabel label;
	private JTextField personalCode;
	private JButton button;
	private JButton button_1;
	private JTextField serialCode;
	private JLabel lblInserteElSerial;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public Window() {
		setTitle("Pedidos MTG Rosario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/recursos/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		column = new String []{"Nombre de la carta",
				"Cantidad", 
				"Edición",
				"Condición",
				"Precio", 
				"Link"};
row = new Object[][] {{}
};
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelSerial = new JPanel();
		contentPane.add(panelSerial, "name_1067880782223691");
		
		label = new JLabel("Su código personal es:");
		
		personalCode = new JTextField();
		personalCode.setColumns(10);
		
		button = new JButton("Trial");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "La versión trial te permite agregar hasta 5 links.");
			panelMain.setVisible(true);
			panelSerial.setVisible(false);
			}
		});
		
		button_1 = new JButton("Activar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (serialCode.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe copiar el serial en el cuadro de texto de arriba para activar el producto");
				}else {
					if (Integer.parseInt(serialCode.getText()) != key) {
						JOptionPane.showMessageDialog(null, "Código de activación invalido.");
					}else {
						JOptionPane.showMessageDialog(null, "Activación exitosa!");
						activacion = 1;
						panelSerial.setVisible(false);
						panelMain.setVisible(true);
					}
				}
				
			}
		});
		
		serialCode = new JTextField();
		serialCode.setColumns(10);
		
		lblInserteElSerial = new JLabel("Inserte el Serial");
		GroupLayout gl_panelSerial = new GroupLayout(panelSerial);
		gl_panelSerial.setHorizontalGroup(
			gl_panelSerial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSerial.createSequentialGroup()
					.addGap(138)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(356)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(66))
				.addGroup(Alignment.TRAILING, gl_panelSerial.createSequentialGroup()
					.addContainerGap()
					.addComponent(serialCode, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelSerial.createSequentialGroup()
					.addGap(332)
					.addComponent(lblInserteElSerial, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(332))
				.addGroup(Alignment.TRAILING, gl_panelSerial.createSequentialGroup()
					.addGap(149)
					.addGroup(gl_panelSerial.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
						.addComponent(personalCode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
					.addGap(148))
		);
		gl_panelSerial.setVerticalGroup(
			gl_panelSerial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSerial.createSequentialGroup()
					.addGap(81)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(personalCode, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(lblInserteElSerial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(serialCode, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(104)
					.addGroup(gl_panelSerial.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelSerial.createSequentialGroup()
							.addGap(1)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		panelSerial.setLayout(gl_panelSerial);
		panelMain = new JPanel();
		panelMain.setVisible(false);
		contentPane.add(panelMain, "name_1066934340852033");
		
				
				
				textField = new JTextField();
				textField.setColumns(10);
				
				JButton btnAgregar = new JButton("Agregar link");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (activacion == 0) {
							trial++;
							}
						if (trial >= 5) {
						JOptionPane.showMessageDialog(null, "El trial expiró, deme su dinero y dejaré de molestarlo");
						}
						int i = jsoup.getLink(textField.getText());

					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Link invalido, sólo se aceptan links de mtgmintcard.com");
					}
					else {
						jsoup.getData();
						jsoup.setAmount(1);
						((DefaultTableModel) table.getModel()).addRow(new Object[]{jsoup.getName(),
								jsoup.getAmount(),
								jsoup.getExpansion(),
								jsoup.getCategory(),
								jsoup.getPrice(),
								jsoup.getLink()});
						}
					textField.setText(null);
					}
				});
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
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, Integer.class, String.class, String.class, Double.class, String.class
					};
					@SuppressWarnings({ "rawtypes", "unchecked" })
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
				GroupLayout gl_panelMain_1 = new GroupLayout(panelMain);
				gl_panelMain_1.setHorizontalGroup(
					gl_panelMain_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelMain_1.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
								.addGroup(gl_panelMain_1.createSequentialGroup()
									.addComponent(lblNombreYApellido)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
									.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
								.addComponent(btnFinalizar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_panelMain_1.createSequentialGroup()
									.addGap(259)
									.addComponent(lblInserteElLink, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
									.addGap(241)))
							.addContainerGap())
				);
				gl_panelMain_1.setVerticalGroup(
					gl_panelMain_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain_1.createSequentialGroup()
							.addGap(14)
							.addComponent(lblInserteElLink, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panelMain_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreYApellido)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAgregar))
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(btnFinalizar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				panelMain.setLayout(gl_panelMain_1);
	}



	public void setValues() {
		jsoup = new JsoupRun();
		MAC mac = new MAC();
		serial = mac.getSerial();
		cell = 1;
		rowInt = 24;
		key = (serial * 2 + serial * 4) + (serial -5) *2;
		this.personalCode.setText(String.valueOf(serial));
		activacion = 0;
	}
}
