/*
 * A class which represents a warehouse.
 * Simply has an inventory value and an ID for the warehouse.
 */
public class Warehouse {
    
    private int inventory;
    private int warehouseNumber;


    public Warehouse(){
       this.inventory =0; 
    }



    public void addInventory(int f){

        if(f == 0){
            synchronized(this){
                this.inventory = (getInventory()+1);
                System.out.println("Added. Inventory size = " + getInventory());
            }
        }
        else{
            this.inventory = (getInventory()+1);
            System.out.println("Added. Inventory size = " + getInventory());
        }

    }

    public void removeInventory(int f){
        if(f == 0){
            synchronized(this){
                this.inventory = (getInventory()-1);
                System.out.println("Removed. Inventory size = " + getInventory());
            }
        }
        else{
            this.inventory = (getInventory()-1);
            System.out.println("Removed. Inventory size = " + getInventory());
        }
        
        
    }
   
    public int getInventory(){
        return this.inventory;
    }
    

    public int getNumber(){
        return this.warehouseNumber;
    }
}
