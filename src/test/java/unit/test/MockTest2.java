package unit.test;

import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author 李辉辉
 * @date 2019-12-02 17:30
 * @description
 */
public class MockTest2 {
    @Mock
    private List mockList;

    public MockTest2(){
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void shorthand() {
        mockList.add(1);
        verify(mockList).add(1);
    }


    @Test
    public void testArguments(){
        //Comparable comparable = mock(Comparable.class);
        //when(comparable.compareTo("Test")).thenReturn(1);
        //when(comparable.compareTo("Omg")).thenReturn(2);
        //
        //assertEquals(1, comparable.compareTo("Test"));
        //assertEquals(2, comparable.compareTo("Omg"));
        //assertEquals(0, comparable.compareTo("Not stub"));

        List list = mock(List.class);

        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(argThat(new IsValid()))).thenReturn(true);
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(999));
        assertTrue(list.contains(1));
        assertTrue(!list.contains(3));
    }


    private class IsValid extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object o) {
            return new Integer(1).equals(o) || new Integer(2).equals(o);
        }
    }


    @Test(expectedExceptions= RuntimeException.class)
    public void consecutive_calls(){
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效
        when(mockList.get(0)).thenReturn(0);
        when(mockList.get(0)).thenReturn(1);
        when(mockList.get(0)).thenReturn(2);
        when(mockList.get(1)).thenReturn(0).thenReturn(1).thenThrow(new RuntimeException());
        assertEquals(2,mockList.get(0));
        assertEquals(2,mockList.get(0));
        assertEquals(0,mockList.get(1));
        assertEquals(1,mockList.get(1));
        //第三次或更多调用都会抛出异常
        mockList.get(1);
    }
}
