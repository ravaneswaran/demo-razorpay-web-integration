package rc.demo.app.service.local;

import rc.demo.app.dao.OrderTransactionDAO;
import rc.demo.app.models.OrderTransaction;

import java.util.List;

public class OrderTransactionLocalService {

    private static final OrderTransactionDAO ORDER_TRANSACTION_DAO = new OrderTransactionDAO();

    public static OrderTransaction get(String orderTransactionId){
        return ORDER_TRANSACTION_DAO.findBy(orderTransactionId);
    }

    public static OrderTransaction save(OrderTransaction orderTransaction){
        return ORDER_TRANSACTION_DAO.save(orderTransaction);
    }

    public static OrderTransaction update(OrderTransaction orderTransaction){
        return ORDER_TRANSACTION_DAO.update(orderTransaction);
    }

    public static OrderTransaction delete(OrderTransaction orderTransaction){
        return ORDER_TRANSACTION_DAO.delete(orderTransaction);
    }

    public static List<OrderTransaction> list(){
        return ORDER_TRANSACTION_DAO.list();
    }
}
