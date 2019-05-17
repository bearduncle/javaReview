package pattern.staticFactory;

public enum AnimalEnum {
    CAT("Cat"),
    DOG("Dog");

    private String value;

    AnimalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
