import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static UserManager userManager = new UserManager();
    public static TicketManager ticket = new TicketManager();
    public static GestioProducts gestioProducts = new GestioProducts();

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("Pepe", "Gomez", "12345678A");
        User user2 = new User("Juan", "Lopez", "87654321B");
        User user3 = new User("Maria", "Perez", "11111111C");

        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);

        Products productLidl1 = new Products("Nueces", 1.2f, "Lidl");
        Products productLidl2 = new Products("Leche", 1.5f, "Lidl");
        Products productLidl3 = new Products("1KG Mandarinas", 3.4f, "Lidl");

        gestioProducts.addProduct(productLidl1);
        gestioProducts.addProduct(productLidl2);
        gestioProducts.addProduct(productLidl3);

        Products productMercadona1 = new Products("Helados", 3f, "Mercadona");
        Products productMercadona2 = new Products("Gofres", 1.7f, "Mercadona");
        Products productMercadona3 = new Products("Patatas fritas", 2.6f, "Mercadona");

        gestioProducts.addProduct(productMercadona1);
        gestioProducts.addProduct(productMercadona2);
        gestioProducts.addProduct(productMercadona3);

        Products productDia1 = new Products("Pechuga de pollo", 5.7f, "Dia");
        Products productDia2 = new Products("Cacahuetes", 1.2f, "Dia");
        Products productDia3 = new Products("Cola", 0.7f, "Dia");

        gestioProducts.addProduct(productDia1);
        gestioProducts.addProduct(productDia2);
        gestioProducts.addProduct(productDia3);

        //Ticket ticket1 = new Ticket(1, productsList1);
        //Ticket ticket2 = new Ticket(1, productsList2);
        //Ticket ticket3 = new Ticket(1, productsList3);

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

        User user = new User(firstName, lastName, dni);
        userManager.addUser(user);
    }
    public static void removeUserUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa el DNI de l'usuari: ");
        String dni = scanner.next();

        for (User user : userManager.userList()) {
            if (user.getDni().equals(dni)) {
                userManager.removeUser(user);
            }
        }
    }
    public static void modifyUserUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Posa el DNI de l'usuari: ");
        String dni = scanner.next();
        System.out.print("Posa el nou nom d'usuari: ");
        String newFirstName = scanner.next();
        System.out.print("Posa el nou cognom d'usuari: ");
        String newLastName = scanner.next();

        for (User user : userManager.userList()) {
            if (user.getDni().equals(dni)) {
                userManager.modifyUser(user, newFirstName, newLastName);
            }
        }
    }
    public static void searchUserUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa el DNI de l'usuari: ");
        String dni = scanner.next();

        System.out.println(userManager.searchUser(dni));
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
        Products product = new Products(pName, pPrice, pEstablishment);
        gestioProducts.addProduct(product);
    }
    public static void deleteProductUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa el nom del producte que vols eliminar: ");
        String nameProduct = scanner.next();

        gestioProducts.deleteProduct(nameProduct);
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

        System.out.println(gestioProducts.getProducts());
    }

    // UI DE LES FUNCIONS DE TICKETS

    public static void addTicketUI() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Products> products = new ArrayList<>();
        System.out.println("(TEMPORAL) Añade el precio total de la compra");
        int totalPrice = scanner.nextInt();
        System.out.println("En que establecimiento quieres comprar?");
        String establishment = scanner.next();

        ticket.createTicket(products, totalPrice, establishment);
    }
    public static void deleteTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa la ID del ticket a eliminar: ");
        int ticketId = scanner.nextInt();

        ticket.deleteTicketById(ticketId);
    }
    public static void checkTicketByIdUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Posa la ID del ticket a mostrar: ");
        int id = scanner.nextInt();

        ticket.checkTicketById(id);
    }
    public static void checkAllTicketsUI() {
        System.out.println("Tots els tickets:");
        System.out.println();

        ticket.allTickets();
    }
}