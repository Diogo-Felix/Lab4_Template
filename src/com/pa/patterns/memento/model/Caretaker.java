package com.pa.patterns.memento.model;

public class Caretaker {
    private Memento memento;

    public void saveState(ShoppingCart sc){
        memento = sc.createMemento();
    }

    public void restoreState(ShoppingCart sc) throws NoMementoException {
        if(memento == null)
            throw new NoMementoException("Memento empty!");

         sc.setMemento(memento);
    }
}
