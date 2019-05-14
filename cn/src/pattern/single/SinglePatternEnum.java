package pattern.single;


//枚举类实现的单例模式 - - 可以避免反射，序列化和反序列化的问题
public enum SinglePatternEnum {
    SINGLE_PATTERN_ENUM;
    public static SinglePatternEnum getSingle(){
        return SINGLE_PATTERN_ENUM;
    }
}
