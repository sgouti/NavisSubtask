package Navvis;

import java.io.File;
import java.io.IOException;

import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Mainfile {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		// TODO Auto-generated method stub
		 WebDriver driver;

         //Open Chrome browser

         String url="https://navvishealthcare.atlassian.net";

                // System.setProperty("webdriver.chrome.driver", "C:\\Users\\sellappillaib\\Downloads\\chromedriver_win32\\chromedriver.exe");

                 driver=new ChromeDriver();

                 driver.get(url);

                 driver.manage().window().maximize();

                 Pages p=new Pages(driver);

                // p.LoginJira("sellappillai.babu@emids.com","P@ssw0rd123");

                 File file=new File("StorydetailsJiraAutoTask.xls");
        		 Workbook Wb=Workbook.getWorkbook(file);
//        		public Sheet TcSheet;
        		Sheet sht=Wb.getSheet(0);
        		int totalTc=sht.getRows();
        		String name = null;
        		System.out.println(totalTc);
        		
        		for(int i=1;i<totalTc;i++)
        		{
        			try {
        			 name=sht.getCell(0,i).getContents();
        			System.out.println(name);
        			  p.NavigateToStory(name);  
        			  Thread.sleep(1000);
        			  int stropoint=p.Storypoint;
        			  String DB,API,FI,Int,CRv,CRf,MB,UT,BF,QTR,QBV,QTD,QTE,QA;
        			  CRv="1h";CRf="1h";MB="1h";QA="2h";QTR="2h";QBV="4h";
        			  if(stropoint==3)
        			  {
        				  DB="1h";API="4h";FI="6h";Int="2h";UT="2h";BF="2h";QTD="3h";QTE="8h";
        			  }
        			  else if(stropoint==5)
        			  {
        				  DB="2h";API="8h";FI="10h";Int="4h";UT="4h";BF="4h";QTD="4h";QTE="12h";
        			  }
        			  else
        			  {
        				 
            			  
            			  DB="3h";API="12h";FI="14h";Int="6h";UT="6h";BF="6h";QTD="6h";QTE="16h";
            			  
        			  }
        			  
        		/*	  p.CreateDevSubtask("[Dev]- DB creation","Dev Task");
        			  Thread.sleep(1000);
        			  p.CreateDevSubtask("[Dev]-API Creation","Dev Task");
        			  Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Front end code integration","Dev Task");
                      Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Integration","Dev Task");
                      Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Code Review","Dev Task");
                      Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Code Refix","Dev Task");
                      Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Merge and Build","Dev Task");
                      Thread.sleep(1000);
                      p.CreateDevSubtask("[Dev]-Unit Testing","Dev Task");
                      Thread.sleep(1000);
                   */
                    //QA Subtask
        			// p.CreateQaSubtask("[QA]-Analysis","QA Task",QA);
        			//  Thread.sleep(1000);
                   //  p.CreateQaSubtask("[QA]-Test case design","QA Task",QTD);
                      Thread.sleep(1000);
                      p.CreateQaSubtask("[QA]-Test case review","QA Task",QTR);
                      Thread.sleep(1000);
                      p.CreateQaSubtask("[QA]-Test execution","QA Task",QTE);
                      Thread.sleep(1000);
                      p.CreateQaSubtask("[QA]-Bug Verification","QA Task",QBV);
                      Thread.sleep(1000);
                    //Dev Subtask
                    
                      /*   p.SubtaskEstimationHour("[Dev]- DB creation",DB);
        			  Thread.sleep(3000);
        			  p.SubtaskEstimationHour("[Dev]-API Creation",API);
        			  Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Front end code integration",FI);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Integration",Int);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Code Review",CRv);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Code Refix",CRf);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Merge and Build",MB);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[Dev]-Unit Testing",UT);
                      Thread.sleep(3000);
                      p.CreateDevSubtask("[Dev]- Bug Fix","Dev Task",BF);
        			  Thread.sleep(3000);
                     
                     p.SubtaskEstimationHour("[QA]- Analysis",QA);
        			  Thread.sleep(3000);
                      p.SubtaskEstimationHour("[QA]-Test case design",QTD);
                      Thread.sleep(3000);
                     p.SubtaskEstimationHour("[QA]-Test case review",QTR);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[QA]-Test execution",QTE);
                      Thread.sleep(3000);
                      p.SubtaskEstimationHour("[QA]-Bug Verification",QBV);
                     Thread.sleep(3000);
                 
                     */
        			 
                      
        		}
        			catch(Exception e)
            		{
            			System.out.println(e +"= "+ name);
            		}
        		}
        		
        		 Thread.sleep(1000);
        		p.Logout();
                 driver.close();


  }
		


}