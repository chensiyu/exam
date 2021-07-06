package com.exam.threadlocal;

import com.exam.thread.vo.Person;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    @Test
    public void tlTest(){
        Executor pool = Executors.newFixedThreadPool(4);

        Person person = Person.builder().age(new ThreadLocal<>()).build();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.setName("张三");
                person.getAge().set("15");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程1------名称:" + person.getName() + "，年龄：" + person.getAge().get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.setName("王五");
                person.getAge().set("17");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程2------名称:" + person.getName() + "，年龄：" + person.getAge().get());
            }
        });

        t1.start();
        t2.start();
    }
}
