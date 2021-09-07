
public class WildCard {
	private String[] tricks;

	public WildCard() {
		tricks = new String[] { "street plant", "impossible", "no comply impossible", "flamingo",
				"strawberry milkshake", "no comply tre flip", "primo slide", "casper flip", "hospital flip",
				"cancel flip", "late flip", "pressure flip", "late shuv" };
	}

	public String getTrick()// generate individual tricks here, put the final string together in main class
	{
		int index = (int) (Math.random() * tricks.length);
		String current = tricks[index];
		return current;
	}
}
