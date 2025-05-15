import java.util.HashSet;
import java.util.Set;

public class User {
    private String firstName, lastName, dni;
    private Set<Object> tickets;

    public User(String firstName, String lastName, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
/*
        if (dni.matches("\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]")) {
            this.dni = dni;
        }
*/
        this.dni = dni;
        tickets = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Object> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Object> tickets) {
        this.tickets = tickets;
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(dni, user.dni);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(dni);
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}