package ram;

public class Kingston extends RAM {
    public Kingston(String name , String volume , int price){
        super(name,volume,price);
    }
    @Override
    public void work() {
        System.out.println("RAM Kington work");
    }
}
