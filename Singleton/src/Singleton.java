public class Singleton {
    private static Singleton singleton = null;

    private Singleton(){//隐藏类的构造方法
        //私有的构造函数，不能在外部new
    }

    //静态方法返回实例
    public static Singleton getInstance(){//获取实例
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

}
