package insuranceTest.core;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private static UserFactory INCTANCE = null;

    private User user;
    private Map<String, User> userList;

    private UserFactory() {
        this.userList = new HashMap<String, User>();
    }


    public static UserFactory getInstance() {
        if (INCTANCE == null) {
            INCTANCE = new UserFactory();
        }
        return INCTANCE;
    }

    public void createUserRgs(String id) {
        user = User.getRandomUserForRgs();
        userList.put(id, user);
    }

    public void createUserSberInsured(String id) {
        user = User.getRandomInsuredUserForSber();
        userList.put(id, user);
    }

    public void createUserSberInsurant(String id) {
        user = User.getRandomInsurantUserForSber();
        userList.put(id, user);
    }

    public User getUser(String id) {
        for (String s : userList.keySet()) {
            if (s.equals(id)) {
                return userList.get(s);
            }
        }
        return null;
    }
}
