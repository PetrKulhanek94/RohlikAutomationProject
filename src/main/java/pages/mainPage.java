package pages;

public interface mainPage {

    String MAIN_PAGE_COOKIEBOX_XPATH = "//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]";
    String MAIN_PAGE_LOGIN_XPATH = "//span[text()='Přihlásit']";
    String MAIN_PAGE_LOGIN_MODAL_XPATH = "//div[text()='Nastavit doručovací adresu']";

    String MINA_PAGE_LOGIN_USERNAME_ID = "email";
    String MINA_PAGE_LOGIN_PASSWORD_ID = "password";
    String MAIN_PAGE_LOGIN_BTN_XPATH = "//button[@data-test='btnSignIn']";
    String MAIN_PAGE_AVATAR_XPATH = "//div[@class='sc-18g3ccf-6 fDcQri']";

    String MAIN_PAGE_MEMBERSHIP_ACTIVE_XPATH = "//div[@id='headerUser']/div[1]/div[1]";
}
