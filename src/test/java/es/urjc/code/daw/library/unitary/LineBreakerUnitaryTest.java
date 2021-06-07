package es.urjc.code.daw.library.unitary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.urjc.code.daw.library.book.LineBreaker;

public class LineBreakerUnitaryTest {

    private static LineBreaker lineBreaker;

    @BeforeAll
	public static void setup() {
        lineBreaker = new LineBreaker();
    }

    // "" 2 ""
    @Test
    @DisplayName(" \"\" 2 \"\" ")
    public void test01(){
        testBreakLine("", 2, "");
    }
    // "test" 4 "test"
    @Test
    @DisplayName(" \"test\" 4 \"test\" ")
    public void test02(){
        testBreakLine("test", 4, "test");
    }

    // "test" 5 "test"
    @Test
    @DisplayName(" \"test\" 5 \"test\" ")
    public void test03(){
        testBreakLine("test", 5, "test");
    }

    // "test test" 4 "test\ntest"
    @Test
    @DisplayName(" \"test test\" 4 \"test\\ntest\" ")
    public void test04(){
        testBreakLine("test test", 4, "test\ntest");
    }

    // "test test" 5 "test\ntest"
    @Test
    @DisplayName(" \"test test\" 5 \"test\\ntest\" ")
    public void test05(){
        testBreakLine("test test", 5, "test\ntest");
    }

    // "test test" 6 "test\ntest"
    @Test
    @DisplayName(" \"test test\" 6 \"test\\ntest\" ")
    public void test06(){
        testBreakLine("test test", 6, "test\ntest");
    }

    // "test test test test" 9 "test test\ntest test"
    @Test
    @DisplayName(" \"test test test test\" 9 \"test test\\ntest test\" ")
    public void test07(){
        testBreakLine("test test test test", 9, "test test\ntest test");
    }

    // "test test" 4 "test\ntest"
    @Test
    @DisplayName(" \"test   test\" 4 \"test\\ntest\" ")
    public void test08(){
        testBreakLine("test test", 4, "test\ntest");
    }

    // "test test" 6 "test\ntest"
    @Test
    @DisplayName(" \"test    test\" 6 \"test\\ntest\" ")
    public void test09(){
        testBreakLine("test test", 6, "test\ntest");
    }

    // "testtest" 5 "test-\ntest"
    @Test
    @DisplayName(" \"testtest\" 5 \"test-\\ntest\" ")
    public void test10(){
        testBreakLine("testtest", 5, "test-\ntest");
    }

    // "testtesttest" 5 "test-\ntest-\ntest"
    @Test
    @DisplayName(" \"testtesttest\" 5 \"test-\\ntest-\\ntest\" ")
    public void test11(){
        testBreakLine("testtesttest", 5, "test-\ntest-\ntest");
    }

    // "test test" 3 "te-\nst\nte-\nst"
    @Test
    @DisplayName(" \"test test\" 3 \"te-\\nst\\nte-\\nst\" ")
    public void test12(){
        testBreakLine("test test", 3, "te-\nst\nte-\nst");
    }

    // "test 1234567 test" 6 "test\n12345-\n67\ntest"
    @Test
    @DisplayName(" \"test 1234567 test\" 6 \"test\\n12345-\\n67\\ntest\" ")
    public void test13(){
        testBreakLine("test 1234567 test", 6, "test\n12345-\n67\ntest");
    }

    // "123456789" 3 "12-\n34-\n56-\n789"
    @Test
    @DisplayName(" \"123456789\" 3 \"12-\\n34-\\n56-\\n789\" ")
    public void test14(){
        testBreakLine("123456789", 3, "12-\n34-\n56-\n789");
    }


    private void testBreakLine(String line, int lineLength, String expected){
        String breakLine = lineBreaker.breakLine(line, lineLength);
        assertEquals(expected,breakLine);
    }
    
}