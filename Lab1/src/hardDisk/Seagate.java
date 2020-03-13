package hardDisk;

public class Seagate extends HardDisk {
    public Seagate(String name , String volume , int price){
        super(name,volume,price);
    }
    @Override
    public void work() {
        System.out.println("HardDisk Seagate work");
    }
}
