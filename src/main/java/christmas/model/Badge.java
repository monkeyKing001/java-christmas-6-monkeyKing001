package christmas.model;

import christmas.util.Constants.IntegerConstants;
import christmas.util.Constants.StringConstants;

public enum Badge {
	STAR(StringConstants.STAR_BADGE_NAME, IntegerConstants.STAR_BADGE_PRICE),
	TREE(StringConstants.TREE_BADGE_NAME, IntegerConstants.TREE_BADGE_PRICE),
	SANTA(StringConstants.SANTA_BADGE_NAME, IntegerConstants.SANTA_BADGE_PRICE),
	NONE(StringConstants.NONE_BADGE_NAME, IntegerConstants.ZERO);
	private final String name;
	private final int price;

	private Badge(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}
}
