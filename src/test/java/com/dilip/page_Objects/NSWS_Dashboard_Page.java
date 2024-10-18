package com.dilip.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NSWS_Dashboard_Page {

	private static NSWS_Dashboard_Page dashboard_PageInstance;

	private NSWS_Dashboard_Page() {

	}

	public static NSWS_Dashboard_Page getInstance() {

		if(dashboard_PageInstance==null) {
			dashboard_PageInstance = new NSWS_Dashboard_Page();
		}

		return dashboard_PageInstance;

	}


	@FindBy(xpath = "//span[@class='organisation-name']")
	private WebElement OrganisationName;

	@FindBy(xpath  = "//div[@class='dashboard-title']")
	private WebElement DashboardFeatureClick;

	@FindBy(xpath = "//a[text()='PROFILE']")
	private WebElement ClickProfileFeature;
	
	@FindBy(xpath = "//h4[text()='CENTRAL APPROVALS']")
	private WebElement MouseOverCentralApprovals;

	public WebElement getOrganisationName() {

		return OrganisationName;
	}

	public WebElement getDashboardFeatureClick() {

		return DashboardFeatureClick;
	}

	public WebElement getClickProfileFeature() {

		return ClickProfileFeature;
	}

	public WebElement getMouseOverCentralApprovals() {
		
		return MouseOverCentralApprovals;
	}
	

}
