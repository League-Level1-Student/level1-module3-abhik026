package _02_backpack;

public class BackpackRunner {
	public static void main(String[] args) {
		new Backpack().packAndCheck();
		Backpack pack = new Backpack();
		Pencil pence = new Pencil();
		Ruler rules = new Ruler();
		Textbook text = new Textbook();
		pack.putInBackpack(pence);
		pack.putInBackpack(rules);
		pack.putInBackpack(text);
		pack.goToSchool();
	}
}
