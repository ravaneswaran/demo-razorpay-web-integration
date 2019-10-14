package rc.demo.app.service.gateway;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import rc.demo.app.models.OrderTransaction;
import rc.demo.app.properties.ApplicationProperties;

public class OrderGatewayService {

	public static OrderTransaction createNewOrderTransaction(long amount, String currency, int receiptNumber,
			int paymentCapture) throws IOException, RazorpayException, JAXBException {

		RazorpayClient razorpayClient = new RazorpayClient(ApplicationProperties.getKeyId(),
				ApplicationProperties.getKeySecret());

		JSONObject orderCreateRequest = new JSONObject();

		orderCreateRequest.put("amount", amount);
		orderCreateRequest.put("currency", currency);
		orderCreateRequest.put("receipt", String.format("Receipt #%s", receiptNumber));
		orderCreateRequest.put("payment_capture", paymentCapture);

		Order newOrder = razorpayClient.Orders.create(orderCreateRequest);

		OrderTransaction razorpayOrder = new OrderTransaction();
		razorpayOrder.setAmount(Integer.valueOf("" + newOrder.get("amount")));
		razorpayOrder.setAmountPaid(Integer.valueOf("" + newOrder.get("amount_paid")));
		razorpayOrder.setNotes(newOrder.get("notes"));
		razorpayOrder.setCreatedAt(((Date) newOrder.get("created_at")).getTime());
		razorpayOrder.setAmountDue(Integer.valueOf("" + newOrder.get("amount_due")));
		razorpayOrder.setCurrency(String.valueOf(newOrder.get("currency")));
		razorpayOrder.setReceipt(String.valueOf(newOrder.get("receipt")));
		razorpayOrder.setId(String.valueOf(newOrder.get("id")));
		razorpayOrder.setEntity(String.valueOf(newOrder.get("entity")));
		razorpayOrder.setOfferId(newOrder.get("offer_id"));
		razorpayOrder.setStatus(String.valueOf(newOrder.get("status")));
		razorpayOrder.setAmountDue(Integer.valueOf("" + newOrder.get("attempts")));

		return razorpayOrder;
	}

	public static OrderTransaction fetchOrderTransaction(String orderId) throws RazorpayException {

		RazorpayClient razorpayClient = new RazorpayClient(ApplicationProperties.getKeyId(),
				ApplicationProperties.getKeySecret());

		Order oldOrder = razorpayClient.Orders.fetch(orderId);

		OrderTransaction razorpayOrder = new OrderTransaction();
		razorpayOrder.setAmount(Integer.valueOf("" + oldOrder.get("amount")));
		razorpayOrder.setAmountPaid(Integer.valueOf("" + oldOrder.get("amount_paid")));
		razorpayOrder.setNotes(oldOrder.get("notes"));
		razorpayOrder.setCreatedAt(((Date) oldOrder.get("created_at")).getTime());
		razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("amount_due")));
		razorpayOrder.setCurrency(String.valueOf(oldOrder.get("currency")));
		razorpayOrder.setReceipt(String.valueOf(oldOrder.get("receipt")));
		razorpayOrder.setId(String.valueOf(oldOrder.get("id")));
		razorpayOrder.setEntity(String.valueOf(oldOrder.get("entity")));
		razorpayOrder.setOfferId(oldOrder.get("offer_id"));
		razorpayOrder.setStatus(String.valueOf(oldOrder.get("status")));
		razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("attempts")));

		return razorpayOrder;
	}

	public static OrderTransaction cancelOrder(String orderId) throws RazorpayException {

		RazorpayClient razorpayClient = new RazorpayClient(ApplicationProperties.getKeyId(),
				ApplicationProperties.getKeySecret());

		Order oldOrder = razorpayClient.Orders.fetch(orderId);

		OrderTransaction razorpayOrder = new OrderTransaction();
		razorpayOrder.setAmount(Integer.valueOf("" + oldOrder.get("amount")));
		razorpayOrder.setAmountPaid(Integer.valueOf("" + oldOrder.get("amount_paid")));
		razorpayOrder.setNotes(oldOrder.get("notes"));
		razorpayOrder.setCreatedAt(((Date) oldOrder.get("created_at")).getTime());
		razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("amount_due")));
		razorpayOrder.setCurrency(String.valueOf(oldOrder.get("currency")));
		razorpayOrder.setReceipt(String.valueOf(oldOrder.get("receipt")));
		razorpayOrder.setId(String.valueOf(oldOrder.get("id")));
		razorpayOrder.setEntity(String.valueOf(oldOrder.get("entity")));
		razorpayOrder.setOfferId(oldOrder.get("offer_id"));
		razorpayOrder.setStatus(String.valueOf(oldOrder.get("status")));
		razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("attempts")));

		return razorpayOrder;
	}

	public static List<OrderTransaction> listOrderTransactions() throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(ApplicationProperties.getKeyId(),
				ApplicationProperties.getKeySecret());

		List<Order> orders = razorpayClient.Orders.fetchAll();

		List<OrderTransaction> orderTransactions = new ArrayList<OrderTransaction>();
		for (Order order : orders) {
			OrderTransaction orderTransaction = new OrderTransaction();

			orderTransaction.setAmount(Integer.valueOf("" + order.get("amount")));
			orderTransaction.setAmountPaid(Integer.valueOf("" + order.get("amount_paid")));
			orderTransaction.setNotes(order.get("notes"));
			orderTransaction.setCreatedAt(((Date) order.get("created_at")).getTime());
			orderTransaction.setAmountDue(Integer.valueOf("" + order.get("amount_due")));
			orderTransaction.setCurrency(String.valueOf(order.get("currency")));
			orderTransaction.setReceipt(String.valueOf(order.get("receipt")));
			orderTransaction.setId(String.valueOf(order.get("id")));
			orderTransaction.setEntity(String.valueOf(order.get("entity")));
			orderTransaction.setOfferId(order.get("offer_id"));
			orderTransaction.setStatus(String.valueOf(order.get("status")));
			orderTransaction.setAmountDue(Integer.valueOf("" + order.get("attempts")));

			orderTransactions.add(orderTransaction);
		}

		return orderTransactions;
	}
}
