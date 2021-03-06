package POSsys.dbHandler;

public class Discount {

	private double discountAmount = 0.90;

	private String customerId;

	public Discount(String customerId) {
		this.customerId = customerId;
	}

	public boolean checkDiscountValidity(String customerId) {
		return true; //checks database
	}

	/**
     * denna metod multiplicerar price med rabatt v�rdet och returnerar det
     * @param price
     * @return price
     */

	public double priceAfterDiscount(double price) {
		price *= discountAmount;
		return price; //checks database
	}

}
