package webExamples;

import static org.junit.Assert.*;

import cucumber.api.java.ja.かつ;
import cucumber.api.java.ja.ならば;
import cucumber.api.java.ja.もし;
import cucumber.api.java.ja.前提;

public class StepDefinitions {
	private webTestCommon webCommon = new webTestCommon();

/**
 * テスト条件系
 */
	@前提("^Selenium Test Example Pageページを開く$")
	public void openExamplePage() throws InterruptedException {
		String url = "http://crossbrowsertesting.github.io/selenium_example_page.html";
		webCommon.open(url);
	}

	@もし("^ブラウザを閉じる$")
	public void closeExamplePage() {
		webCommon.close();
	}
/**
 * 操作系
 * @throws InterruptedException
 */
	@もし("^\"([^\"]*)\"に\"([^\"]*)\"と入力$")
	public void inputBox(String box, String text) throws InterruptedException {
		String selector = null;

		switch(box) {
		case("Input Text Here"):
			selector = "text";
			break;
		case("テキストエリア"):
			selector = "textarea";
		}
		webCommon.inputAndWaitName(selector, text);
	}

	@もし("^\"([^\"]*)\"にチェックを入れる$")
	public void checkBox(String check) throws InterruptedException {
		String selector;

		selector = "checkbox";
		webCommon.clickAndWait_Name(selector);
	}

	@もし("^radioボタンを\"([^\"]*)\"で選択する$")
	public void radioButton(String value) throws InterruptedException {
		String selector;

//		selector = "radio";
//		webCommon.radioButton(selector, value);
		switch(value) {
		case("Radio 1"):
			selector = "radiobtn1";
			webCommon.btnClickAndWait_ID(selector);
			break;
		case("Radio 2"):
			selector = "(//input[@name='radio'])[2]";
			webCommon.btnClickAndWait_X(selector);
			break;
		default:
		}
	}

	@もし("^Option選択を\"([^\"]*)\"で選択する$")
	public void dropdownSelect(String option) throws InterruptedException {
		String selector;

		selector = "dropdown";
		webCommon.dropDownSelect_ID(selector, option);
	}

	@かつ("^\"([^\"]*)\"ボタンを押す$")
	public void clickButton(String button) throws InterruptedException {
		String selector = null;

		switch(button) {
		case("Show Message"):
			selector = "btn";
			break;
		case("Submit"):
			selector = "submitbtn";
			break;
		default:
		}
		webCommon.btnClickAndWait_ID(selector);
	}

    @もし("^\"([^\"]*)\"秒待つ$")
    public void wait(int sec) {
        webCommon.sleep(sec);
    }

/**
 * 検証系
 * @throws InterruptedException
 */
    @ならば("^画面に\"([^\"]*)\"と表示される$")
    public void iammessage(String message) throws InterruptedException {
    	String selector;

    	selector = "button-message";
    	assertTrue(webCommon.testTextID(selector, message));
    }

	@ならば("^画面の\"([^\"]*)\"に\"([^\"]*)\"と表示される$")
	public void verifyViewing(String area, String text) throws InterruptedException {
		String selector = null;

		switch(area) {
		case("Form Resultsのtext"):
			selector = "//*[@id=\"form-results\"]/div[1]/span[2]";
			break;
		case("Form Resultsのcheckbox"):
			selector = "//*[@id=\"form-results\"]/div[2]/span[2]";
			break;
		case("Form Resultsのselect"):
			selector = "//*[@id=\"form-results\"]/div[3]/span[2]";
			break;
		case("Form Resultsのradio"):
			selector = "//*[@id=\"form-results\"]/div[4]/span[2]";
			break;
		case("Form Resultsのtextarea"):
			selector = "//*[@id=\"form-results\"]/div[5]/span[2]";
			break;
		default:
		}
		assertTrue(webCommon.testTextX(selector, text));
	}
}
