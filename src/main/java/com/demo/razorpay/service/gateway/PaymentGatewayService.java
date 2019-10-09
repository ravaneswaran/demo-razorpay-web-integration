package com.demo.razorpay.service.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.demo.razorpay.models.PaymentTransaction;
import com.demo.razorpay.properties.RazorPayProperties;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

public class PaymentGatewayService {

	public static void createPaymentTransaction(String paymentId) throws RazorpayException {
		//PaymentTransaction paymentTransaction = PaymentGatewayService.fetchPaymentTransaction(paymentId);
	}

	public static List<PaymentTransaction> listPaymentTransactions() throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(),
				RazorPayProperties.getKeySecret());

		JSONObject fetchAllPaymentsRequest = new JSONObject();
		fetchAllPaymentsRequest.put("count", 100);
		fetchAllPaymentsRequest.put("skip", 0);

		List<Payment> payments = razorpayClient.Payments.fetchAll(fetchAllPaymentsRequest);

		List<PaymentTransaction> paymentTransactions = new ArrayList<PaymentTransaction>();
		for(Payment payment : payments){
			PaymentTransaction paymentTransaction = new PaymentTransaction();

			paymentTransaction.setId(""+payment.get("id"));
			paymentTransaction.setEntity(""+payment.get("entity"));
			paymentTransaction.setAmount(Integer.valueOf("" + payment.get("amount")));
			paymentTransaction.setCurrency(""+payment.get("currency"));
			paymentTransaction.setStatus(""+payment.get("status"));
			paymentTransaction.setMethod(""+payment.get("method"));
			paymentTransaction.setOrderId(""+payment.get("order_id"));
			paymentTransaction.setDescription(""+payment.get("description"));
			paymentTransaction.setAmountRefunded(Integer.valueOf("" + payment.get("amount_refunded")));
			paymentTransaction.setRefundStatus(""+payment.get("refund_status"));
			paymentTransaction.setEmail(""+payment.get("email"));
			paymentTransaction.setNotes(payment.get("notes"));
			String fee = ""+payment.get("fee");
			if(null != fee && !"null".equals(fee)){
				paymentTransaction.setFee(Integer.valueOf("" + payment.get("fee")));
			} else {
				paymentTransaction.setFee(0);
			}
			String tax = ""+payment.get("tax");
			if(null != tax && !"null".equals(tax)){
				paymentTransaction.setTax(Integer.valueOf("" + payment.get("tax")));
			} else {
				paymentTransaction.setTax(0);
			}
			paymentTransaction.setErrorCode(""+payment.get("error_code"));
			paymentTransaction.setErrorDescription(""+payment.get("error_description"));
			paymentTransaction.setCreatedAt(((Date)payment.get("created_at")).getTime());

			paymentTransactions.add(paymentTransaction);
		}

		return paymentTransactions;
	}

	public static PaymentTransaction fetchPaymentTransaction(String paymentId) throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(),
				RazorPayProperties.getKeySecret());
		
		Payment payment = razorpayClient.Payments.fetch(paymentId);
		
		PaymentTransaction paymentTransaction = new PaymentTransaction();
		
		paymentTransaction.setId(""+payment.get("id"));
		paymentTransaction.setEntity(""+payment.get("entity"));
		paymentTransaction.setAmount(Integer.valueOf("" + payment.get("amount")));
		paymentTransaction.setCurrency(""+payment.get("currency"));
		paymentTransaction.setStatus(""+payment.get("status"));
		paymentTransaction.setMethod(""+payment.get("method"));
		paymentTransaction.setOrderId(""+payment.get("order_id"));
		paymentTransaction.setDescription(""+payment.get("description"));
		paymentTransaction.setAmountRefunded(Integer.valueOf("" + payment.get("amount_refunded")));
		paymentTransaction.setRefundStatus(""+payment.get("refund_status"));
		paymentTransaction.setEmail(""+payment.get("email"));
		paymentTransaction.setNotes(payment.get("notes"));
		paymentTransaction.setFee(Integer.valueOf("" + payment.get("fee")));
		paymentTransaction.setTax(Integer.valueOf("" + payment.get("tax")));
		paymentTransaction.setErrorCode(""+payment.get("error_code"));
		paymentTransaction.setErrorDescription(""+payment.get("error_description"));
		paymentTransaction.setCreatedAt(((Date)payment.get("created_at")).getTime());
		
		return paymentTransaction;
	}

}
