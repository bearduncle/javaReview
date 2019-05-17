package pattern.staticFactory;

public class Test {

    public static void main(String[] args) {
        System.out.println("I want a dog");
        Animals animals=null;
        try {
            animals=AnimalCreateFactory.getAnimal(AnimalEnum.DOG.getValue());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        animals.dark();
    }
}
