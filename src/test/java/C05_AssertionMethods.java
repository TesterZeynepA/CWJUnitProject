import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class C05_AssertionMethods {

    @Test
    public void assetEqualsTest(){

        //2 parametre alırsa parametreler karşilastırılır ve estlerse test passed olur.
        //esit değilse AssertionError fırlatır.

        Assert.assertEquals(10,10);//passed

    }

    @Test
    public void assetTrueTest(){
        //1 parametre alır ve gönderilen parametrenin true olması durumunda testimiz passed,
        //false olması durumunda failed olur.

        Assert.assertTrue(5==5);

    }

    @Test
    public void assetFalseTest(){

        //1 parametre alır ve gönderilen parametrenin false olması durumunda testimiz passed,
        //true olması durumunda failed olur.

        Assert.assertFalse(5==4);

    }

    @Test
    public void assertNullTest(){
       // 1 parametre alır parametre null ise test passed
       // null değilse test failed olur.


        Assert.assertNull(null);
    }

    @Test
    public void assertNotNullTest(){
        // 1 parametre alır parametre null değilse ise test passed
        // null ise test failed olur.


        Assert.assertNotNull(4);
    }

    @Test
    public void assertSameTest(){
        // bu method iki nesnenin eşit olup olmadığını doğrulamak için dahili olarak == operatorünü kullanır.
        // assertSame referans değerlerini karşılaştırır.
        //obje kontrolünde değer ve referanslar aynı olmalıdır.


        assertSame("Elly","Elly");
       // Assert.assertSame(new String("Hi"), new String("Hi"));// failed

    }

    @Test
    public void assertNotSameTest(){
        // obje kontrolünde değer ve referanslar aynı olmayanlar için geçerlidir.


        Assert.assertNotSame(new String("Hi"), new String("Hi"));
    }

    @Test
    public void assertArrayEquals(){
      //2 parametre alır ve verilen arraylerin uzunlukları ve aynı indexteki elemanları aynı olmalıdır.

        int[] arr1 ={0,1,2,3,4}, arr2={0,1,2,3,4};
        Assert.assertArrayEquals(arr1,arr2);

        char[] actualArr = {'h','o','m','e'};
        char[] expectedArr = {'h','o','m','e'};

        Assert.assertArrayEquals("iki array esit değilse fail olacak", expectedArr,actualArr);//failed

    }

}
