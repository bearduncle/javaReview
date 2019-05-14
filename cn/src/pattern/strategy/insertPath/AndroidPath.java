package pattern.strategy.insertPath;

public class AndroidPath implements InsertPath{
    @Override
    public void insertPath() {
        System.out.println("安卓通用耳机方式接入！");
    }
}
