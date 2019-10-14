package rc.demo.app.dao;

import javax.persistence.Query;

import rc.demo.app.models.Order;

import java.util.List;

public class OrderDAO extends AbstractDAO<Order>{

    public OrderDAO() {
        super(Order.class);
    }

    public Order findById(String id){
        return this.getEntityManager().find(Order.class, id);
    }

    @SuppressWarnings("unchecked")
	public List<Order> findByUserId(String userId){
        Query query = this.getEntityManager().createQuery("SELECT o FROM Order AS o WHERE o.user.id = :userId");
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}
