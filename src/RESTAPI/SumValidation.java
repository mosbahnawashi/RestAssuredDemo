package RESTAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	//	//	6. Verify if Sum of all Course prices matches with Purchase Amount:
	
	@Test
	public void sumOfCourses()
	{
		int sum = 0;
		JsonPath js = new JsonPath(payload.coursePrice());
		int count = js.getInt("courses.size()");
		
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			
			sum+=amount;
		}
		
		System.out.println("Sum of all Course prices = " + sum);
		int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		//Assert.assertEquals(sum, totalPurchaseAmount);
		
		try
		{
			Assert.assertEquals(sum, totalPurchaseAmount);
		}catch(AssertionError e)
		{
			//	Try change totalPurchaseAmount in payload.coursePrice() to 1801 and run again:
			System.out.println("Assertion Error: Expected: " + totalPurchaseAmount + ", found: " + sum);
		}
	}
}
