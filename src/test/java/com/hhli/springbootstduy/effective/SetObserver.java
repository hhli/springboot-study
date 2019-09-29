package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019/9/28 16:46
 * @description
 */
@FunctionalInterface
public interface SetObserver<E> {

    /**
     *  Invoked when an element is added to the observable set
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set, E element);
}
