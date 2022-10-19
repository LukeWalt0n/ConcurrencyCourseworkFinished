/*
 * A class which is where the program is executed.
 */



class addThread extends Thread{

    Warehouse w;
    int f;

    addThread(Warehouse wh, int flag){
        this.w = wh;
        this.f = flag;
    }
    public void run(){
        
        this.w.addInventory(f);
    }
}

class removeThread extends Thread{

    Warehouse w;
    int f;
    removeThread(Warehouse wh, int flag){
        this.w = wh;
        this.f = flag;
    }
    public void run(){
        this.w.removeInventory(f);
    }
}




public class InventoryMain {
    
    public static void main(String args[]){

        //Read in arguments.
        int noOfAdd = Integer.parseInt(args[0]);
        int noOfSub = Integer.parseInt(args[1]);
        int flag = Integer.parseInt(args[2]);


        //Create a warehouse to manipulate.
        Warehouse w = new Warehouse();

        //Feel like this is where the synchronization problems are:

        addThread adders[] = new addThread[noOfAdd];
        removeThread removers[] = new removeThread[noOfSub];
        
        //Create all the threads.
        for(int i=0; i < noOfAdd; i++){
            adders[i] = new addThread(w, flag); 
        }
        for(int i=0; i < noOfSub; i++){
            removers[i] = new removeThread(w, flag);
        }

        //Now we need to run all the threads, either synchronized or not synced.
        
        for(int i =0; i < adders.length; i++){
            adders[i].start();
            if(flag == 0){
                try{
                    adders[i].join();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
            
        }
        for(int i =0; i < removers.length; i++){
            removers[i].start();
            if(flag == 0){
                try{
                    removers[i].join();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }

        
        System.out.println("Final Inventory is: " + w.getInventory());
        //TotalAllWarehouses t = new TotalAllWarehouses(w);
        //t.run();
        
        
        

        

        

    }
}
