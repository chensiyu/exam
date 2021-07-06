package com.exam.thread.vo;

import lombok.*;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2021/7/6
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Person {

    private String name;

    private String sex;

    private ThreadLocal<String> age = new ThreadLocal<>();

    public void ageTlRemove(){
        this.age.remove();
    }
}
