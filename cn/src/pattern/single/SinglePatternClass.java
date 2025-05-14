package pattern.single;

/*
 * 单例模式
 * 整个系统中只创建一个类实例
 * 要求：外部不能实例化这个类
 * 1.私有化成员变量
 * 2.私有化构造方法
 * 3.提供对外获取对象实例的接口
 * */

//懒汉式- -线程不安全
public class SinglePatternClass {
    private static SinglePatternClass singlePatternClass = null;

    private SinglePatternClass() {
    }

    public static SinglePatternClass getSingleClass() {
        if (singlePatternClass == null) {
            //假如两个线程都已经执行完if判断
            //然后每个线程继续执行下面的构造方法就会出现两个对象
            singlePatternClass = new SinglePatternClass();
        }
        return singlePatternClass;
    }
}

//饿汉式 - - 线程安全
class SinglePatternClass2 {
    private static SinglePatternClass2 singlePatternClass = new SinglePatternClass2();

    private SinglePatternClass2() {
    }

    public static SinglePatternClass2 getSingleClass() {
        return singlePatternClass;
    }
}

//懒汉式双重锁
class SinglePatternClass3 {
    private volatile static SinglePatternClass3 singlePatternClass = null;

    private SinglePatternClass3() {
    }

    public static SinglePatternClass3 getSingleClass() {
        if (singlePatternClass == null) {
            synchronized (SinglePatternClass3.class) {
                if (singlePatternClass == null) {
                    singlePatternClass = new SinglePatternClass3();
                }
            }
        }
        return singlePatternClass;
    }
}
