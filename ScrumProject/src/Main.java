
import dao.CustomerDao;
import dao.ProductDao;
import dao.TicketDao;
import models.Product;
import models.Customer;
import models.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static CustomerDao customerDao = new CustomerDao();
    public static ProductDao productDao = new ProductDao();
    public static TicketDao ticketDao = new TicketDao();

    public static UserManager userManager = new UserManager();
    public static TicketManager ticket = new TicketManager();
    public static GestioProducts gestioProducts = new GestioProducts();

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Pepe", "Gomez", "12345678A");
        Customer customer2 = new Customer("Juan", "Lopez", "87654321B");
        Customer customer3 = new Customer("Maria", "Perez", "11111111C");

        userManager.addUser(customer1);
        userManager.addUser(customer2);
        userManager.addUser(customer3);

        Product productLidl1 = new Product("Nueces", 1.2f, "Lidl");
        Product productLidl2 = new Product("Leche", 1.5f, "Lidl");
        Product productLidl3 = new Product("1KG Mandarinas", 3.4f, "Lidl");

        gestioProducts.addProduct(productLidl1);
        gestioProducts.addProduct(productLidl2);
        gestioProducts.addProduct(productLidl3);

        Product productMercadona1 = new Product("Helados", 3f, "Mercadona");
        Product productMercadona2 = new Product("Gofres", 1.7f, "Mercadona");
        Product productMercadona3 = new Product("Patatas fritas", 2.6f, "Mercadona");

        gestioProducts.addProduct(productMercadona1);
        gestioProducts.addProduct(productMercadona2);
        gestioProducts.addProduct(productMercadona3);

        Product productDia1 = new Product("Pechuga de pollo", 5.7f, "Dia");
        Product productDia2 = new Product("Cacahuetes", 1.2f, "Dia");
        Product productDia3 = new Product("Cola", 0.7f, "Dia");

        gestioProducts.addProduct(productDia1);
        gestioProducts.addProduct(productDia2);
        gestioProducts.addProduct(productDia3);

        //models.Ticket ticket1 = new models.Ticket(1, productsList1);
        //models.Ticket ticket2 = new models.Ticket(1, productsList2);
        //models.Ticket ticket3 = new models.Ticket(1, productsList3);

        //ticket.tickets.add(ticket1);
        //ticket.tickets.add(ticket2);
        //ticket.tickets.add(ticket3);

        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<String> establecimientos = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("Selecciona una opció");
            System.out.println();
            System.out.println("1. Gestio usaris");
            System.out.println("2. Gestio productes");
            System.out.println("3. Gestio tickets");
            System.out.println("4. Salir del programa");
            System.out.println();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    usersManagement();
                    break;
                case 2:
                    productsManagement();
                    break;
                case 3:
                    ticketsManagement();
                    break;
                case 4:
                    addTicketUI();
                    break;
                case 5:
                    ticket.allTickets();
                    break;
                case 6:
                    checkTicketByIdUI();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Opció no valida");
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
    public static void productsManagement() {
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

        System.out.print("Posa el teu nom: ");
        String firstName = scanner.next();
        System.out.print("Posa el teu cognom: ");
        String lastName = scanner.next();
        System.out.print("Posa el teu dni: ");
        String dni = scanner.next();

        Customer customer = new Customer(firstName, lastName, dni);
        //userManager.addUser(customer);
        customerDao.create(customer);
    }
    public static void removeUserUI() {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Posa el DNI de l'usuari: ");
        //String dni = scanner.next();

        System.out.println("Posa la ID de l'usuari");
        int id = scanner.nextInt();

        for (Customer customer : userManager.userList()) {
            //if (customer.getDni().equals(dni)) {
            //    userManager.removeUser(customer);
            //}
            customerDao.delete(id);
        }
    }
    public static void modifyUserUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Posa el DNI de l'usuari: ");
        String dni = scanner.next();
        //out.print("Posa el nou nom d'usuari: ");
        //String newFirstName = scanner.next();
        //System.out.print("Posa el nou cognom d'usuari: ");
        //String newLastName = scanner.next();

        System.out.print("Posa la ID de l'usuari: ");
        int id = scanner.nextInt();

        for (Customer customer : userManager.userList()) {
            if (customer.getDni().equals(dni)) {
                //userManager.modifyUser(customer, newFirstName, newLastName);
                customerDao.modify(id, customer);
            }
        }
    }
    public static void searchUserUI() {
        Scanner scanner = new Scanner(System.in);

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

        System.out.print("Posa el nom del producte a afegir: ");
        String pName = scanner.next();
        System.out.print("Posa el preu del producte: ");
        float pPrice = scanner.nextFloat();
        System.out.println("Tria un supermercat (1. Dia 2. Lidl 3. Mercadona): ");
        int pLocal = scanner.nextInt();
        String pEstablishment = "";

        switch (pLocal) {
            case 1:
                pEstablishment = "Dia";
                break;
            case 2:
                pEstablishment = "Lidl";
                break;
            case 3:
                pEstablishment = "Mercadona";
                break;
            default:
                System.out.println("Opcio no trobada");
                break;
        }
        Product product = new Product(pName, pPrice, pEstablishment);
        //gestioProducts.addProduct(product);

        productDao.create(product);
    }
    public static void deleteProductUI() {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Posa el nom del producte que vols eliminar: ");
        //String nameProduct = scanner.next();

        System.out.println("Posa la ID del producte a eliminar: ");
        int id = scanner.nextInt();

        //gestioProducts.deleteProduct(nameProduct);

        productDao.delete(id);
    }
    public static void modifyPriceUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa el nom del producte a modificar el preu: ");
        String nameProduct = scanner.next();
        System.out.print("Posa el nou preu que vols que tingui el producte: ");
        int newPrice = scanner.nextInt();

        gestioProducts.modifyPrice(nameProduct, newPrice);
    }
    public static void getProductsUI() {
        Scanner scanner = new Scanner(System.in);

        //System.out.println(gestioProducts.getProducts());

        System.out.println(productDao.readAll());
    }

    // UI DE LES FUNCIONS DE TICKETS

    public static void addTicketUI() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        System.out.println("(TEMPORAL) Añade el precio total de la compra");
        int totalPrice = scanner.nextInt();
        System.out.println("En que establecimiento quieres comprar?");
        String establishment = scanner.next();

        ticket.createTicket(products, totalPrice, establishment);

        Ticket ticket = new Ticket();
        ticketDao.create(ticket);
    }
    public static void deleteTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa la ID del ticket a eliminar: ");
        int ticketId = scanner.nextInt();

        //ticket.deleteTicketById(ticketId);

        ticketDao.delete(ticketId);
    }
    public static void checkTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa la ID del ticket a mostrar: ");
        int id = scanner.nextInt();

        //ticket.checkTicketById(id);

        ticketDao.read(id);
    }
    public static void checkAllTicketsUI() {
        System.out.println("Tots els tickets:");
        System.out.println();

        //ticket.allTickets();

        System.out.println(ticketDao.readAll());
    }
}