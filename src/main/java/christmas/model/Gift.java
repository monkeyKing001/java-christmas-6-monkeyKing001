package christmas.model;

import christmas.model.menu.Beverages;
import christmas.util.Constants;

public class Gift {
	private boolean enableGetGift = false;
	private Beverages gift = Beverages.CHAMPAGNE;

	public Gift() {
	}

	public boolean EnableGetGift() {
		return enableGetGift;
	}

	public void setEnableGetGift() {
		enableGetGift = true;
	}

	public Beverages getGiftType() {
		return gift;
	}

	public int getGiftPrice() {
		return gift.getPrice();
	}

	public int getMyGiftPrice() {
		if (enableGetGift)
			return gift.getPrice();
		return Constants.IntegerConstants.ZERO;
	}
}
