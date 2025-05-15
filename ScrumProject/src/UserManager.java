import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.*;


public class UserManager {
    private final HashMap<String, User> userHashMap;

    public UserManager() {
        userHashMap = new HashMap<>();
    }

    public boolean addUser(User user) {
        return userHashMap.putIfAbsent(user.getDni(), user) == null;
    }

    public boolean removeUser(User user) {
        return userHashMap.remove(user.getDni(), user);
    }

    public boolean modifyUser(User user, String firstName, String lastName) {
        if (!userHashMap.containsValue(user)) return false;
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return true;
    }

    public User searchUser(String dni) {
        return userHashMap.get(dni);
    }

    public List<User> userList() {
        return new ArrayList<>(userHashMap.values());
    }

    //TODO
//    public Set<Object> showPurchaseByDay(){
//        return userHashMap.values().stream()
//                .filter(n -> n.getTickets().getDate().equals(LocalDate.now()))
//                .collect(Collectors.toSet());
//    }
//    public Set<Object> showPurchaseByWeek(){
//        return null;
//    }
//    public Set<Object> showPurchaseByMonth(){
//        return null;
//    }

    @Override
    public String toString() {
        return "UserManager{" +
                "userHashMap=" + userHashMap +
                '}';
    }
}