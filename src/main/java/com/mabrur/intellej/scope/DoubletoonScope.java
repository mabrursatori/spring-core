package com.mabrur.intellej.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

public class DoubletoonScope implements Scope {

    private List<Object> objects = new ArrayList<>(2);
    private Long counter = -1L;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        counter++;
        if(objects.size() == 2){
            return  objects.get((int) (counter % 2));
        }else{
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String s) {
        if(objects.size() != 0){
            return  objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
