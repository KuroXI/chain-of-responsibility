package model;

public class WasteContainer {
	private final String type;
	private final int capacity;
	private int amount;

	public WasteContainer(String type, int capacity) {
		this.type = type;
		this.capacity = capacity;
		this.amount = 0;
	}

	public void addWaste(int amount) {
		int newLevel = this.amount + amount;
		if (newLevel > capacity) {
			System.out.println(amount + " exceeds capacity of " + type + " waste with a capacity of " + capacity);
		} else {
			this.amount += amount;
			System.out.println(amount + " of " + type + " waste are added: " + this.amount + "/" + capacity);
		}
	}

	public boolean isEmpty() {
		return amount <= 0;
	}

	public String getType() {
		return type;
	}

	public void emptyContainer() {
		this.amount = 0;
		System.out.println(capitalizeType() + " waste container emptied");
	}

	private String capitalizeType() {
		return type.substring(0, 1).toUpperCase() + type.substring(1);
	}
}
