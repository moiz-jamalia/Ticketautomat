package Ticketkauf;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFreader {
	public static String VOrt = "";
	public static String NOrt = "";
	public static String ViaOrt = "";
	public static String PassengerName = "";
	public static String Date = "";
	public static double Price = 0.0;
	public static String FILE = "C:\\Users\\moizj\\OneDrive\\Desktop\\Ticket.pdf";
	public static String URL = "C:\\Users\\moizj\\eclipse-workspace\\TicketKauf\\Pictures\\SBB.png";
	public static String PaymentMethod = "";
	public static String CreditDebitCard = "";

	public static void CreatePDF() throws MalformedURLException, IOException {

		VOrt = Ortschaft.GetVOrt();
		NOrt = Ortschaft.GetNOrt();
		ViaOrt = Ortschaft.GetViaOrt();
		PassengerName = TicketData.GetpassengerName();
		Date = TicketData.GetDate();
		Price = Grid_price.GetPrice();
		PaymentMethod = TicketData.GetPaymentMethod();
		CreditDebitCard = TicketData.GetCreditDebitCard();

		Document ticket = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(ticket, new FileOutputStream(FILE));
			ticket.open();
			Image logo = Image.getInstance(URL);
			logo.setAbsolutePosition(100, 500);
			logo.scaleAbsolute(200, 200);
			ticket.add(logo);

			if (PassengerName != "") {
				ticket.add(new Paragraph("this Ticket belongs to: " + PassengerName));
			}

			ticket.add(new Paragraph("From: " + VOrt));
			ticket.add(new Paragraph("To: " + NOrt));

			if (ViaOrt != "") {
				ticket.add(new Paragraph("Via: " + ViaOrt));
			}

			ticket.add(new Paragraph("Payment Method: " + PaymentMethod));

			if (CreditDebitCard != "" && CreditDebitCard != null) {
				ticket.add(new Paragraph("Paid with: " + CreditDebitCard));
			}

			ticket.add(new Paragraph("Price: " + String.format("%1.2f", Price) + " CHF"));
			ticket.add(new Paragraph("this Ticket is Valid until: " + Date));
			ticket.close();
			writer.close();
			System.out.println("document is been created");
		} catch (DocumentException e) {
			System.out.println("document can't be created");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("document couldn't be found");
			e.printStackTrace();
		}
	}
}