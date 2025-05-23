
import dao.CustomerDao;
import dao.Dao;
import dao.ProductDao;
import dao.TicketDao;
import models.Product;
import models.Customer;
import models.Ticket;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Menu principal gestio supermercat (tickets):");
            System.out.println();
            System.out.println("1. Gestio d'usuaris");
            System.out.println("2. Gestio de productes");
            System.out.println("3. Gestio de tickets");
            System.out.println("4. Sortir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    usersManagement();
                    break;
                case 2:
                    productManagement();
                    break;
                case 3:
                    ticketsManagement();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opcio no trobada");
                    break;
            }
        }
    }

    // MENUS D'USUARIS, PRODUCTES I TICKETS

    public static void usersManagement() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Gestio d'usuaris:");
            System.out.println();
            System.out.println("1. Afegir usuari");
            System.out.println("2. Eliminar usuari");
            System.out.println("3. Modificar usuari");
            System.out.println("4. Buscar usuari");
            System.out.println("5. Tornar enrere");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createUserUI();
                    break;
                case 2:
                    removeUserUI();
                    break;
                case 3:
                    modifyUserUI();
                    break;
                case 4:
                    searchUserUI();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opcio no trobada");
                    break;
            }
        }
    }

    public static void productManagement() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Gestio de productes:");
            System.out.println();
            System.out.println("1. Afegir produte");
            System.out.println("2. Eliminar producte");
            System.out.println("3. Modificar preu");
            System.out.println("4. Veure tots els productes");
            System.out.println("5. Tornar enrere");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProductUI();
                    break;
                case 2:
                    deleteProductUI();
                    break;
                case 3:
                    modifyPriceUI();
                    break;
                case 4:
                    getProductsUI();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opcio no trobada");
                    break;
            }
        }
    }

    public static void ticketsManagement() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Gestio de tickets:");
            System.out.println();
            System.out.println("1. Afegir ticket");
            System.out.println("2. Eliminar ticket");
            System.out.println("3. Veure ticket per ID");
            System.out.println("4. Veure tots els tickets");
            System.out.println("5. Tornar enrere");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addTicketUI();
                    break;
                case 2:
                    deleteTicketByIdUI();
                    break;
                case 3:
                    checkTicketByIdUI();
                    break;
                case 4:
                    checkAllTicketsUI();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opcio no trobada");
                    break;
            }
        }
    }

// UI DE LES FUNCIONS D'USUARIS

    public static void createUserUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Customer> customerDao = new CustomerDao();

        System.out.print("Posa el teu nom: ");
        String firstName = scanner.next();
        System.out.print("Posa el teu cognom: ");
        String lastName = scanner.next();
        System.out.print("Posa el teu dni: ");
        String dni = scanner.next();

        Customer customer = new Customer(0, firstName, lastName, dni);
        //userManager.addUser(customer);
        customerDao.create(customer);
    }
    public static void removeUserUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Customer> customerDao = new CustomerDao();
        //System.out.print("Posa el DNI de l'usuari: ");
        //String dni = scanner.next();

        System.out.println("Posa la ID de l'usuari");
        int id = scanner.nextInt();

        customerDao.delete(id);

        //if (customer.getDni().equals(dni)) {
        //    userManager.removeUser(customer);
        //}
    }
    public static void modifyUserUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Customer> customerDao = new CustomerDao();

        System.out.print("Posa la ID de l'usuari: ");
        int id = scanner.nextInt();
        System.out.println("Posa el nou nom d'usuari: ");
        String newFirstName = scanner.next();
        System.out.print("Posa el nou cognom d'usuari: ");
        String newLastName = scanner.next();
        System.out.println("Posa el nou DNI");
        String newDni = scanner.next();

        Customer customer = new Customer(id, newFirstName, newLastName, newDni);
        customerDao.modify(id, customer);
    }
    public static void searchUserUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Customer> customerDao = new CustomerDao();

        //System.out.print("Posa el DNI de l'usuari: ");
        //String dni = scanner.next();

        System.out.print("Posa la ID de l'usuari: ");
        int id = scanner.nextInt();

        //System.out.println(userManager.searchUser(dni));

        System.out.println(customerDao.read(id));
    }

// UI DE LES FUNCIONS DE PRODUCTES

    public static void addProductUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Product> productDao = new ProductDao();

        System.out.print("Posa el ID del producte a afegir: ");
        int id = scanner.nextInt();
        System.out.println("Posa el nombre del producte");
        String pName = scanner.next();
        System.out.print("Posa el preu del producte: ");
        double pPrice = scanner.nextDouble();

        Product product = new Product(id, pName, pPrice);
        //gestioProducts.addProduct(product);

        productDao.create(product);
    }
    public static void deleteProductUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Product> productDao = new ProductDao();

        //System.out.print("Posa el nom del producte que vols eliminar: ");
        //String nameProduct = scanner.next();

        System.out.println("Posa la ID del producte a eliminar: ");
        int id = scanner.nextInt();

        //gestioProducts.deleteProduct(nameProduct);

        productDao.delete(id);
    }
    public static void modifyPriceUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Product> productDao = new ProductDao();

        System.out.print("Posa el id del producte a modificar el preu: ");
        int id = scanner.nextInt();
        System.out.print("Posa el nou nom que vols que tingui el producte: ");
        String newName = scanner.next();
        System.out.println("Posa el nou preu del producte: ");
        double newPrice = scanner.nextDouble();

        Product product = new Product(id, newName, newPrice);

        productDao.modify(id, product);
    }
    public static void getProductsUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Product> productDao = new ProductDao();

        //System.out.println(gestioProducts.getProducts());

        System.out.println(productDao.readAll());
    }

// UI DE LES FUNCIONS DE TICKETS

    public static void addTicketUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Ticket> ticketDao = new TicketDao();
        Dao<Customer> customerDao = new CustomerDao();

        ArrayList<Product> products = new ArrayList<>();
        System.out.println("(TEMPORAL) Añade el precio total de la compra");
        int totalPrice = scanner.nextInt();

        System.out.println("Introduce ID del cliente: ");
        int idCustomer = scanner.nextInt();
        Customer customer = customerDao.read(idCustomer);

        if (Objects.isNull(customer)) {
            System.out.println("El cliente no existe");
        }


        System.out.println("Introduce ID del producto: ");
        int idProduct = scanner.nextInt();


        Ticket ticket = new Ticket(0, idProduct, idCustomer);
        ticketDao.create(ticket);
    }
    public static void deleteTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Ticket> ticketDao = new TicketDao();

        System.out.print("Posa la ID del ticket a eliminar: ");
        int ticketId = scanner.nextInt();

        //ticket.deleteTicketById(ticketId);

        ticketDao.delete(ticketId);
    }
    public static void checkTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);
        Dao<Ticket> ticketDao = new TicketDao();

        System.out.print("Posa la ID del ticket a mostrar: ");
        int id = scanner.nextInt();

        //ticket.checkTicketById(id);

        ticketDao.read(id);
    }
    public static void checkAllTicketsUI() {
        Dao<Ticket> ticketDao = new TicketDao();
        System.out.println("Tots els tickets:");
        System.out.println();

        //ticket.allTickets();

        System.out.println(ticketDao.readAll());
    }

}