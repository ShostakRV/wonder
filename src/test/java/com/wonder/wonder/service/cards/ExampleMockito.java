
//package com.wonder.wonder.service.cards;
//
//import com.wonder.missurenko.Person;
//import com.wonder.missurenko.Salary;
//import com.wonder.missurenko.SalaryImpl;
//import com.wonder.missurenko.SomeClassForMockExamp;
//import org.junit.Test;
//import org.junit.rules.Timeout;
//import org.mockito.*;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
///**
// * Created by bm on 28.06.17.
// */
//public class ExampleMockito {
//
//    //mock creation
//    List mockedList = mock(List.class);
//
//    List<Boolean> mockedListBoolean = mock(List.class);
//
//    @Mock
//    Person person = mock(Person.class);
//
//    @InjectMocks
//    Salary salary = mock(SalaryImpl.class);
//
//    @Mock
//    SomeClassForMockExamp someClass = mock(SomeClassForMockExamp.class);
//
//    @Test
//    public void exampleMockitoVerify() {
//        //using mock object
//        mockedList.add("one");
//        System.out.println(mockedList.contains("one"));
//        mockedList.clear();
//        //verification
//        verify(mockedList).add("one");
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(100000));
//        verify(mockedList).clear();
//        // understand
//
//    }
//
//    @Test
//    public void exampleMockitoStubbing() {
//        //You can mock concrete classes, not only interfaces
//        LinkedList mockedList = mock(LinkedList.class);
//
//        //stubbing
//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
//        when(mockedList.getFirst()).thenReturn(100);
//        when(mockedList.get(100)).thenReturn("Hello World");
//
//        //following prints "first"
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(2));
//        //following throws runtime exception
////        System.out.println(mockedList.get(1));
//
//        //following prints "null" because get(999) was not stubbed
//        System.out.println(mockedList.get(100));
//
//        //Although it is possible to verify a stubbed invocation, usually it's just redundant
//        //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
//        //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
//
//        verify(mockedList).get(0);
//        verify(mockedList).get(2);
//        // understand
//
//
//    }
//
//    @Test
//    public void exampleMockitoArgumentMatchers() {
////stubbing using built-in anyInt() argument matcher
//        when(mockedList.get(anyInt())).thenReturn("element");
//
//        //stubbing using hamcrest (let's say isValid() returns your own hamcrest matcher):
////        when(mockedList.contains(arggit checkout masterThat(isValid()))).thenReturn("element");
//
//        //following prints "element"
//        System.out.println(mockedList.get(999));
//
//        //you can also verify using an argument matcher
//        verify(mockedList).get(anyInt());
//
////        verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
////        //above is correct - eq() is also an argument matcher
////
////        verify(mock).someMethod(anyInt(), anyString(), "third argument");
////        //above is incorrect - exception will be thrown because third argument is given without an argument matcher.
//
//
//    }
//
//    @Test
//    public void exampleMockito4() {
//        //using mock
//        mockedList.add("once");
//
//        mockedList.add("twice");
//        mockedList.add("twice");
//
//        mockedList.add("three times");
//        mockedList.add("three times");
//        mockedList.add("three times");
//
//        mockedList.add(1);
//        mockedList.add(2);
//        mockedList.add(2);
//        //following two verifications work exactly the same - times(1) is used by default
//        verify(mockedList).add("once");
//        verify(mockedList).add(1);
//
//        verify(mockedList, times(1)).add("once");
//        verify(mockedList, times(2)).add(2);
//        //exact number of invocations verification
//        verify(mockedList, times(2)).add("twice");
//        verify(mockedList, times(3)).add("three times");
//
//        //verification using never(). never() is an alias to times(0)
//        verify(mockedList, never()).add("never happened");
//        verify(mockedList, never()).add(0);// яка різниця між цим і
//
//
//        // understand
//
//
//        verify(mockedList, atLeast(0)).add(0);// цим
//        //verification using atLeast()/atMost()
//        verify(mockedList, atLeastOnce()).add("three times");
//        verify(mockedList, atLeast(0)).add("five times");
//
//
//        verify(mockedList, atMost(3)).add("three times");
//
//// need unswer
//    }
//
//    @Test
//    public void exampleMockito5() {
//        doThrow(new RuntimeException()).when(mockedList).clear();
//
//        doThrow(new RuntimeException()).when(mockedList).add("Wrong object");
//        mockedList.add("Wrong object");
//        //following throws RuntimeException:
//        mockedList.clear();
//
//// understand
//    }
//
//    @Test
//    public void exampleMockito6() {
//        List firstMock = mock(List.class);
//        List secondMock = mock(List.class);
//        List myMock = mock(List.class);
//        //using mocks
//        firstMock.add("was called first");
//        myMock.add("down");
//        secondMock.add("was called second");
//
//        //create inOrder object passing any mocks that need to be verified in order
//        InOrder inOrder = inOrder(firstMock, myMock, secondMock);
//
//        //following will make sure that firstMock was called before secondMock
//        inOrder.verify(firstMock).add("was called first");
//        inOrder.verify(myMock).add("down");
//
//
//        inOrder.verify(secondMock).add("was called second");
//
//
//        // understand
//
//    }
//
//
//    @Test
//    public void exampleMockito7() {
//        //using mock object
//        mockedList.add("one");
//        System.out.println(mockedList.contains("one"));
//        mockedList.clear();
//        //verification
//        verify(mockedList).add("one");
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(100000));
//        verify(mockedList).clear();
//        // understand
//
//    }
//
//    @Test
//    public void exampleMockito8() {
//        List mockOne = mock(List.class);
//        List mockTwo = mock(List.class);
//        List mockThree = mock(List.class);
//        //using mock object
//        mockOne.add("one");
//
//        //ordinary verification
//        verify(mockOne).add("one");
//
//        //verify that method was never called on a mock
//        verify(mockOne, never()).add("two");
//        verify(mockOne, never()).add("I do what i want");
//
//        //verify that other mocks were not interacted
//        verifyZeroInteractions(mockTwo, mockThree);
//        // understand
//
//    }
//
//    @Test
//    public void exampleMockito10() {
//
//
//        //First call: throws runtime exception:
//        someClass.someMethod("some arg");
//
//        //Second call: prints "foo"
//        System.out.println(someClass.someMethod("some arg"));
//
//        //Any consecutive call: prints "foo" as well (last stubbing wins).
//        System.out.println(someClass.someMethod("some arg"));
//
//
//        when(someClass.exampleMetod_10("some arg"))
//                .thenReturn("one", "two", "three");
////
////        when(someClass.someMethod("some arg"))
////                .thenThrow(new RuntimeException())
////                .thenReturn("foo");
//    }
//
//    // dont undestand how work
//
//    @Test
//    public void exampleMockito11() {
//
//
//        when(someClass.someMethod(anyString())).thenAnswer(new Answer() {
//            public Object answer(InvocationOnMock invocation) {
//                Object[] args = invocation.getArguments();
//                Object mock = invocation.getMock();
//
//                return "called with arguments: " + args;
//            }
//        });
//
//        when(mockedListBoolean.add(anyBoolean())).thenAnswer(new Answer() {
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//                Object[] args = invocation.getArguments();
//                Object mock = invocation.getMock();
//                System.out.println(mock + " list");
//                return true;
//            }
//
//
//        });
//        //Following prints "called with arguments: foo"
//        System.out.println(someClass.someMethod("foo") + " foo");
//        System.out.println(someClass.someMethod("11") + " 11");
//
//
//        System.out.println(mockedListBoolean.add(true));
//        System.out.println(mockedListBoolean.add(false));
//
//    }
//
//    @Test
//    public void exampleMockito12() {
//
//        //following throws RuntimeException:
//
//        mockedList.clear();
//        doThrow(new RuntimeException()).when(mockedList).clear();
//
//        mockedList.add(22);
//
//        doThrow(new RuntimeException()).when(mockedList).add(22);
//        doThrow(new RuntimeException()).when(mockedList).add("ssss");
//
//        mockedList.add(22);
//    }
//
//    @Test
//    public void exampleMockito13() {
//        List list = new LinkedList();
//        List spy = spy(list);
//        SomeClassForMockExamp someClass = new SomeClassForMockExamp();
//        SomeClassForMockExamp someClassSpy = spy(someClass);
//        //optionally, you can stub out some methods:
//        when(spy.size()).thenReturn(100);
//        when(someClassSpy.exampleMetod_10("tt")).thenReturn("tt");
//
//        when(someClassSpy.someMethod1()).thenCallRealMethod();
//        //using the spy calls real methods
//        spy.add("one");
//        spy.add("two");
//
//        //prints "one" - the first element of a list
//        System.out.println(spy.get(0));
//
//        //size() method was stubbed - 100 is printed
//        System.out.println(spy.size());
//
//        //optionally, you can verify
//        verify(spy).add("one");
//        verify(spy).add("two");
//
//        System.out.println(someClassSpy.exampleMetod_10("tt"));
//        System.out.println(someClassSpy.someMethod1());
//
//        verify(someClassSpy).exampleMetod_10("tt");
//        verify(someClassSpy).someMethod1();
//
//
//    }
//
//    @Test
//    public void exampleMockito13_1() {
//        List list = new LinkedList();
//        List spy = spy(list);
//
//
//        SomeClassForMockExamp someClass = new SomeClassForMockExamp();
//        SomeClassForMockExamp someClassSpy = spy(someClass);
//
//        //You have to use doReturn() for stubbing
//        doReturn("foo").when(spy).get(0);
//
//        System.out.println(spy.get(0));
//
//        doReturn("Hello World").when(someClassSpy).someMethod1();
//        System.out.println(someClassSpy.someMethod1());
//
//        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
//        when(spy.get(0)).thenReturn("1");
//        System.out.println(spy.get(0));
//
//
//        when(someClassSpy.someMethod1()).thenReturn("HO-HO-HO :)->");
//        System.out.println(someClassSpy.someMethod1());
//
//
//    }
//
//    @Test
//    public void exampleMockito14() {
//        SomeClassForMockExamp mock = mock(SomeClassForMockExamp.class, Mockito.RETURNS_SMART_NULLS);
////        SomeClassForMockExamp mockTwo = mock(SomeClassForMockExamp.class, new YourOwnAnswer());
//
//      // need ubderstand
//    }
//
//    @Test
//    public void exampleMockito15() {
//
//        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
//
//        verify(salary).doSomething(argument.capture());
//
//        assertEquals("John", argument.getValue().getName());
//
//// need understand
//    }
//
//    @Test
//    public void exampleMockito16() {
//        //you can create partial mock with spy() method:
//        List list = spy(new LinkedList());
//
//        //you can enable partial mock capabilities selectively on mocks:
//        SomeClassForMockExamp mock = mock(SomeClassForMockExamp.class);
//        //Be sure the real implementation is 'safe'.
//        //If real implementation throws exceptions or depends on specific state of the object then you're in trouble.
//        when(mock.someMethod1()).thenCallRealMethod();
//
//        System.out.println(mock.someMethod1());
//
//    }
//
//    @Test
//    public void exampleMockito17() {
//        List mock = mock(List.class);
//        when(mock.size()).thenReturn(10);
//        mock.add(1);
//
//        reset(mock);
//        //at this point the mock forgot any interactions & stubbing
//
//        //need more understand
//    }
//
//    @Test
//    public void exampleMockito22() {
//
//        //passes when someMethod() is called within given time span
//        verify(someClass, timeout(100)).someMethod("");
//        //above is an alias to:
//        verify(someClass, timeout(100).times(1)).someMethod("");
//
//        //passes when someMethod() is called *exactly* 2 times within given time span
//        verify(someClass, timeout(100).times(2)).someMethod("");
//
//        //passes when someMethod() is called *at lest* 2 times within given time span
//        verify(someClass, timeout(100).atLeast(2)).someMethod("");
//
//        //verifies someMethod() within given time span using given verification mode
//        //useful only if you have your own custom verification modes.
//
//
////        verify(someClass, new Timeout(100, yourOwnVerificationMode)).someMethod();
//
//        //need more understand
//    }
//
//
//}
