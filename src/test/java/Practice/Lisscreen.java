package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericutilities.Baseclass;



@Listeners(com.scm.genericutilities.Listnersimpleclass.class)
public class Lisscreen extends Baseclass{
@Test
public void takescreen() throws Throwable{
	System.out.println("----take screenshot----");
	Assert.assertEquals(false,true);
	System.out.println("-------");
}
}
