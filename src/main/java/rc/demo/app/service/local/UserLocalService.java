package rc.demo.app.service.local;

import rc.demo.app.dao.UserDAO;
import rc.demo.app.models.User;

import java.util.List;
import java.util.UUID;

public class UserLocalService {

    private static final UserDAO USER_DAO = new UserDAO();

    public static int registerUser(String firstName, String middleInitial, String lastName, String emailId, String password){

        User testUser = fetchUserBy(emailId);

        if(null != testUser){
            return -1;
        }

        String id = UUID.randomUUID().toString();

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleInitial(middleInitial);
        user.setEmailId(emailId);
        user.setPassword(password);

        USER_DAO.save(user);

        return 0;
    }

    public static int registerUser(User user){
        USER_DAO.save(user);
        return 0;
    }

    public static User fetchUserBy(String emailId, String password){
        return USER_DAO.findBy(emailId, password);
    }

    public static User fetchUserBy(String emailId){
        return USER_DAO.findBy(emailId);
    }

    public static int deRegisterUserById(String id) {
        return USER_DAO.deleteById(id);
    }

    public static List<User> fetchAllUsers(){
        return USER_DAO.findAll();
    }

    public static boolean hasUsers() {
        return !fetchAllUsers().isEmpty();
    }

	public static void updateUser(User user) {
		USER_DAO.update(user);
	}
}
