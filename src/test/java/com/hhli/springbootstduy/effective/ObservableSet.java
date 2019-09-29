package com.hhli.springbootstduy.effective;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李辉辉
 * @date 2019/9/28 16:45
 * @description
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set s) {
        super(s);
    }

    //private final List<SetObserver<E>> observers = new ArrayList<>();
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer){
        //synchronized (observers){
        //    observers.add(observer);
        //}
        observers.add(observer);
    }

    public  boolean removeObserver(SetObserver<E> observer){
        //synchronized (observers){
        //    return observers.remove(observer);
        //}
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element){
        //synchronized (observers){
        //    for (SetObserver<E> observer : observers) {
        //        observer.added(this, element);
        //    }
        //}
        for (SetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element){
        boolean added = super.add(element);
        if(added){
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E e : c) {
            result = add(e);
        }

        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e)-> System.out.println(e));
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(23 == element){
                    set.removeObserver(this);
                }
            }
        });

        //set.addObserver(new SetObserver<Integer>() {
        //    @Override
        //    public void added(ObservableSet<Integer> set, Integer element) {
        //        System.out.println(element);
        //        if(element == 23){
        //            ExecutorService exec = Executors.newSingleThreadExecutor();
        //            System.out.println("waiting");
        //            try {
        //                exec.submit(()->set.removeObserver(this));
        //                exec.submit(()->set.removeObserver(this)).get();
        //                //Thread.sleep(1000);
        //            } catch (InterruptedException | ExecutionException e) {
        //               throw new AssertionError(e);
        //            } finally {
        //                exec.shutdown();
        //            }
        //        }
        //    }
        //});


        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
