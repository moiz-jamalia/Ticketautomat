package Ticketkauf;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

public class Automat extends JFrame {

	private JPanel contentPane;
	private JTextField txt_von;
	private JTextField txt_Nach;
	private JTextField txt_via;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Automat frame = new Automat();
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
	public Automat() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\moizj\\eclipse-workspace\\TicketKauf\\Pictures\\SBB.png"));
		setTitle("Ticketautomat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_ContentPane = new SpringLayout();
		contentPane.setLayout(sl_ContentPane);

		JLabel lbVon = new JLabel("From");
		sl_ContentPane.putConstraint(SpringLayout.NORTH, lbVon, 30, SpringLayout.NORTH, contentPane);
		sl_ContentPane.putConstraint(SpringLayout.WEST, lbVon, 20, SpringLayout.WEST, contentPane);
		lbVon.setBounds(10, 29, 58, 13);
		contentPane.add(lbVon);

		txt_von = new JTextField();
		sl_ContentPane.putConstraint(SpringLayout.NORTH, txt_von, 6, SpringLayout.SOUTH, lbVon);
		sl_ContentPane.putConstraint(SpringLayout.WEST, txt_von, 0, SpringLayout.WEST, lbVon);
		sl_ContentPane.putConstraint(SpringLayout.EAST, txt_von, 200, SpringLayout.WEST, lbVon);
		txt_von.setBounds(10, 41, 185, 19);
		contentPane.add(txt_von);
		txt_von.setColumns(10);

		JLabel lbNach = new JLabel("To");
		sl_ContentPane.putConstraint(SpringLayout.NORTH, lbNach, 1, SpringLayout.SOUTH, txt_von);
		sl_ContentPane.putConstraint(SpringLayout.WEST, lbNach, 0, SpringLayout.WEST, lbVon);
		lbNach.setBounds(10, 85, 45, 13);
		contentPane.add(lbNach);

		txt_Nach = new JTextField();
		sl_ContentPane.putConstraint(SpringLayout.NORTH, txt_Nach, 6, SpringLayout.SOUTH, lbNach);
		sl_ContentPane.putConstraint(SpringLayout.WEST, txt_Nach, 0, SpringLayout.WEST, lbVon);
		sl_ContentPane.putConstraint(SpringLayout.EAST, txt_Nach, 0, SpringLayout.EAST, txt_von);
		txt_Nach.setBounds(10, 99, 185, 19);
		contentPane.add(txt_Nach);
		txt_Nach.setColumns(10);

		JLabel lbVia = new JLabel("Via");
		sl_ContentPane.putConstraint(SpringLayout.NORTH, lbVia, 1, SpringLayout.SOUTH, txt_Nach);
		sl_ContentPane.putConstraint(SpringLayout.WEST, lbVia, 0, SpringLayout.WEST, lbVon);
		lbVia.setBounds(10, 139, 45, 13);
		contentPane.add(lbVia);

		txt_via = new JTextField();
		sl_ContentPane.putConstraint(SpringLayout.NORTH, txt_via, 5, SpringLayout.SOUTH, lbVia);
		sl_ContentPane.putConstraint(SpringLayout.WEST, txt_via, 20, SpringLayout.WEST, contentPane);
		sl_ContentPane.putConstraint(SpringLayout.EAST, txt_via, 0, SpringLayout.EAST, txt_von);
		txt_via.setBounds(10, 151, 185, 19);
		contentPane.add(txt_via);
		txt_via.setColumns(10);

		JButton btn_Kauf = new JButton("Buy Ticket");
		sl_ContentPane.putConstraint(SpringLayout.NORTH, btn_Kauf, 48, SpringLayout.NORTH, contentPane);
		sl_ContentPane.putConstraint(SpringLayout.WEST, btn_Kauf, -139, SpringLayout.EAST, contentPane);
		sl_ContentPane.putConstraint(SpringLayout.SOUTH, btn_Kauf, -141, SpringLayout.SOUTH, contentPane);
		sl_ContentPane.putConstraint(SpringLayout.EAST, btn_Kauf, -10, SpringLayout.EAST, contentPane);

		btn_Kauf.setBounds(270, 40, 135, 66);
		contentPane.add(btn_Kauf);

		JComboBox comboBox_Zahlung = new JComboBox();
		sl_ContentPane.putConstraint(SpringLayout.WEST, comboBox_Zahlung, 0, SpringLayout.WEST, lbVon);
		sl_ContentPane.putConstraint(SpringLayout.EAST, comboBox_Zahlung, 0, SpringLayout.EAST, txt_von);
		comboBox_Zahlung.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_Zahlung.addItem("-Please select-");
		comboBox_Zahlung.addItem("Twint");
		comboBox_Zahlung.addItem("Credit/Debit Card");
		comboBox_Zahlung.setBounds(10, 196, 185, 21);
		contentPane.add(comboBox_Zahlung);

		JLabel lb_Zahlung = new JLabel("Payment Method");
		sl_ContentPane.putConstraint(SpringLayout.NORTH, lb_Zahlung, 1, SpringLayout.SOUTH, txt_via);
		sl_ContentPane.putConstraint(SpringLayout.NORTH, comboBox_Zahlung, 6, SpringLayout.SOUTH, lb_Zahlung);
		sl_ContentPane.putConstraint(SpringLayout.WEST, lb_Zahlung, 0, SpringLayout.WEST, lbVon);
		lb_Zahlung.setBounds(10, 180, 120, 13);
		contentPane.add(lb_Zahlung);

		btn_Kauf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ortschaft.SetVOrt(txt_von.getText());
				Ortschaft.SetNOrt(txt_Nach.getText());
				if (txt_via.getText().isEmpty() == true) {
					Ortschaft.SetViaOrt("");
				} else {
					Ortschaft.SetViaOrt(txt_via.getText());
				}
				try {
					Main.ConnectionDatabase();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println(
						Arrays.toString(Main.selectCity(txt_von.getText(), txt_Nach.getText(), txt_via.getText())));

				int getIndex = comboBox_Zahlung.getSelectedIndex();
				Kreditkarte Kreditkarte1 = new Kreditkarte();
				Twint Twint1 = new Twint();
				if (getIndex == 2) {
					if (txt_von.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your point of departure.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (txt_Nach.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your destination.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Kreditkarte1.setVisible(true);
					}
				} else if (getIndex == 1) {
					if (txt_von.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your point of departure.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (txt_Nach.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your destination.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Twint1.setVisible(true);
					}
				} else if (getIndex == 0) {
					if (txt_von.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your point of departure.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (txt_Nach.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please indicate your destination.", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Please select a payment option", "Hint",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				TicketData.SetPaymentMethod(comboBox_Zahlung.getSelectedItem().toString());
				Grid_price.calcPrice();
			}
		});
	}
}