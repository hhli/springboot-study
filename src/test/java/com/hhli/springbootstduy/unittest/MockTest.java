package com.hhli.springbootstduy.unittest;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author 李辉辉
 * @date 2019-10-21 12:14
 * @description mockito测试
 */
public class MockTest {

    public static void main(String[] args) {
        //创建Mock
        List<String> mockedList = mock(List.class);

        //使用Mock对象
        mockedList.add("one");
        mockedList.clear();

        //验证行为
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
