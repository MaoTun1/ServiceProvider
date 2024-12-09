public class Subscriber {
    private static int count = 1000000;
    private int s_id;
    private String name;
    private int age;
    private boolean isActive=true;
    private ServiceProvider s_provider;
    private Invoice invoice;
    private int elapsed;
    public Subscriber(){
        
    }
    public Subscriber(String name, int age, ServiceProvider s_provider, double usageLimit) {
        this.s_id = count++;
        this.name = name;
        this.age = age;
        this.isActive = true;
        this.s_provider = s_provider;
        this.invoice = invoice;
        
    }
// abonelik bitimi tarihinde sıkıntı var !!!!!!
    public void updateStatus(Subscriber s) {
        if(isActive){
            this.isActive= false;
        }
        this.isActive=true;
    }

    public void makeVoiceCall(int minute,Subscriber caller,Subscriber receiver) {
        double cost=s_provider.calculateVoiceCallCost(minute,caller);
    if (getIsActive(caller)&& invoice.isLimitExceeded(cost)&& getIsActive(receiver)) {
        System.out.println(caller+"is calling with"+receiver);
        } else {
            System.out.println("You cannot make voice call");
        }
    }

    public void sendMessage(int quantity, Subscriber sender,Subscriber receiver) {
        double cost=s_provider.calculateMessagingCost(quantity,sender,receiver);
        if (getIsActive(sender) && invoice.isLimitExceeded(cost)) {
            if(getIsActive(receiver)){
                System.out.println(sender+"is chatting with"+receiver);
            }else{
                System.out.println("You cannot make chatting");
            }
    }
  }

    
     public void connectToInternet(double amount,Subscriber connecter){
        double cost=s_provider.calculateInternetCost(amount,connecter);
        if(getIsActive(connecter)&& invoice.isLimitExceeded(cost)){
            System.out.println("You connect to internet");
        }
            System.out.println("You cannot to connect to internet");
        
    }

    public void changeServiceProvider(Subscriber s,ServiceProvider newProvider){
      if(getIsActive(s)){
         if(s_provider!=newProvider){
            this.s_provider=newProvider;
             System.out.println("Provider changed");
         }else{
             System.out.println("You enter same provider");
         }
      }
        System.out.println("Subscriber is not active");
        
   }

    public int getS_id() {
        return s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ServiceProvider getServiceProvider() {
        return s_provider;
    }
    

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    boolean getIsActive(Subscriber s){
        return this.isActive; 
    }
}