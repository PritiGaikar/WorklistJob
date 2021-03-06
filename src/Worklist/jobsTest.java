package Worklist;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common_Function.WebDriverPass;

public class jobsTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	 jobs w = new  jobs();
	

	 @Test(priority=1)
	  public void WorklistURL() throws Exception {
		 try{
		   test=report.startTest("Worklist URL");	  
		   w.WorklistURL(driver);		
		   Assert.assertTrue(true);
	 }
		 catch(Exception e){			  
			e.getMessage();
			 Assert.assertTrue(false);				
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Worklist URL"); 
		  System.out.println("Worklist URL open successfully");
	  }
	 

 	
	 	 @Test(priority=2)
	  public void AddNewJobs() throws Exception {
			 try{
			   test=report.startTest("Add New Jobs");	  
			   w.AddNewJobs(driver);
			   Assert.assertTrue(true);		   
			 }
			 catch(Exception e){			  
			e.getMessage();
				/* write_data.writedata(0,6,7,fail);
				 write_data.writedata(0,6,6,exception);*/
				 Assert.assertTrue(false);	
			 }		 	 
			   
			  test.log(LogStatus.PASS, "Technical-->Admin-->New Add Jobs"); 
			  System.out.println("New Jobs Added successfully");
		  }


	 
		 @AfterMethod
		  	public void afterMethod(ITestResult result) {
		  	    if (result.getStatus() == ITestResult.FAILURE) {
		  	        test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
		  	    } else if (result.getStatus() == ITestResult.SKIP) {
		  	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		  	    } else {
		  	        test.log(LogStatus.PASS, "Test passed");
		  	    }
		  	    report.endTest(test);
		  	    report.flush();
		  }
		  @BeforeSuite
		  public void beforeSu() {
		  	  report = WorklistJobs.getReporter(path.concat("Report.html"));
		  }

		  @AfterSuite
		  public void afterSu() {
		      report.close();
		  }



}
