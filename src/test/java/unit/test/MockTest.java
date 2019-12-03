package unit.test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

/**
 * @author 李辉辉
 * @date 2019-12-02 16:50
 * @description mock测试
 */
public class MockTest {

    @Test
    public void verifyBehaviour(){
        List mock = mock(List.class);
        mock.add(1);
        mock.clear();
        //
        verify(mock).add(1);
        //
        verify(mock).clear();
    }


    @Test
    public void whenReturn(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("world");
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();

        assertEquals("Hello world world", result);
    }


    @Test(expectedExceptions= IOException.class)
    public void whenThrow() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        doThrow(IOException.class).when(outputStream).close();

        outputStream.close();
    }



    @Test
    public void testSmartNulls(){
        List temp = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(temp.get(0));
        System.out.println(temp.toArray().length);
    }


    @Test
    public void deepStubsTest(){
        Account account = mock(Account.class, RETURNS_DEEP_STUBS);
        when(account.getRailwayTicket().getDestination()).thenReturn("Beijing");

        assertEquals("Beijing", account.getRailwayTicket().getDestination());
    }

    public class RailwayTicket{
        private String destination;

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
    }

    public class Account{
        private RailwayTicket railwayTicket;

        public RailwayTicket getRailwayTicket() {
            return railwayTicket;
        }

        public void setRailwayTicket(RailwayTicket railwayTicket) {
            this.railwayTicket = railwayTicket;
        }
    }




}
