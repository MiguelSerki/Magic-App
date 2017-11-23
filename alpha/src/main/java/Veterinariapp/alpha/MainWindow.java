package Veterinariapp.alpha;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frmVeterinariapp;
	private JPanel panelMain;
	private JPanel panelClientes;
	private JPanel panelPacientes;
	private JPanel panelTienda;
	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVeterinariapp = new JFrame();
		frmVeterinariapp.setTitle("VeterinariApp");
		frmVeterinariapp.setBounds(100, 100, 450, 300);
		frmVeterinariapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVeterinariapp.getContentPane().setLayout(new CardLayout(0, 0));
		
		this.panelMain = new JPanel();
		frmVeterinariapp.getContentPane().add(panelMain, "name_1044949401725964");
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelClientes.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPacientes.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTienda.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addGap(55)
					.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPacientes, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTienda, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panelMain.setVerticalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelMain.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnPacientes, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClientes, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTienda, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(129))
		);
		panelMain.setLayout(gl_panelMain);
		
		this.panelClientes = new JPanel();
		panelClientes.setVisible(false);
		frmVeterinariapp.getContentPane().add(panelClientes, "name_1044952034187234");
		JLabel lblLoClientes = new JLabel("Lo clientes");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelClientes.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		GroupLayout gl_panelClientes = new GroupLayout(panelClientes);
		gl_panelClientes.setHorizontalGroup(
			gl_panelClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClientes.createSequentialGroup()
					.addGap(161)
					.addComponent(lblLoClientes)
					.addContainerGap(227, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelClientes.createSequentialGroup()
					.addContainerGap(335, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		gl_panelClientes.setVerticalGroup(
			gl_panelClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClientes.createSequentialGroup()
					.addGap(58)
					.addComponent(lblLoClientes)
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		panelClientes.setLayout(gl_panelClientes);
		
		this.panelPacientes = new JPanel();
		panelPacientes.setVisible(false);
		frmVeterinariapp.getContentPane().add(panelPacientes, "name_1044954513286847");
		JLabel lblLoPacientes = new JLabel("Lo pacientes");
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPacientes.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		GroupLayout gl_panelPacientes = new GroupLayout(panelPacientes);
		gl_panelPacientes.setHorizontalGroup(
			gl_panelPacientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPacientes.createSequentialGroup()
					.addGap(185)
					.addComponent(lblLoPacientes)
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelPacientes.createSequentialGroup()
					.addContainerGap(361, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelPacientes.setVerticalGroup(
			gl_panelPacientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPacientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoPacientes)
					.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		panelPacientes.setLayout(gl_panelPacientes);
		
		this.panelTienda = new JPanel();
		panelTienda.setVisible(false);
		frmVeterinariapp.getContentPane().add(panelTienda, "name_1044969046821487");
		
		JLabel lblLaTienda = new JLabel("La Tienda");
		
		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTienda.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		GroupLayout gl_panelTienda = new GroupLayout(panelTienda);
		gl_panelTienda.setHorizontalGroup(
			gl_panelTienda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTienda.createSequentialGroup()
					.addGap(184)
					.addComponent(lblLaTienda)
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelTienda.createSequentialGroup()
					.addContainerGap(361, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelTienda.setVerticalGroup(
			gl_panelTienda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTienda.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLaTienda)
					.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		panelTienda.setLayout(gl_panelTienda);
	}
	
	//getter of the frame
	public JFrame getFrame () {
		return this.frmVeterinariapp;
	}
}
