package com.heavyant.domain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by zs on 16/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class FistTest {

    @Inject
    private ServiceTest serviceTest;

    @Test
    public void testFDSD(){
        System.out.println("this is second!");
    }

    @Test
    public void testSpringBean(){
        serviceTest.serviceTest();
    }
}
