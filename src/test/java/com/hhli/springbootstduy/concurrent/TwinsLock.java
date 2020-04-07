package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 李辉辉
 * @date 2020-04-06 12:02
 * @description
 */
public class TwinsLock {
    public Sync sync = new Sync(2);

    public void lock(){
        sync.acquireShared(1);
    }

    public  boolean unlock(){
        return sync.releaseShared(1);
    }

    private static final class Sync extends AbstractQueuedSynchronizer{

        private static final long serialVersionUID = 8785544736160651243L;

        public Sync(int count){
            if(count <= 0){
                throw  new IllegalArgumentException("count必须大于0");
            }

            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
          for (;;){
              int state = getState();
              int newState = state - arg;
              if(newState<0 || compareAndSetState(state, newState)){
                  return newState;
              }
          }
        }

        @Override
        public boolean tryReleaseShared(int arg){
            for(;;){
                int state = getState();
                int newState = state + arg;
                if(compareAndSetState(state, newState)){
                    return true;
                }
            }
        }
    }
}
