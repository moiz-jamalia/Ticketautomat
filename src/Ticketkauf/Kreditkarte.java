package Ticketkauf;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Kreditkarte extends JFrame {

	private JPanel contentPane;
	private JTextField textField_KartenInhaberIn;
	private JTextField textField_KartenNr;
	private JTextField textField_CVV;
	private boolean error = false;
	public static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kreditkarte frame = new Kreditkarte();
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
	public Kreditkarte() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\moizj\\eclipse-workspace\\TicketKauf\\Pictures\\Credit_Card-Icon.png"));
		setTitle("Kredit-/Lastschrift");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JButton btnNewButton = new JButton("Confirmation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -53, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 145, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -163, SpringLayout.EAST, contentPane);
		btnNewButton.setBounds(147, 197, 126, 56);
		contentPane.add(btnNewButton);

		textField_KartenInhaberIn = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_KartenInhaberIn, 111, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_KartenInhaberIn, -140, SpringLayout.EAST,
				contentPane);
		textField_KartenInhaberIn.setBounds(82, 71, 240, 20);
		contentPane.add(textField_KartenInhaberIn);
		textField_KartenInhaberIn.setColumns(10);

		JLabel lb_kartenInhaberIn = new JLabel("cardholder");
		sl_contentPane.putConstraint(SpringLayout.WEST, lb_kartenInhaberIn, 0, SpringLayout.WEST,
				textField_KartenInhaberIn);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lb_kartenInhaberIn, -6, SpringLayout.NORTH,
				textField_KartenInhaberIn);
		lb_kartenInhaberIn.setBounds(82, 58, 107, 13);
		contentPane.add(lb_kartenInhaberIn);

		textField_KartenNr = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_KartenNr, 0, SpringLayout.WEST,
				textField_KartenInhaberIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_KartenNr, 0, SpringLayout.EAST,
				textField_KartenInhaberIn);
		textField_KartenNr.setColumns(10);
		textField_KartenNr.setBounds(82, 112, 240, 20);
		contentPane.add(textField_KartenNr);

		JLabel lb_KartenNr = new JLabel("card Nr.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_KartenNr, 6, SpringLayout.SOUTH, lb_KartenNr);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lb_KartenNr, 6, SpringLayout.SOUTH, textField_KartenInhaberIn);
		sl_contentPane.putConstraint(SpringLayout.WEST, lb_KartenNr, 0, SpringLayout.WEST, textField_KartenInhaberIn);
		lb_KartenNr.setBounds(82, 99, 89, 13);
		contentPane.add(lb_KartenNr);

		JLabel lb_Karte = new JLabel("card");
		lb_Karte.setBounds(82, 15, 57, 13);
		contentPane.add(lb_Karte);

		JComboBox comboBox_Karten = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_KartenInhaberIn, 25, SpringLayout.SOUTH,
				comboBox_Karten);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_Karten, 29, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lb_Karte, 0, SpringLayout.WEST, comboBox_Karten);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lb_Karte, -6, SpringLayout.NORTH, comboBox_Karten);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_Karten, -34, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_Karten, 141, SpringLayout.WEST, btnNewButton);
		comboBox_Karten.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_Karten.addItem("-Please select-");
		comboBox_Karten.addItem("Visa");
		comboBox_Karten.addItem("Mastercard");
		comboBox_Karten.addItem("Postfinance");
		comboBox_Karten.setBounds(82, 27, 240, 21);
		contentPane.add(comboBox_Karten);

		JLabel lblNewLabel_CVV = new JLabel("CVV");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_CVV, 6, SpringLayout.SOUTH, textField_KartenNr);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_CVV, 0, SpringLayout.WEST,
				textField_KartenInhaberIn);
		lblNewLabel_CVV.setBounds(82, 142, 89, 13);
		contentPane.add(lblNewLabel_CVV);

		textField_CVV = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_CVV, 23, SpringLayout.SOUTH, textField_KartenNr);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_CVV, 0, SpringLayout.WEST, textField_KartenInhaberIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_CVV, -140, SpringLayout.EAST, contentPane);
		textField_CVV.setColumns(10);
		textField_CVV.setBounds(82, 155, 45, 20);
		contentPane.add(textField_CVV);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.ConnectionDatabase();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (JOptionPane.showConfirmDialog(null, "Would you like to make the purchase?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					Main.insert(comboBox_Karten.getSelectedIndex(), textField_KartenInhaberIn.getText(),
							textField_KartenNr.getText(), textField_CVV.getText());

					int getIndex = comboBox_Karten.getSelectedIndex();

					if (textField_KartenInhaberIn.getText().isEmpty()) {
						try {
							int cvv = Integer.parseInt(textField_CVV.getText());
							int KartenNR = Integer.parseInt(textField_KartenNr.getText());
						} catch (NumberFormatException e2) {
							error = true;
							JOptionPane.showMessageDialog(null, "Please indicate holder", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
						}
						try {
							String KartenInhaber = textField_KartenInhaberIn.getText();
						} catch (Exception e2) {
							error = true;
							JOptionPane.showMessageDialog(null, "Please enter letters only", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else if (textField_KartenNr.getText().isEmpty()) {
						try {
							int KartenNR = Integer.parseInt(textField_KartenNr.getText());
						} catch (NumberFormatException e2) {
							error = true;
							JOptionPane.showMessageDialog(null, "Please enter the card number", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else if (textField_CVV.getText().isEmpty()) {
						try {
							int cvv = Integer.parseInt(textField_CVV.getText());
						} catch (NumberFormatException e2) {
							error = true;
							JOptionPane.showMessageDialog(null, "Please enter the CVV", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try {
							int cvv = Integer.parseInt(textField_CVV.getText());
							int KartenNR = Integer.parseInt(textField_KartenNr.getText());
						} catch (NumberFormatException e2) {
							error = true;
							JOptionPane.showMessageDialog(null, "please enter numbers only", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					if (!error) {
						String karteanbieter = comboBox_Karten.getSelectedItem().toString();
						switch (getIndex) {
						case 0:
							JOptionPane.showMessageDialog(null, "Please select a card", "Hint",
									JOptionPane.INFORMATION_MESSAGE);
							break;
						case 1:
							System.out.println(karteanbieter);
							break;
						case 2:
							System.out.println(karteanbieter);
							break;
						case 3:
							System.out.println(karteanbieter);
							break;
						}
					}

					name = textField_KartenInhaberIn.getText();
					TicketData.SetCreditDebitCard(comboBox_Karten.getSelectedItem().toString());

					if (name.equals(textField_KartenInhaberIn.getText())) {
						TicketData.SetpassengerName(name);
					}

					try {
						PDFreader.CreatePDF();
					} catch (MalformedURLException e1) {
						System.out.println("Invalid URL");
						e1.printStackTrace();
					} catch (IOException e1) {
						System.out.println("Invalid Input/Output");
						e1.printStackTrace();
					} // PDF wird erstellt
					System.out.println("create PDF");
				} else {
					try {
						Main.delete();
					} catch (SQLDataException e1) {
						System.out.println("Data can't be deleted");
						e1.printStackTrace();
					}
					System.exit(0); // schliesst dann das Fenster
					System.out.println("close Window");
				}
			}
		});
	}
}