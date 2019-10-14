package rc.demo.app.dao;

import javax.persistence.Query;

import rc.demo.app.models.Product;

import java.util.List;

public class ProductDAO extends AbstractDAO<Product>{

    public ProductDAO() {
        super(Product.class);
    }

    @SuppressWarnings("unchecked")
	public List<Product> findAll(){
        Query query = this.getEntityManager().createQuery("SELECT p FROM Product AS p ORDER BY p.rowId");
        return  query.getResultList();
    }

    public Product findById(String id){
        return this.getEntityManager().find(Product.class, id);
    }

    public int deleteById(String id){
        Product product = this.findById(id);
        if(null != product){
            this.delete(product);
            return 0;
        } else {
            throw new IllegalArgumentException(String.format("Null entity found for id '%s'", id));
        }
    }
}
