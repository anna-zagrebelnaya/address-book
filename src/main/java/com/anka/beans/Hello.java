package com.anka.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
    private String text;

    public static String getHello() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello hello = (Hello) ctx.getBean("helloBean");
        return hello.getText();
    }

    public Hello(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
