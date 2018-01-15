package com.nfs.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriberTest {



        @Test
        public void testSubscriber(){
            //setup
            int subscriber = 1215426;


            //test
            try {
                Subscriber sub = new Subscriber(subscriber);
            }catch (Exception e){
                assertTrue(false);
            }
            assertTrue(true);

            //teardown
        }




}