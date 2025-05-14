package pattern.single;


//枚举类实现的单例模式 - - 可以避免反射，序列化和反序列化的问题
public class SinglePatternEnumEp {

    //私有化构造函数
    private SinglePatternEnumEp(){ }

    enum SinglePatternEnum {
        SINGLE_PATTERN_ENUM;

        private SinglePatternEnumEp singlePatternEnumEp;

        SinglePatternEnum(){
            singlePatternEnumEp = new SinglePatternEnumEp();
        }

        public SinglePatternEnumEp getSingle() {
            return singlePatternEnumEp;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static SinglePatternEnumEp getInstance(){
        return SinglePatternEnum.SINGLE_PATTERN_ENUM.getSingle();
    }
}