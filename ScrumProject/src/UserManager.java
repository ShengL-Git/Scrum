import models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserManager {
    private final HashMap<String, Customer> userHashMap;

    public UserManager() {
        userHashMap = new HashMap<>();
    }

    public boolean addUser(Customer customer) {
        return userHashMap.putIfAbsent(customer.getDni(), customer) == null;
    }

    public boolean removeUser(Customer customer) {
        return userHashMap.remove(customer.getDni(), customer);
    }

    public boolean modifyUser(Customer customer, String firstName, String lastName) {
        if (!userHashMap.containsValue(customer)) return false;
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return true;
    }

    public Customer searchUser(String dni) {
        return userHashMap.get(dni);
    }

    public List<Customer> userList() {
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