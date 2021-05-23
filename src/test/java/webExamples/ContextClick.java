package webExamples;

public class ContextClick {
	public static void main(String[] args) throws InterruptedException {
		webTestCommon testPage = new webTestCommon();
		String url = "https://the-internet.herokuapp.com/context_menu";

		String area = "hot-spot";
		testPage.open(url);
		testPage.contextClick(area);
		testPage.close();
	}
}
