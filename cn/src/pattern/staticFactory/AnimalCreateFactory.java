package pattern.staticFactory;

public class AnimalCreateFactory {

    //使用反射 的方式  也可以使用 new来创建对象的实例
    public static Animals getAnimal(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Animals)Class.forName("pattern.staticFactory."+type).newInstance();
    }
}
