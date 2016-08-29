package com.heavyant.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zs on 16/8/26.
 */
@Service
public class ServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);

    public void serviceTest(){
        logger.debug("this is debug");
        logger.info("this is info");
        logger.error("this is error");
        System.out.println("this is sout()");
    }
}
