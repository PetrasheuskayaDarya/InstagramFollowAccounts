package by.htp.insta.tests;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.insta.dao.AccountDao;
import by.htp.insta.dao.imple.AccountDaoImple;
import by.htp.insta.entity.Account;
import by.htp.insta.steps.Steps;

public class FollowAutomation {
	private Steps steps;

	@BeforeMethod(description = "Init browser", groups = { "FollowAutomation" })
	public void setUp() throws InterruptedException {
		steps = new Steps();
		steps.initBrowser();
		steps.LogIn();
		Thread.sleep(3000);
	}

	@Test(groups = { "FollowAutomation" })
	public void FollowAutomation() throws InterruptedException{


        //steps.getAllAccountsNameWhoFollowUs();// 1 for checking follow back or not
		steps.FollowForMarketing();// follow by tags 

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
