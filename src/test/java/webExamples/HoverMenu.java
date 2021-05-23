package webExamples;

public class HoverMenu {
	public static void main(String[] args) throws InterruptedException {
		webTestCommon testPage = new webTestCommon();
		String url = "http://crossbrowsertesting.github.io/hover-menu.html";

		String parentText1 = "Dropdown";
		String parentText2 = "Secondary Menu";

		String childText = "Secondary Action";

		testPage.open(url);
		testPage.hoverChoice(parentText1, parentText2, childText);
		testPage.close();
	}
}
