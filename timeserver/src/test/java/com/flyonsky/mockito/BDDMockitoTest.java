package com.flyonsky.mockito;

import org.junit.Test;

import java.util.List;

import static org.mockito.BDDMockito.*;

/**
 * BDDMockito 学习
 */
public class BDDMockitoTest {

    @Test
    public void test1(){
        List mock = mock(List.class);
        given(mock.get(anyInt())).willReturn("测试");
        System.out.println(mock.get(0));
    }
}
