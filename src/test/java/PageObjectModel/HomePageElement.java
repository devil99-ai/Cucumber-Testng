package PageObjectModel;

import org.openqa.selenium.By;

public class HomePageElement {
	public By login_or_signUp_btn = By.xpath("/html/body/a[2]");
	public By blr_to_chn_book_flight = By.xpath("/html/body/table/tbody/tr[2]/td[6]/a");
	public By From_dropDown = By.xpath("/html/body/form/table/tbody/tr/td[1]/select");
	public By To_dropdown=By.xpath("/html/body/form/table/tbody/tr/td[2]/select");
	public By submit_to_search_flight = By.xpath("/html/body/form/table/tbody/tr/td[3]/button");
	

}
