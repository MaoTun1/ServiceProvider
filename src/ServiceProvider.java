import java.util.*;
//metehan
public class ServiceProvider {
    private int p_id;
    private String p_name;
    private static int count = 500;
    private double voiceCallCost;
    private double messagingCost;
    private double internetCost;
    private int discountRatio;
    private ArrayList<Subscriber> subscriberList;
    public Subscriber sub1=new Subscriber();
    
    public ServiceProvider(String name,double voicecallcost,double messagecost,double internetcost,int discountratio){
        this.p_id=count;
        count++;
        this.p_name=name;
        this.voiceCallCost=voicecallcost;
        this.subscriberList=new ArrayList<Subscriber>();
        this.messagingCost=messagecost;
        this.internetCost=internetcost;
        this.discountRatio=discountratio;
        if (this.count > 600) {
            System.out.println("You cannot create any Provider !!");
            System.exit(-1);
        }
    }

    ServiceProvider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public double calculateVoiceCallCost(int minute, Subscriber caller){
        if (subscriberList.equals(caller)){
            if (teenager(caller)){
                if (minute<=5){
                    return 0.0;
                }
            }
            if ((teenager(caller)|| elder(caller) && minute>5)){
                 return (minute*discountRatio);
            }else {
                return minute*voiceCallCost;
            }          
        }
        else {
             return 0.0;
        }
    }
    
    public double calculateInternetCost(double amount,Subscriber a){
        if (subscriberList.equals(a)){
            if (teenager(a)){
                if (amount<=5.0){
                    return 0.0;
                }
            }else {
                return (amount*internetCost);
            }
        }
            return 0.0;
        
    }
    public double calculateMessagingCost(int quantity, Subscriber sender,Subscriber receiver){
        
        if (subscriberList.equals(receiver)&& subscriberList.equals(sender)){
            if (sub1.getIsActive(receiver)&&sub1.getIsActive(sender)){
                return discountRatio;
            }else {
                 return messagingCost;
            }
        }else{
            return 0.0;
        }
    }
    public boolean addSubscriber(Subscriber a){
        return subscriberList.add(a);
    }
    public boolean removeSubscriber( Subscriber a) {
        return subscriberList.remove(a);
    }
    

    public int getDiscountRatio() {
        return discountRatio;
    }

    public int getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }
    public  void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getInternetCost() {
        return internetCost;
    }

    public double getMessagingCost() {
        return messagingCost;
    }

    public void setDiscountRatio(int discountRatio) {
        this.discountRatio = discountRatio;
    }

    public void setInternetCost(double internetCost) {
        this.internetCost = internetCost;
    }

    public double getVoiceCallCost() {
        return voiceCallCost;
    }

    public void setMessagingCost(double messageCost) {
        this.messagingCost = messageCost;
    }

    
    public void setVoiceCallCost(double voiceCallCost) {
        this.voiceCallCost = voiceCallCost;
    }

    public ArrayList<Subscriber> getSubscriberList() {
        return subscriberList;
    }
    
    public boolean elder(Subscriber a){
        if (a.getAge()>=65){
            return  true;
        }else {
            return false;
        }
    }
   public boolean teenager(Subscriber a){
        if (a.getAge()<= 18 && 10 <=a.getAge()){
            return true;
        }else {
            return false;
        }
    }
}