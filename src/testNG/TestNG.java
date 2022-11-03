package testNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
			
		  @BeforeMethod
		  public void Before_Method() {
			  System.out.println("I am before Method..");
		  }
		  
		  @AfterMethod
		  public void After_Method() {
			  System.out.println("I am After Method..");
		  }
		  
		  @BeforeTest
		  public void Before_Test() {
			  System.out.println("I am BEFORE TEST..");
		  }
		  
		  @AfterTest
		  public void After_Test() {
			  System.out.println("I am AFTER TEST..");
		  }
		  
		  @Test   //Annotation - which is kind of a flag which tells to TestNG, hey below method is a test case..
		  public void TestCase_1() {
			  System.out.println("This is my first testcase");
		  }
		  
		  @Test
		  public void TestCase_2() {
			  System.out.println("This is my second testcase");
		  }
		}

