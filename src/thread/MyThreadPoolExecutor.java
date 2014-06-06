/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author PimGame
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private boolean isPaused;
    private ArrayList<Runnable> threads = new ArrayList<>();
    private String type;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = pauseLock.newCondition();

    public MyThreadPoolExecutor(
            int coreSize,
            int maxSize,
            long keepAliveTime,
            TimeUnit timeUnit,
            BlockingQueue<Runnable> bq) {
        super(coreSize, maxSize, keepAliveTime, timeUnit, bq);

    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        pauseLock.lock();
        try {
            while (isPaused) {
                unpaused.await();
            }

        } catch (InterruptedException ie) {
            t.interrupt();
        } finally {
            pauseLock.unlock();
        }
        threads.add(r);
        super.beforeExecute(t, r);

    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        threads.remove(r);
        super.afterExecute(r, t);

    }

    public void setType(String type) {
        System.out.println(type);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void pause() {
        pauseLock.lock();
        try {
            isPaused = true;
        } finally {
            pauseLock.unlock();
        }
    }

    public void resume() {
        pauseLock.lock();
        try {
            isPaused = false;
            unpaused.signalAll();
        } finally {
            pauseLock.unlock();
        }
    }

}
