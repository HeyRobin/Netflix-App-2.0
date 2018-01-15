package com.nfs.data;

import org.junit.Assert;
import org.junit.Before;
import com.nfs.data.Profile;
import com.nfs.data.CurrentUser;
import org.junit.Test;

import static org.junit.Assert.*;



public class ProfileTest {
    @Test
public void testProfile(){
    //setup
        int subscriber = 1215426;
        int profileID = 100001;


    //test
        try {
            Profile profile = new Profile(subscriber, profileID);
        }catch (Exception e){
            assertTrue(false);
        }
        assertTrue(true);

    //teardown
}


}