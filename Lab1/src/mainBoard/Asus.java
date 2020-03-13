package mainBoard;

public class Asus extends MainBoard{

    public Asus(String name , String speed , int price){
        super(name,speed,price);
    }

    @Override
    public void work() {
        System.out.println("MainBoard Asus work");
    }
}
