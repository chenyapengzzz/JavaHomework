package mainBoard;

public class Gigabyte extends MainBoard {
    public Gigabyte(String name , String speed , int price){
        super(name,speed,price);
    }

    @Override
    public void work() {
        System.out.println("MainBoard Gigabyte work");
    }
}
