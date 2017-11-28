package ru.kupchenkov.lesson4;

import java.lang.reflect.Field;

public class Reflection {

    private static String result = "";

    private Reflection(){}

    public static String toString(Object o) throws IllegalAccessException {
        if (o == null) return "null";
        result += o.getClass().toString() + "{\n";

        Class targetClass = o.getClass();
        Field[] fields = targetClass.getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            if (!f.getType().isPrimitive() && !f.getType().equals(String.class)){
                toString(f.get(o));
            }else{
                result += "  " + f.getName() + "(" + f.getType().getName() + ")  =  " + f.get(o) + "\n";
            }
        }
        result += "}\n";
        return result;
    }

}
