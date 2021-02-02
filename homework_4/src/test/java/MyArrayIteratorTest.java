import org.junit.*;

import java.util.NoSuchElementException;

public class MyArrayIteratorTest {
    private Object[] testArr;
    private MyArrayIterator iterArr;

    @Before
    public void SetUp() {
        testArr = new Object[]{1,2,3,11,11,12,21,34,56,77,88,88,65,43};
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTest() {
        iterArr = new MyArrayIterator(testArr);
        int col = 0;
        try {
            while (true)
            {
                System.out.println(iterArr.next());
                col++;
            }
        }finally {
            Assert.assertEquals("количество пройденных элементов не совпадает с размером массива", col, testArr.length);
        }
    }

    @Test
    public void hasNextTest() {
        iterArr = new MyArrayIterator(testArr);
        int col = 0;
        while (iterArr.hasNext())
        {
            System.out.println(iterArr.next());
            col++;
        }
        Assert.assertEquals("количество пройденных объектов не совпадает с размером массива", col, testArr.length);
    }
}
