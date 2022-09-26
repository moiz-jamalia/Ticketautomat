package Ticketkauf;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketData {

	public static String PaymentMethod;
	public static String PassengerName;
	public static String CreditDebitCard;

	public static void SetPaymentMethod(String paymentMethod) {
		TicketData.PaymentMethod = paymentMethod;
	}

	public static String GetPaymentMethod() {
		return PaymentMethod;
	}

	public static void SetpassengerName(String passengerName) {
		TicketData.PassengerName = passengerName;
	}

	public static String GetpassengerName() {
		return PassengerName;
	}

	public static void SetCreditDebitCard(String CreditDebitCard) {
		TicketData.CreditDebitCard = CreditDebitCard;
	}

	public static String GetCreditDebitCard() {
		return CreditDebitCard;
	}

	public static String GetDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(new Date());
	}
}