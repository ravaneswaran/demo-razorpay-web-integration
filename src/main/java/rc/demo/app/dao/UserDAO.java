package rc.demo.app.dao;

import javax.persistence.Query;

import rc.demo.app.models.User;

import java.util.List;

public class UserDAO extends AbstractDAO<User>{

    public UserDAO() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
	public List<User> findAll(){
        Query query = this.getEntityManager().createQuery("SELECT u FROM User AS u");
        return  query.getResultList();
    }

    @SuppressWarnings("unchecked")
	public User findBy(String emailId, String password){
        Query query = this.getEntityManager().createQuery("SELECT u FROM User AS u WHERE u.emailId = :emailId AND u.password = :password");
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        if(!users.isEmpty()){
            return (User)query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
	public User findBy(String emailId){
        Query query = this.getEntityManager().createQuery("SELECT u FROM User AS u WHERE u.emailId = :emailId");
        query.setParameter("emailId", emailId);

        List<User> users = query.getResultList();

        if(!users.isEmpty()){
            return (User)query.getResultList().get(0);
        } else {
            return null;
        }
    }

    public User findById(String id){
        return this.getEntityManager().find(User.class, id);
    }

    public int deleteById(String id){
        User user = this.findById(id);
        if(null != user) {
            this.delete(user);
            return 0;
        } else {
            throw new IllegalArgumentException(String.format("Null entity found for id '%s'", id));
        }
    }
}
