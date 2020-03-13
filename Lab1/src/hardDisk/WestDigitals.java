package hardDisk;

public class WestDigitals extends HardDisk {
    public WestDigitals(String name , String volume , int price){
        super(name,volume,price);
    }
    @Override
    public void work() {
        System.out.println("HardDisk WestDigitals work");
    }
}
