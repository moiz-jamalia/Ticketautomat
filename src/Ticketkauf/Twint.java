package Ticketkauf;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;

public class Twint extends JFrame {

	private JPanel contentPane;
	public static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Twint frame = new Twint();
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
	public Twint() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\moizj\\eclipse-workspace\\TicketKauf\\Pictures\\Twint.png"));
		setTitle("Twint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); // 100 100 450 300
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnKauf = new JButton("Make purchase");
		btnKauf.setBounds(130, 228, 156, 20);
		contentPane.add(btnKauf);

		Icon Beacon = new ImageIcon(getClass().getResource("/Pictures/Twint_Beacon.png"));
		JLabel labelBeacon = new JLabel(Beacon);
		labelBeacon.setBounds(107, 10, 200, 200);
		contentPane.add(labelBeacon);
		getContentPane().add(labelBeacon);

		btnKauf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Please enter your Name");
				TicketData.SetpassengerName(Twint.name);
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "Please indicate the name", "Hint",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (JOptionPane.showConfirmDialog(null, "Would you like to make the purchase?", "Confirmation",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						try {
							PDFreader.CreatePDF();
						} catch (MalformedURLException e1) {
							System.out.println("Invalid URL");
							e1.printStackTrace();
						} catch (IOException e1) {
							System.out.println("Invalid Output/Input");
							e1.printStackTrace();
						} // erstellt das PDF
						System.out.println("create PDF");
					} else {
						System.exit(0); // schliesst dann das Fenster
						System.out.println("close window");
					}
				}
			}
		});
	}
}