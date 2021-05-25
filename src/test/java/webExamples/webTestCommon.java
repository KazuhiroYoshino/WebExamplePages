package webExamples;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class webTestCommon {
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public int moveX;
    public int moveY;

    private boolean acceptNextAlert = true;
    public String alertPrompt = null;

	public void open(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
		webDriver = new ChromeDriver();
		Thread.sleep(3000);
		webDriver.get(url);
		Thread.sleep(2000);
        wait = new WebDriverWait(webDriver, 10);
	}

	public void close() {
		webDriver.quit();
	}

    public void sleep(int sec) {
        long msec = sec * 1000;
        try {
            Thread.sleep(msec);
        } catch (Exception e) {
        }
    }

    public void refresh() throws InterruptedException {
    	webDriver.navigate().refresh();
    	Thread.sleep(5000);
    }

/**
 * 表示されるリンクテキストを順にマウスオーバーして、最後にクリックする操作
 * @param parentText1、最初に表示されるリンクテキスト
 * @param parentText2、次に表示されるリンクテキスト
 * @param childText、クリックしたいリンクテキスト
 * @throws InterruptedException
 */
	public void hoverChoice(String parentText1, String parentText2, String childText) throws InterruptedException {
    	WebElement element1 = webDriver.findElement(By.partialLinkText(parentText1));
		Actions actions1 = new Actions(webDriver);
		actions1.moveToElement(element1);
		actions1.perform();
		Thread.sleep(500);
    	WebElement element2 = webDriver.findElement(By.partialLinkText(parentText2));
		Actions actions2 = new Actions(webDriver);
		actions2.moveToElement(element2);
		actions2.perform();
		Thread.sleep(500);
    	WebElement element3 = webDriver.findElement(By.partialLinkText(childText));
		Actions actions3 = new Actions(webDriver);
		actions3.moveToElement(element3);
		actions3.perform();
		Thread.sleep(500);

		element3.click();
	}

/**
 * ドラッグアンドドロップ操作
 * @param source、移動元の要素
 * @param target、移動先の要素
 */
	public void dragdrop(String source, String target) {
	    WebElement sourceElement = webDriver.findElement(By.id(source));
	    WebElement targetElement = webDriver.findElement(By.id(target));
	    //移動元の要素をドラッグし移動先の要素へドラッグアンドドロップ
	    Actions action = new Actions(webDriver);
	    action.dragAndDrop(sourceElement,targetElement)
	               .perform();

	}

/**
 * エリア内の右クリック操作とポップアップメッセージでOKボタン操作
 * @param area
 * @throws InterruptedException
 */
	public void contextClick(String area) throws InterruptedException {
		WebElement spot = webDriver.findElement(By.id(area));
		Actions actionProvider = new Actions(webDriver);
		actionProvider.contextClick(spot).build().perform();
		Thread.sleep(1000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		webDriver.switchTo().alert();
		alert.accept();
	}

/**
 * マウス移動操作
 */
	public void moveByOffset(int xOffset, int yOffset) {
		Actions actionProvider = new Actions(webDriver);
		actionProvider.moveByOffset(xOffset, yOffset).build().perform();
	}

	/**
	 * センターに移動
	 */
	public void moveCenter() {
		Actions action = new Actions(webDriver);
		action.moveToElement(webDriver.findElement(By.xpath("//body")))
		.click()
		.build()
		.perform();
//		new Actions(webDriver).moveToElement(findElement(By.xpath("//body")).click().build().perform();
	}

	/**
	 *
	 */
	public void getWinSize() {
		moveX = (webDriver.manage().window().getSize().getWidth()) / 2;
		moveY = (webDriver.manage().window().getSize().getHeight()) / 2;
	}
/**
 * ボタンクリック操作
 */
    /*
     * Locater名が、id属性のボタンをクリックする
     */
    public void btnClickAndWait_ID(String selector) throws InterruptedException {
		WebElement element = webDriver.findElement(By.id(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		Thread.sleep(1000);
    }

    public void btnClickAndWait_X(String selector) throws InterruptedException {
		WebElement element = webDriver.findElement(By.xpath(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		Thread.sleep(1000);
    }

    public void btnClickAndWait_CSS(String selector) throws InterruptedException {
		WebElement element = webDriver.findElement(By.cssSelector(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		Thread.sleep(1000);
    }

    public void clickAndWait_Name(String selector) throws InterruptedException {
		WebElement element = webDriver.findElement(By.name(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		Thread.sleep(1000);

    }

    /**
     * ポッフアップ画面操作
     */
    public void btnClickOK(String button) {
        Alert alert = webDriver.switchTo().alert();

    	switch(button) {
    	case("OK"):
    		alert.accept();
    		break;
    	case("CANCEL"):
    		alert.dismiss();
    		break;
    	default:
    	}
    }

/**
 * 入力系
 *
 */
    /**
     * テキストボックス、インプットボックス
     */
    public void inputAndWaitID(String selector, String text) throws InterruptedException {
        WebElement element = webDriver.findElement(By.id(selector));
    	Actions actions = new Actions(webDriver);
    	actions.moveToElement(element);
    	actions.perform();
    	Thread.sleep(500);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.clear();
        Thread.sleep(500);
        element.sendKeys(text);
    }

    public void inputAndWaitName(String selector, String text) throws InterruptedException {
        WebElement element = webDriver.findElement(By.name(selector));
    	Actions actions = new Actions(webDriver);
    	actions.moveToElement(element);
    	actions.perform();
    	Thread.sleep(500);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.clear();
        Thread.sleep(500);
        element.sendKeys(text);
    }

    public void popUpInputBox(String text) throws InterruptedException {
    	Alert alert = webDriver.switchTo().alert();
    	alert.sendKeys(text);
    	Thread.sleep(500);
    }

    /**
     * チェックボックス
     */
    public void checkBox(String selector) {

    }

    /**
     * ラジオボタン
     */
    public void radioButton(String selector, String value) {
    	List <WebElement>radioButtons = webDriver.findElements(By.name(selector));
    	for(WebElement radioButton : radioButtons) {
    		if(radioButton.getAttribute("value").equals(value)) {
    			radioButton.click();
    		}
    	}
    }

    /**
     * ドロップダウンメニュー
     */
    public void dropDownSelect_ID(String selector, String selText) throws InterruptedException {
		WebElement element = webDriver.findElement(By.id(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(1000);
        Select output_Select = new Select(element);
        output_Select.selectByVisibleText(selText);
        Thread.sleep(500);

    }


/**
 * 画面から取得系
 */

/**
 * 検証系
 */
    /**
     * 指定したエレメントのテキストが期待値通りかチェックする
     */
    public boolean testTextID(String selector, String text) throws InterruptedException {
    	String resultText;
    	boolean res;

    	WebElement element = webDriver.findElement(By.id(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);

    	wait.until(ExpectedConditions.visibilityOf(element));
    	resultText = element.getText();
    	if(resultText.equalsIgnoreCase(text)) {
    		res = true;
    	}else {
    		res = false;
    	}

    	return res;
    }

    public boolean testTextX(String selector, String text) throws InterruptedException {
    	String resultText;
    	boolean res;

    	WebElement element = webDriver.findElement(By.xpath(selector));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(500);

    	wait.until(ExpectedConditions.visibilityOf(element));
    	resultText = element.getText();
    	if(resultText.equalsIgnoreCase(text)) {
    		res = true;
    	}else {
    		res = false;
    	}

    	return res;
    }

    /**
     * ポッフアップ画面の検証
     */
	public boolean isPopUpPresent(String text) throws InterruptedException {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();

        boolean res = alertText.contains(text);
        return res;
	}

}
