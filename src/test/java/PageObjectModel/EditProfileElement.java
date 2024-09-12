package PageObjectModel;

import org.openqa.selenium.By;

public class EditProfileElement {
	public By edit_profile_btn = By.xpath("/html/body/a[3]");
	public By address = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input");
	public By password = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By confirm_passwd = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By update_btn = By.xpath("/html/body/form/table/tbody/tr[6]/td/button");

}
