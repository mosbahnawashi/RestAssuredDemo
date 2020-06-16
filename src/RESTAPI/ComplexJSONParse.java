package RESTAPI;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJSONParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payload.coursePrice());
		
		//	1. Print No of courses returned by API:
		int count = js.getInt("courses.size()");
		System.out.println("No of courses returned by API = " + count);
		System.out.println("***************************************************************************");
		
		//	2.Print Purchase Amount:
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount = " + purchaseAmount);
		System.out.println("***************************************************************************");
		
		//	3.a Print Title of the first course:
		String TitleOfTheFirstCourse = js.get("courses[0].title");
		System.out.println("Title of the first course: " + TitleOfTheFirstCourse);
		System.out.println("***************************************************************************");
		
		//	3.b Print Title of the last course:
		String TitleOfTheLastCourse = js.getString("courses[2].title");
		System.out.println("Title Of The Last Course: " + TitleOfTheLastCourse);
		System.out.println("***************************************************************************");
		
		//	3.c Print the price of the Cypress course:
		int priceOfTheCypressCourse = js.getInt("courses[1].price");
		System.out.println("Price of the Cypress course: $" + priceOfTheCypressCourse);
		System.out.println("***************************************************************************");
		
		//	4. Print All course titles and their respective Prices:
		for(int i=0;i<count;i++)
		{
			String titleOfAllCourses = js.getString("courses["+i+"].title");
			int coursePrice = js.getInt("courses["+i+"].price");
			System.out.println(("Title of course no "+(i+1)+ ": " + titleOfAllCourses + ". Price = " + coursePrice).toString());
		}
		System.out.println("***************************************************************************");
		
		//	5. Print no of copies sold by RPA Course:
		for(int i=0;i<count;i++)
		{
			String courseTitle = js.getString("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("No of copies of " + courseTitle + ": " + copies);
				break;
			}
		}
		System.out.println("***************************************************************************");
	}

}
