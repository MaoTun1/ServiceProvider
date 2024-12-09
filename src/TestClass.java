import java.util.*;
public class TestClass {
    private static ArrayList<Subscriber> subscribers = new ArrayList<>();
    private static ArrayList<ServiceProvider> providers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //ServiceProvider serviceProvider1=new ServiceProvider();
        //Subscriber subscriber1=new Subscriber();
        //Invoice invoice1=new Invoice();
        while (true) {
            System.out.println("Welcome");
            System.out.println("1. Create a new Service Provider");
            System.out.println("2. Create a new Subscriber");
            System.out.println("3. Make Voice Call");
            System.out.println("4. Make Messaging");
            System.out.println("5. Connect Internet");
            System.out.println("6. Pay Invoice");
            System.out.println("7. Change Service Provider");
            System.out.println("8. Change Usage Limit");
            System.out.println("9. List All Subscribers");
            System.out.println("10. List All Service Providers");
            System.out.println("11. Exit");

            int select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    createServiceProvider();
                    break;
                case 2:
                    createSubscriber();
                    break;
                case 3:
                    makeVoiceCall();
                    break;
                case 4:
                    sendMessage();
                    break;
                case 5:
                    connectToInternet();
                    break;
                case 6:
                    payInvoice();
                    break;
                case 7:
                    changeServiceProvider();
                    break;
                case 8:
                    changeUsageLimit();
                    break;
                case 9:
                    listAllSubscribers(subscribers);
                    break;
                case 10:
                    listAllProviders(providers);
                    break;
                case 11:
                    System.out.println("End of the program");
                    System.exit(0);
                default:
                    System.out.println("Invalid select.");
            }
        }
    }

    private static void createServiceProvider() {
        
    Scanner input = new Scanner(System.in);
    System.out.println("Enter provider name:");
    String name=input.nextLine();
    System.out.println("Enter voice call cost: ");
    double voiceCallCost = input.nextDouble();
    System.out.println("Enter messaging cost: ");
    double messagingCost = input.nextDouble();
    System.out.println("Enter internet cost: ");
    double internetCost = input.nextDouble();
    System.out.println("Enter discount ratio: ");
    int discountRatio = input.nextInt();
    ServiceProvider provider = new ServiceProvider(name,voiceCallCost, messagingCost, internetCost, discountRatio);
    providers.add(provider);  
    }

    private static void createSubscriber() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter name: ");
    String name = scanner.nextLine();
    System.out.println("Enter age: ");
    int age = scanner.nextInt();
    System.out.println("Enter service provider : ");
    int providerID = scanner.nextInt(); 
    System.out.println("Enter usage limit: ");
    double usageLimit = scanner.nextDouble();
    ServiceProvider provider = providers.get(providerID);
    Subscriber subscriber = new Subscriber(name, age, provider, usageLimit);
    subscribers.add(subscriber);
    }

    private static void makeVoiceCall() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter caller's subscriber : ");
    int caller1 = scanner.nextInt();
    System.out.println("Enter receiver's subscriber : ");
    int receiver1 = scanner.nextInt();
    System.out.println("Enter call time in minutes: ");
    int minute = scanner.nextInt();
    Subscriber caller = subscribers.get(caller1);
    Subscriber receiver = subscribers.get(receiver1);
    caller.makeVoiceCall(minute,caller,receiver);
    }

    private static void sendMessage() {
        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter sender's subscriber : ");
    int senderID = scanner.nextInt();
    System.out.println("Enter receiver's subscriber : ");
    int receiverID = scanner.nextInt();
    System.out.println("Enter message quantity: ");
    int quantity = scanner.nextInt();
    Subscriber sender = subscribers.get(senderID);
    Subscriber receiver = subscribers.get(receiverID);
    sender.sendMessage(quantity,sender,receiver);
    }

    private static void connectToInternet() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter subscriber : ");
    int connecter1 = scanner.nextInt();
    System.out.println("Enter amount for internet: ");
    double amount = scanner.nextDouble();
    Subscriber connecter = subscribers.get(connecter1);
    connecter.connectToInternet(amount,connecter);
    }

    private static void payInvoice() {
    Scanner scanner = new Scanner(System.in);
    Invoice invoice=new Invoice();
    System.out.println("Enter subscriber: ");
    int subscriberID = scanner.nextInt();
    System.out.println("Enter amount to pay: ");
    double amount = scanner.nextDouble();
    invoice.paySpending(amount);
        System.out.println("Amount is pay");
    }

    private static void changeServiceProvider() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter subscriber ID: ");
    int subscriberID = scanner.nextInt();
    System.out.println("Enter new provider ID: ");
    int providerID = scanner.nextInt();
    Subscriber subscriber = subscribers.get(subscriberID);
    ServiceProvider provider=providers.get(providerID);
    subscriber.changeServiceProvider(subscriber, provider);
    
    }

    private static void changeUsageLimit() {
        Scanner input=new Scanner(System.in);
        Invoice invoice=new Invoice();
        System.out.println("enter usage limit");
        double newUsageLimit=input.nextInt();
        if(invoice.getUsageLimit()==newUsageLimit){
            System.out.println("you enter same usage limit please enter different usage limit value");
        }else{
            System.out.println("Usage limit changed");
        invoice.changeUsageLimit(newUsageLimit);    
            }
    }

    private static void listAllSubscribers(ArrayList<Subscriber> subscribers) {
        Subscriber subscriber=new Subscriber();
        System.out.println("Subscriber's List");
        for (int i = 0; i < subscribers.size(); i++) {
            System.out.println(subscribers.get(i)); 
        }
                 
    }

    private static void listAllProviders(ArrayList<ServiceProvider> serviceProviders) {
        ServiceProvider serviceProvider1=new ServiceProvider(); 
        System.out.println("Provider's List");
        for (int i = 0; i < serviceProviders.size(); i++) {
            System.out.println(serviceProviders.get(i)); 
        }
    }
}