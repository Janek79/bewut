package com.micro.bewut.annotation;

import com.sun.xml.internal.ws.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class AnnotationProcessor {
    public static Map<String, Object> processCounterAnnotation(Method method, Object... args){

        Map<String, Object> collectedData = new HashMap<>();

        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {

            CounterField[] annotations = parameters[i].getAnnotationsByType(CounterField.class);
            for (CounterField annotation : annotations) {

                Map.Entry<String, Object> entry = getEntry(annotation, args[i]);
                collectedData.put(entry.getKey(), entry.getValue());

            }

        }

        return collectedData;

    }

    private static Map.Entry<String, Object> getEntry(CounterField annotation, Object targetObject){

        if(annotation.path().equals("")){
            return new HashMap.SimpleEntry<>(annotation.as(), targetObject);
        }

        String[] path = annotation.path().split("\\.");

        Object resultValue = targetObject;

        for (String fieldName : path) {
            try {
                resultValue = getFieldValue(resultValue, fieldName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return new HashMap.SimpleEntry<>(annotation.as(), resultValue);
    }

    private static Object getFieldValue(Object object, String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        String methodName = "get" + StringUtils.capitalize(fieldName);
        Method method = objectClass.getMethod(methodName);
        return method.invoke(object);
    }
}
