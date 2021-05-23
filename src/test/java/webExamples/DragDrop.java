package webExamples;

public class DragDrop {
	public static void main(String[] args) throws InterruptedException {
		webTestCommon testPage = new webTestCommon();
		String url = "http://crossbrowsertesting.github.io/drag-and-drop.html";

		String source = "draggable";
		String target = "droppable";
		testPage.open(url);
		testPage.dragdrop(source, target);
		testPage.close();
	}
}
