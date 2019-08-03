package com.flyonsky.mockito;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {

    @Test
    public void test1(){
        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //using mock object 使用mock对象
        mockedList.add("one");
        mockedList.clear();

        //verification 验证
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test(expected = RuntimeException.class)
    public void test2(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 输出“first”
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        // 抛出异常
        System.out.println(mockedList.get(1));

        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
    }
}
