package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {


    /* //1
    @Async //Thread thread = new Thread(new Runnable())
    public void hello() {
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep .....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

    //@Async //CompletableFuture : 별도의 스레드에서 실행
    @Async("async-thread") // 어노테이션 프록시 기반 aop기반 public 메소드에만 달수 있다.
    public CompletableFuture run(){
        return new AsyncResult(hello()).completable();
    }

    public String hello() {
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep ..... {} ",i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return "async hello";
    }

}
