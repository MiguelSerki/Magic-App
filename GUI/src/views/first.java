package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLinkCarta;
	private JButton btnAgregarCarta;
	private String html;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
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
	public first() {
		
		initComponents();
		createEvents();
		
	}
/////////////////////////////////////////////////
	//creating events and initialiting comonents
/////////////////////////////////////////////////
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(first.class.getResource("/resources/icon.jpg")));
		setTitle("MTG Mintcard pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Link de la carta");
		
		textFieldLinkCarta = new JTextField();

		textFieldLinkCarta.setColumns(10);
		
		btnAgregarCarta = new JButton("Agregar carta");
		btnAgregarCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				html = textFieldLinkCarta.getText();
				System.out.println(html);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldLinkCarta, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
						.addComponent(btnAgregarCarta, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldLinkCarta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAgregarCarta)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
