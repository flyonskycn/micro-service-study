package com.flyonsky.mockito;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MockitoTest {

    /**
     * 验证某些行为
     */
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

    /**
     * 如何做一些测试桩 (Stub)
     */
    @Test(expected = RuntimeException.class)
    public void test2(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 输出“first”
        System.out.println(mockedList.get(0));

        // 抛出异常
        System.out.println(mockedList.get(1));

        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
    }

    /**
     * 参数匹配器 (matchers)
     */
    @Test
    public void test3(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 测试桩
        when(mockedList.get(anyInt())).thenReturn("first");

        System.out.println(mockedList.get(1));

        verify(mockedList).get(1);
    }

    /**
     * 验证函数的确切、最少、从未调用次数
     */
    @Test
    public void test4(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        mockedList.add("five times");
        mockedList.add("five times");
        mockedList.add("five times");
        mockedList.add("five times");
        mockedList.add("five times");

        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        // 使用atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    /**
     * 为返回值为void的函数通过Stub抛出异常
     */
    @Test(expected = RuntimeException.class)
    public void test5(){
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();

        // 调用这句代码会抛出异常
        mockedList.clear();
    }

    /**
     * 验证执行执行顺序
     */
    @Test
    public void test6(){
        // A. 验证mock一个对象的函数执行顺序
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        // 为该mock对象创建一个inOrder对象
        InOrder inOrder = inOrder(singleMock);

        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B .验证多个mock对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        // 为这两个Mock对象创建inOrder对象
        InOrder inOrderMock = inOrder(firstMock, secondMock);

        // 验证它们的执行顺序
        inOrderMock.verify(firstMock).add("was called first");
        inOrderMock.verify(secondMock).add("was called second");
    }

    /**
     * 确保交互(interaction)操作不会执行在mock对象上
     */
    @Test
    public  void test7(){
        List mockOne = mock(List.class);
        // 使用Mock对象
        mockOne.add("one");

        // 普通验证
        verify(mockOne).add("one");

        // 验证某个交互是否从未被执行
        verify(mockOne, never()).add("two");

        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);

        // 验证mock对象没有交互过
        verifyZeroInteractions(mockTwo, mockThree);
    }

    /**
     * 查找冗余的调用
     */
    @Test
    public void test8(){
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList,times(1)).add("one");

        List mockedListNever = mock(List.class);
        // 下面的验证将会失败
        verifyNoMoreInteractions(mockedListNever);
    }

    /**
     * 为连续的调用做测试桩 (stub)
     */
    @Test(expected = RuntimeException.class)
    public void test9(){
        Map mock = mock(Map.class);
        when(mock.get("some arg"))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");

        // 第一次调用 : 抛出运行时异常
        mock.get("some arg");

        // 第二次调用 : 输出"foo"
        System.out.println(mock.get("some arg"));

        // 后续调用 : 也是输出"foo"
        System.out.println(mock.get("some arg"));
    }

    /**
     * 为连续的调用做测试桩 (stub)
     */
    @Test
    public void test10(){
        Map mock = mock(Map.class);
        // 第一次调用时返回"one",第二次返回"two",第三次返回"three"
        when(mock.get("some arg"))
                .thenReturn("one", "two", "three");

        System.out.println(mock.get("some arg"));
        System.out.println(mock.get("some arg"));
        System.out.println(mock.get("some arg"));
    }

    /**
     * 监控真实对象
     */
    @Test
    public void test11(){
        List list = new LinkedList();
        List spy = spy(list);

        // 你可以为某些函数打桩
        when(spy.size()).thenReturn(100);

        // 通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("two");

        // 输出第一个元素
        System.out.println(spy.get(0));

        // 因为size()函数被打桩了,因此这里返回的是100
        System.out.println(spy.size());

        // 交互验证
        verify(spy).add("one");
        verify(spy).add("two");
    }

    /**
     * 监控真实对象
     */
    @Test
    public  void test12(){
        List list = new LinkedList();
        List spy = spy(list);

        // 不可能 : 因为当调用spy.get(0)时会调用真实对象的get(0)函数,此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
//        when(spy.get(0)).thenReturn("foo");

        // 你需要使用doReturn()来打桩
        doReturn("foo").when(spy).get(0);

        System.out.println(spy.get(0));
    }
}
