package com.example.myhttpframe.frame;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    private LinkedBlockingDeque<Runnable> httpTaskQueue;
    private ThreadPoolExecutor threadPool;

    private static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }

    private ThreadManager() {
        httpTaskQueue = new LinkedBlockingDeque<>();

        threadPool = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5), new RejectedExecutionHandler() {
            //当核心线程、缓存队列、最大线程都满是的拒绝策略
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                httpTaskQueue.add(r);
            }
        });

        threadPool.execute(task);
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    //阻塞
                    Runnable r = httpTaskQueue.take();
                    threadPool.execute(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void addTask(Runnable runnable) {
        if(runnable != null) {
            httpTaskQueue.add(runnable);
        }

    }
}
