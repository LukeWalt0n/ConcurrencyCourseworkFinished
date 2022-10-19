public class TotalAllWarehouses extends Thread {
    
    Warehouse w;

    TotalAllWarehouses(Warehouse x){
        this.w = x;
    }
    public  void run(){
        System.out.println("The warhouse inventory is: " + w.getInventory());
    }
}
