package com.flyonsky.mockito;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.mockito.BDDMockito.*;

/**
 * BDDMockito 学习
 */
public class BDDMockitoTest {

    /**
     * BDD 风格的验证
     */
    @Test
    public void test1(){
        List mock = mock(List.class);
        given(mock.get(anyInt())).willReturn("测试");
        System.out.println(mock.get(0));
    }

    /**
     * 自定义验证失败信息
     */
    @Ignore
    @Test
    public void test2(){
        List mock = mock(List.class);
        mock.add("abc");
        // will print a custom message on verification failure
        verify(mock, description("This will print on failure")).add("abc");

        // will work with any verification mode
        verify(mock, times(2).description("someMethod should be called twice")).add("abc");
    }
}
