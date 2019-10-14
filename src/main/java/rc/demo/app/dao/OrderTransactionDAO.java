package rc.demo.app.dao;

import javax.persistence.Query;

import rc.demo.app.models.OrderTransaction;

import java.util.List;

public class OrderTransactionDAO extends AbstractDAO<OrderTransaction>{

    public OrderTransactionDAO() {
        super(OrderTransaction.class);
    }

    @SuppressWarnings("unchecked")
	public List<OrderTransaction> list(){
        Query query = this.getEntityManager().createQuery("SELECT ot FROM OrderTransaction AS ot");
        return query.getResultList();
    }

}
