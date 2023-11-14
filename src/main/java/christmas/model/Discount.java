package christmas.model;

import christmas.util.Constants.IntegerConstants;

public class Discount {
	private int mainMenuDiscount;
	private int dessertMenuDiscount;
	private int specialDiscount;
	private int dDayDiscount;

	public Discount() {
		mainMenuDiscount = IntegerConstants.ZERO;
		dessertMenuDiscount = IntegerConstants.ZERO;
		specialDiscount = IntegerConstants.ZERO;
		dDayDiscount = IntegerConstants.ZERO;
	}

	public void setMainMenuDiscount(int count) {
		mainMenuDiscount += count * IntegerConstants.WEEKEND_DISCOUNT;
	}

	public void setDessertMenuDiscount(int count) {
		dessertMenuDiscount += count * IntegerConstants.WEEKDAY_DISCOUNT;
	}

	public void setSpecialDiscount() {
		specialDiscount = IntegerConstants.SPECIAL_DISCOUNT;
	}

	public void setDDayDiscount(int totalDay) {
		dDayDiscount += IntegerConstants.D_DAY_DISCOUNT_START;
		dDayDiscount += IntegerConstants.D_DAY_DISCOUNT_PLUS * totalDay;
	}

	public int getMainMenuDiscount() {
		return mainMenuDiscount;
	}

	public int getDessertMenuDiscount() {
		return dessertMenuDiscount;
	}

	public int getSpecialDiscount() {
		return specialDiscount;
	}

	public int getDDayDiscount() {
		return dDayDiscount;
	}

	public int getTotalDiscount() {
		int totalDiscount = getSpecialDiscount() +
			getDessertMenuDiscount() +
			getMainMenuDiscount() +
			getDDayDiscount();
		return totalDiscount;
	}
}
