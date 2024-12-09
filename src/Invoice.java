import java.util.*;
public class Invoice {
    private double usageLimit;
   private double currentSpending=0;
   private Date lastDayToPay;
   private Date now;
   private int nowMinute;
   private int lastDay;
   
    
   public Invoice(double usageLimit, Date lastDayToPay) {
       this.usageLimit = usageLimit;
       this.currentSpending = 0;
       int oneDay = 1000 * 60 * 60 * 24;
       int oneMonth = oneDay * 30;
       this.now=new Date();
       this.nowMinute=(int) now.getTime();
       this.lastDayToPay = new Date(nowMinute + oneMonth);
       this.lastDay=nowMinute+oneMonth;
   }

   Invoice() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public boolean isLimitExceeded(double amount) {
       if (amount + this.getCurrentSpending() > this.getUsageLimit()) {
           System.out.println("You exceeded the limit ");
           return true;
       }
       return false;
   }

   public void addCost(double amount) {
       this.setCurrentSpending(this.getCurrentSpending() + amount);
   }
   
   public double totalSpending(double amount){
       currentSpending+=amount;
        return currentSpending;
   }
   
   public void paySpending(double amount) {
       if (amount == this.getCurrentSpending()) {
           {
               int oneDay = 1000 * 60 * 60 * 24;
               int oneMonth = oneDay * 30;
               this.setLastDayToPay(new Date(getLastDayToPay().getTime() + oneMonth));

           }
       }
   }

   public void changeUsageLimit(double amount) {
       this.setUsageLimit(amount);
   }

   public double getUsageLimit() {
       return usageLimit;
   }

   public void setUsageLimit(double usageLimit) {
       this.usageLimit = usageLimit;
   }

   public double getCurrentSpending() {
       return currentSpending;
   }

   public void setCurrentSpending(double currentSpending) {
       this.currentSpending = currentSpending;
   }

   public Date getLastDayToPay() {
       return lastDayToPay;
   }
   public int getNowMinute(){
        return nowMinute;
   }
   public int getLastDay(){
       return lastDay;
   }
   public void setLastDayToPay(Date lastDayToPay) {
       this.lastDayToPay = lastDayToPay;
   }
}