/* 
 * @Aauthor: Channakeshava Puttaswamy
 */

package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.testLibraries.Base_Lib;
import com.qa.testPages.AllWeatherStrategy_ExploreInvestmentIdeasPage;

public class AllWeatherStrategy_ExploreInvestmentIdeasPageTest extends Base_Lib{
	AllWeatherStrategy_ExploreInvestmentIdeasPage allWeatherStrategy_ExploreInvestmentIdeasPage;
	
	public AllWeatherStrategy_ExploreInvestmentIdeasPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		//Test Step: Navigate to http://beta.weinvest.net/model-portfolio
		//Expected Result: Weinvest Recommendation page should display 
		initialization();
		Assert.assertEquals("WeInvest | Simple, Smart, Transparent Investing", driver.getTitle());
		
		//Initiate AllWeatherStrategy_ExploreInvestmentIdeasPage
		allWeatherStrategy_ExploreInvestmentIdeasPage = new AllWeatherStrategy_ExploreInvestmentIdeasPage();
	}
	
	@Test
	public void clickOnExploreInvestmentIdeas() throws Exception {
		//Test Step: Click on "Explore Investment Ideas" under "All Weather Strategy" section
		allWeatherStrategy_ExploreInvestmentIdeasPage.clickOnExploreInvestmentIdeas();
		
		//Test Step: Click on button “Customize Portfolio” option
		allWeatherStrategy_ExploreInvestmentIdeasPage.clickOnCustomizePortfolio();
		
		//Test Step: Click on "Customise" option
		allWeatherStrategy_ExploreInvestmentIdeasPage.clickOnportfolioConstituentsCustomise();
		
		//Test Step: Change slider of “SPDR S&P 500 ETF TRUST SPY US EQUITY” to 50%
		allWeatherStrategy_ExploreInvestmentIdeasPage.setSliderValueOfSPDR();
		
		//Test Step: Click on “Rebalance” button
		allWeatherStrategy_ExploreInvestmentIdeasPage.clickOnportfolioConstituentsRebalance();
		
		//Test Step: Click on “Invest Now” button
		allWeatherStrategy_ExploreInvestmentIdeasPage.clickOnportfolioConstituentsInvestNow();
	}
		
	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}
}
