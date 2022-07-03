package pages;

public interface rohlicekPage {
    String ROHLICEK_CANCELATION_OF_MEMBERSHIP_XPATH = "//*[@id=\"pageFullWidth\"]/main/div/div[3]/div/div/a";
    String ROHLICEK_CONFIRMATION_OF_CANCELATION_XPATH = "//button[contains(@class,'sc-1232tqx-0 cyqUbs')]";
    String ROHLICEK_GET_MEMBERSHIP_XPATH = "//button[contains(@class,'sc-1232tqx-0 bfKMFa')]";
    String ROHLICEK_MODAL_AFTER_MEMBERSHIP_XPATH = "//div[contains(@class,'sc-1gw4qk2-0 jahDqW')]";
    String ROHLICEK_I_HAVE_KIDS_UNDER_12_XPATH = "//span[@class='inputPH']";
    String ROHLICEK_I_HAVE_A_BOY_XPATH = "(//button[@class='sc-1232tqx-0 hGdTEO'])[2]";
    String ROHLICEK_CHILD_FORM_XPATH = "//form[@class='sc-19tx4ma-1 LgCpk']";
    String ROHLICEK_CHILD_NAME_ID = "name";
    String ROHLICEK_CHILD_DOB_XPATH = "birthday";
    String ROHLICEK_REGISTER_BTN_XPATH = "(//button[@data-test='button'])[3]";
    String ROHLICEK_CONFIRMATION_MODAL_BTN_GO_SHOPPING_XPATH = "//button[contains(@class,'sc-1232tqx-0 cyqUbs')]";
}
