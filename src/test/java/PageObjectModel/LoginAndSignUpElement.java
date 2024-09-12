package PageObjectModel;

import org.openqa.selenium.By;

public class LoginAndSignUpElement {
	public By Not_a_member_Signup = By.xpath("/html/body/form/table/tbody/tr[3]/td/a");
	public By input_emailid_for_signUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By input_passwd_for_signUp = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By input_confirm_passwd_for_signUp = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input");
	public By input_name_for_signUp  = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input");
	public By input_city_for_signUp = By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input");
	public By input_address_for_signUp = By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input");
	public By signup_btn_after_fill_details = By.xpath("/html/body/form/table/tbody/tr[7]/td/button");
	public By input_emailid_for_login = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By input_password_for_login = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By Login_to_continue_checking_flights = By.xpath("/html/body/a[3]");
	public By submit_login_btn = By.xpath("/html/body/form/table/tbody/tr[3]/td/button");

}
