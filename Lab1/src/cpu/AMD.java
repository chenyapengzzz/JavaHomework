package cpu;

public class AMD extends CPU {

    public AMD(String name , int volume , int price){
        super(name,volume,price);
    }

    @Override
    public void work(){
        System.out.println("CPU AMD work");
    }
}
