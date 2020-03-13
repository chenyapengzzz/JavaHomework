package cpu;

public class Intel extends CPU {

    public Intel(String name , int coreNum , int price){
        super(name,coreNum,price);
    }

    @Override
    public void work(){
        System.out.println("CPU Intel work");
    }
}
