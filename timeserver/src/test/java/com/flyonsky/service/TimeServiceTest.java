package com.flyonsky.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import  static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TimeServiceTest {
    @Mock
    private TimeService timeService;

    @Test
    public void testCurrentTime(){
        given(timeService.currentTime()).willReturn("2019-08-03");

        System.out.println(timeService.currentTime());
    }
}
