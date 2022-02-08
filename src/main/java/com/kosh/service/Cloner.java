package com.kosh.service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Cloner {

    public Object clone(Object src) throws Exception {
        final Class<?> clazz = src.getClass();

        Object newObj;
        try {
            newObj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnsupportedOperationException("Could not create a copy of " + src);
        }


        clone(clazz, src, newObj);
        return newObj;
    }

    public Object clone(Class<?> clazz, Object src, Object newObj) throws Exception {
        if (src == null) return null;
        Class<?> classType;
        Object obj;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible())
                field.setAccessible(true);

            classType = field.getType();


            if (((obj = field.get(src)) != null) && Collection.class.isAssignableFrom(classType)) {
                field.set(newObj, collectToList(((Collection) obj).stream()
                        .map(obj1 -> handleSingleField(obj1)), obj.getClass()));
            } else if (field.get(src) != null){
                field.set(newObj,field.get(src));
                continue;
            }
        }

        return newObj;
    }

    private Object handleSingleField(Object obj) {
        if (obj != null && CustomCloneableInterface.class.isAssignableFrom(obj.getClass())) {
            try {
                return clone(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    private static <S> List<S> collectToList(Stream<S> stream, Class<?> listType) {
        if (ArrayList.class.isAssignableFrom(listType))
            return stream.collect(toCollection(ArrayList::new));
        if (LinkedList.class.isAssignableFrom(listType))
            return stream.collect(toCollection(LinkedList::new));

        throw new UnsupportedOperationException("Provided ListType " + listType + " not currently supported");
    }
}
