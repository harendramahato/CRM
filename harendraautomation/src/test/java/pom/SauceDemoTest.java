package pom;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;

import object_repository.SauceDemoPage;

public class SauceDemoTest {

	public static void main(String[] args) {

		// ============================================================
		// TEST DATA
		// ============================================================

		String url = "https://www.saucedemo.com/";

		String username = "standard_user";

		String password = "secret_sauce";

		String firstName = "Harendra";

		String lastName = "Mahato";

		String postalCode = "831001";

		WebDriver driver = null;

		try {

			// ============================================================
			// STEP 1: LAUNCH BROWSER
			// ============================================================

			driver = new EdgeDriver();

			// ============================================================
			// STEP 2: MAXIMIZE BROWSER
			// ============================================================

			driver.manage().window().maximize();

			// ============================================================
			// STEP 3: IMPLICIT WAIT
			// ============================================================

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// ============================================================
			// STEP 4: OPEN APPLICATION
			// ============================================================

			driver.get(url);

			// ============================================================
			// STEP 5: LOGIN
			// ============================================================

			SauceDemoPage sdp = new SauceDemoPage(driver);

			WebElement usernameField = sdp.getUsernameField();

			WebElement passwordField = sdp.getPasswordField();

			WebElement loginButton = sdp.getLoginButton();

			driver.navigate().refresh();

			// usernameField = driver.findElement(By.id("user-name"));

			usernameField.sendKeys(username);

			// passwordField = driver.findElement(By.id("password"));

			passwordField.sendKeys(password);

			// loginButton = driver.findElement(By.id("login-button"));

			loginButton.click();

			// Verify login

			String inventoryUrl = driver.getCurrentUrl();

			if (inventoryUrl.contains("inventory.html")) {

			} else {

				throw new RuntimeException("Login verification failed.");

			}

			// ============================================================
			// STEP 6: ADD PRODUCT TO CART
			// ============================================================

			WebElement addTocartButton = sdp.getAddTocartButton();

			addTocartButton.click();

			// Verify cart badge

			String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

			if (cartCount.equals("1")) {

			} else {

				throw new RuntimeException("Cart count is not 1.");

			}

			// ============================================================
			// STEP 7: OPEN CART
			// ============================================================

			driver.findElement(By.className("shopping_cart_link")).click();

			// Verify cart page

			if (driver.getCurrentUrl().contains("cart.html")) {

			} else {

				throw new RuntimeException("Cart page was not opened.");

			}

			// ============================================================
			// STEP 8: VERIFY PRODUCT IN CART
			// ============================================================

			String productName = driver.findElement(By.className("inventory_item_name")).getText();

			if (productName.equals("Sauce Labs Backpack")) {

			} else {

				throw new RuntimeException("Product verification failed.");

			}

			// ============================================================
			// STEP 9: CHECKOUT
			// ============================================================

			driver.findElement(By.id("checkout")).click();

			// ============================================================
			// STEP 10: ENTER CHECKOUT INFORMATION
			// ============================================================

			driver.findElement(By.id("first-name")).sendKeys(firstName);

			driver.findElement(By.id("last-name")).sendKeys(lastName);

			driver.findElement(By.id("postal-code")).sendKeys(postalCode);

			driver.findElement(By.id("continue")).click();

			// ============================================================
			// STEP 11: VERIFY CHECKOUT OVERVIEW
			// ============================================================

			String checkoutProduct = driver.findElement(By.className("inventory_item_name")).getText();

			if (checkoutProduct.equals("Sauce Labs Backpack")) {

			} else {

				throw new RuntimeException("Product missing from checkout overview.");

			}

			// ============================================================
			// STEP 12: FINISH ORDER
			// ============================================================

			driver.findElement(By.id("finish")).click();

			// ============================================================
			// STEP 13: VERIFY ORDER SUCCESS
			// ============================================================

			String confirmationMessage = driver.findElement(By.className("complete-header")).getText();

			if (confirmationMessage.equals("Thank you for your order!")) {

			} else {

				throw new RuntimeException("Order confirmation message not found.");

			}

			// ============================================================
			// STEP 14: LOGOUT
			// ============================================================

			driver.findElement(By.id("react-burger-menu-btn")).click();

			driver.findElement(By.id("logout_sidebar_link")).click();

			// Verify logout

			if (driver.getCurrentUrl().equals(url)) {

			} else {

				throw new RuntimeException("User was not redirected to Login page.");

			}

		} catch (Exception e) {

		} finally {

			// ============================================================
			// STEP 15: CLOSE BROWSER
			// ============================================================

			 driver.quit();

		}

	}

}
