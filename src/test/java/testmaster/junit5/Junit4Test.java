package testmaster.junit5;

import org.junit.Assert;
import org.junit.Test;

public class Junit4Test extends BaseJunit4{

    @Test
    public void assertEqualsTest(){

        Assert.assertEquals("elma", "elma");
        Assert.assertEquals("hata", "elma", "elma");
        Assert.assertEquals(6,7);
        Assert.assertEquals(true,true);

        System.out.println("assertEquals Kontrol başarılı");
    }

    @Test
    public void assertTrueTest(){

        Assert.assertTrue("hata",5 > 2);
        System.out.println("assertTrue Kontrol başarılı");
    }

    @Test
    public void assertNotNullTest(){
        String a = null;
        String b = "elma";
        //Assert.assertNull("deger null degil",a);
        Assert.assertNotNull(a);
        Assert.assertTrue(a.contains(b));
        System.out.println("assertNotNull Kontrol başarılı");
    }

}
