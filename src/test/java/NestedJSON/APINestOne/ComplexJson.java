package NestedJSON.APINestOne;

import io.restassured.path.json.JsonPath;

public class ComplexJson 
{
//	1. Print No of courses returned by API
//	2.Print Purchase Amount
//	3. Print Title of the first course
//	4. Print All course titles and their respective Prices
//	5. Print no of copies sold by RPA Course
//	6. Verify if Sum of all Course prices matches with Purchase Amount
	
	public static void main(String[] args) {
		JsonPath js1 = new JsonPath(PayLoad.Courses.getCourse());
		int cnt = js1.getInt("courses.size()");
		System.out.println(cnt);
		
		int purschaseamt = js1.getInt("dashboard.purchaseAmount");
		System.out.println(purschaseamt);
		
		String titleFirst = js1.getString("courses[0].title");
		System.out.println(titleFirst);
		
		for(int i=0;i<cnt;i++)
		{
			String courseTitles = js1.get("courses["+i+"].title");
			int pricetitle = js1.getInt("courses["+i+"].price");
			System.out.println("Title is : " + courseTitles);
			System.out.println("Price is : " + pricetitle);
			
			
		}
	}

}
