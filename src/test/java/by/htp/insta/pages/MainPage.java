package by.htp.insta.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.insta.dao.AccountDao;
import by.htp.insta.dao.imple.AccountDaoImple;
import by.htp.insta.entity.Account;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru/login";
	int numbersOfAccountsWhoWeFollow = 10;

	public static List<String> hashTags = new ArrayList<String>();
	public String tag1 = "#dotNET";
	public String tag2 = "#reactjs";
	public String tag3 = "#php";
	public String tag4 = "#angular";
	public String tag5 = "#rubyonrails";

	int a = 2;
	int b = 4;
	int random_number = a + (int) (Math.random() * b);

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	@FindBy(xpath = "//button[text()='Not Now']")
	private WebElement NotNowNotifications;

	@FindBy(xpath = "//button[text()='Log Out']")
	private WebElement logOutButton;

	@FindBy(xpath = "//*[@id='react-root']/div/div[2]/a[2]")
	private WebElement LinkNotNow;

	@FindBy(className = "coreSpriteDesktopNavProfile")
	private WebElement profileUser;

	@FindBy(className = "//*[@id='react-root']/section/nav/div[2]/div/div/div[3]/div/div[3]/a")
	private WebElement profile;

	@FindBy(className = "dCJp8")
	private WebElement parameters;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchField;

	@FindBy(xpath = "//button[contains(@class,'coreSpriteHeartOpen')]/span")
	private WebElement heartButton;

	@FindBy(xpath = "//button[contains(@class,'oW_lN')]")
	private WebElement followButton;

	@FindBy(xpath = "//div[@class='fuqBx']/a[1]")
	private WebElement firstItemFromDropDown;

	@FindBy(xpath = "//div[contains(@class,'Nnq7C')]/div")
	private List<WebElement> listOfAllPosts;

	@FindBy(xpath = "//a[contains (@class,'notranslate')]")
	private List<WebElement> listAccountNameWhoFollow;

	@FindBy(xpath = "//a[contains(@class,'nJAzx')]")
	private WebElement accountName;

	@FindBy(xpath = "//*[@id='react-root']/section/main/article/div[2]/div/div[1]/div[1]/a/div/div[2]")
	private WebElement firstRecentPost;

	@FindBy(xpath = "//a[text() = 'Next']")
	private WebElement nextPostButton;

	@FindBy(xpath = "//button[@class='ckWGn']")
	private WebElement closePostButton;

	@FindBy(xpath = "//*[@id='react-root']/section/main/div/header/section/ul/li[2]/a")
	private WebElement linkFollowers;

	@FindBy(xpath = "//*[@id='react-root']/section/main/div/header/section/ul/li[3]/a")
	private WebElement linkWeFollow;

	@FindBy(xpath = "//a[contains(@class,'coreSpriteDesktopNavProfile')]")
	private WebElement profileIcon;

	@FindBy(xpath = "html/body/div[3]/div/div/div[1]/div[2]/button")
	private WebElement closeButton;

	@FindBy(xpath = "//a[contains (@class,'notranslate')]")
	private List<WebElement> listAccountNameWhoWeFollow;

	@FindBy(xpath = "//*[@id='react-root']/section/main/div/header/section/div[1]/span/span[1]/button")
	private WebElement followingButton;

	@FindBy(xpath = "html/body/div[3]/div/div/div/div[3]/button[1]")
	private WebElement unfollowButton;

	public void clickOnParameters() {
		parameters.click();
	}

	public void clickNotNowNotifications() {
		NotNowNotifications.click();
	}

	public void clickOnLogOutButton() {
		logOutButton.click();
	}

	public void clickNotNowLink() {
		LinkNotNow.click();
	}

	public String getTextNotNowNotification() {
		String profile = NotNowNotifications.getText();
		return profile;
	}

	public void clickOnProfileUser() {
		profileUser.click();
	}

	public void waitElementNotNowPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Not Now']")));
	}

	public void waitElementSearchFieldPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']]")));
	}

	public WebElement waitForFirstItemInDropDownPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fuqBx']/a[1]")));
		return dinamicElement;
	}

	public void waitForPageLoads(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnFirstItemInDropDown() {
		waitForFirstItemInDropDownPresent().click();
	}

	public void clickOnClosePostButton() {
		closePostButton.click();
	}

	public void randonWaitBeforeAction(int time) {
		try {
			Thread.sleep((long) (Math.random() * time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFollowIn90PercentOfCases() {
		double d = Math.random() * 100;
		if ((d -= 90) < 0) {
			randonWaitBeforeAction(3000);
			followButton.click();
		} else {
			randonWaitBeforeAction(3000);
			nextPostButton.click();
		}
	}

	public void iteraction() {
		firstRecentPost.click();
		int count = 0;
		do {
			if (FollowOrNot() == true) {// || FollowAdexinOrNot() == false
				insertAccountName();
				clickFollowIn90PercentOfCases();
				count++;
			} else {
				nextPostButton.click();
			}
		} while (count < numbersOfAccountsWhoWeFollow);
	}

	public void clickFollow() {
		List<String> hashTags = new ArrayList<String>(6);

		hashTags.add(new String(tag1));
		hashTags.add(new String(tag2));
		hashTags.add(new String(tag3));
		hashTags.add(new String(tag4));
		hashTags.add(new String(tag5));

		int count = 0;
		do {
			searchField.sendKeys(hashTags.get(0));
			clickOnFirstItemInDropDown();
			waitForPageLoads(3000);
			hashTags.remove(0);
			System.out.println(hashTags);
			iteraction();
			clickOnClosePostButton();
			count++;
		} while (count < 5);

	}

	public boolean FollowOrNot() {
		waitForPageLoads(3000);
		String str1;
		try {
			str1 = followButton.getText();
			if (str1.equals("Follow")) {
				return true;
			}else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}

	}

	// public boolean FollowOrNot() {
	// waitForPageLoads(3000);
	// String str1;
	// try {
	// str1 = followButton.getText();
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// return false;
	// }
	// if (str1.equals("Follow")) {
	// return true;
	// }else {
	// return false;
	// }
	// }
	public boolean FollowAdexinOrNot() {
		waitForPageLoads(3000);
		String str2 = getAccountName();
		if (str2.equals("adexincom")) {
			return false;
		} else {
			return true;
		}
	}

	public WebElement getFirstRecentPost() {
		return firstRecentPost;
	}

	public WebElement getNextPostButton() {
		return nextPostButton;
	}

	public String getAccountName() {
		String name;
		name = accountName.getAttribute("title");
		System.out.println(name);
		return name;
	}

	public void insertAccountName() {
		AccountDao accountDao = new AccountDaoImple();
		Account addingAccount = new Account();
		addingAccount.setNikName(getAccountName());
		addingAccount.setDate(getDateOfTaday());
		addingAccount.setChecked("false");
		addingAccount.setFriend("false");
		accountDao.addWeFollowedAccount(addingAccount);
	}

	public java.sql.Date getDateOfTaday() {
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		return date;
	}

	public void getAllAccountsNameWhoFollowUs() throws InterruptedException {
		waitForPageLoads(3000);
		profileIcon.click();
		linkFollowers.click();
		String element;
		for (int i = 0; i < listAccountNameWhoFollow.size(); i++) {
			element = listAccountNameWhoFollow.get(i).getAttribute("title");
			System.out.println(element);
		}
	}
}
