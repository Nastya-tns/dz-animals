package otus;

public enum Color {
    WHITE("белый"),
    BlACK("черный"),
    GINGER("рыжий");

    private final String value;

    Color(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
