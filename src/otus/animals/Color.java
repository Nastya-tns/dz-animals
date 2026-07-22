package otus.animals;

import otus.Command;
import otus.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;

public enum Color {
    UNDEFINED("неизвестный"),
    WHITE("белый"),
    BLACK("черный"),
    GINGER("рыжий");

    private final String value;

    Color(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

     public static final List<String> VALUES = collectValues();

    private static List<String> collectValues(){
        List<String> result = new ArrayList<>();
        for (Color type : Color.values()){
            result.add(type.name());
        }
        return result;
    }
    public static boolean doesNotContain(String value){
        if (value == null){
            return true;
        }
        return !VALUES.contains(value.toUpperCase().trim());
    }

    public static Color fromString (String value){
        if (value == null){
            return null;
        }
        return Color.valueOf(value.toUpperCase().trim());
    }




}
