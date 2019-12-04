package com.colin.eureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaApplicationTests {

    @Test
    public void contextLoads() {
        try {
            int a = Integer.parseInt("123");
        } catch (NumberFormatException e) {
            System.out.println("wrong");
            return;
        }finally {
            System.out.println("finally");
        }
    }

}
