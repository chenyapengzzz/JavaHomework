package ram;

public class Samsung extends RAM {
    public Samsung(String name , String volume , int price){
        super(name,volume,price);
    }

    @Override
    public void work() {
        System.out.println("RAM Samsung work");
    }
}
