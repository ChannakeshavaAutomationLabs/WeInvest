/* 
 * @Aauthor: Channakeshava Puttaswamy
 */

package com.qa.testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testLibraries.Base_Lib;

public class AllWeatherStrategy_ExploreInvestmentIdeasPage extends Base_Lib{

	//Define Page objects/elements
	@FindBy(id="btn-explore79")
	WebElement exploreInvestementIdeas;
	
	@FindBy(xpath="//*[@id=\"page-top\"]/div[3]/section/div[1]/div/div/div/div/div[2]/div[1]/div[1]/a")
	WebElement customizePortfolio;

	@FindBy(xpath="//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[1]/div[3]/a")
	WebElement portfolioConstituentsCustomise;
	
	@FindBy(xpath="//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/input")
	WebElement sliderForSPDR;

	@FindBy(xpath="//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[1]/div[2]/a")
	WebElement portfolioConstituentsRebalance;
	
	@FindBy(xpath="//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[1]/div[4]/a")
	WebElement portfolioConstituentsInvestNow;
	
	//Initialize the Page Objects:
	public AllWeatherStrategy_ExploreInvestmentIdeasPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnExploreInvestmentIdeas(){
		exploreInvestementIdeas.click();
	}
	
	public void clickOnCustomizePortfolio(){
		customizePortfolio.click();
		pageWaitSync();		
	}

	public void clickOnportfolioConstituentsCustomise(){
		portfolioConstituentsCustomise.click();
		pageWaitSync();		
	}

	public void setSliderValueOfSPDR() throws Exception{
		//driver.findElement(By.xpath("//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/input")).sendKeys("value", "50");
		//sliderForSPDR.sendKeys("value","50");
		dragSlider(sliderForSPDR, 9, 0);
	}

	public void clickOnportfolioConstituentsRebalance(){
		portfolioConstituentsRebalance.click();	
	}

	public void clickOnportfolioConstituentsInvestNow(){
		portfolioConstituentsInvestNow.click();	
	}
}
