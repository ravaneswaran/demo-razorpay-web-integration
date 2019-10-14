package rc.demo.app.service.local;

import rc.demo.app.dao.PaymentTransactionDAO;
import rc.demo.app.models.PaymentTransaction;

import java.util.List;

public class PaymentTransactionLocalService {

    private static final PaymentTransactionDAO PAYMENT_TRANSACTION_DAO = new PaymentTransactionDAO();

    public static PaymentTransaction fetch(String paymentTransactionId){
        return PAYMENT_TRANSACTION_DAO.findBy(paymentTransactionId);
    }

    public static PaymentTransaction save(PaymentTransaction paymentTransaction){
        return PAYMENT_TRANSACTION_DAO.save(paymentTransaction);
    }

    public static PaymentTransaction update(PaymentTransaction paymentTransaction){
        return PAYMENT_TRANSACTION_DAO.update(paymentTransaction);
    }

    public static PaymentTransaction delete(PaymentTransaction paymentTransaction){
        return PAYMENT_TRANSACTION_DAO.delete(paymentTransaction);
    }

    public static List<PaymentTransaction> list(){
        return PAYMENT_TRANSACTION_DAO.list();
    }
}
