import chain.WasteCollectionSystem;
import model.WasteContainer;

public class Main {
	public static void main(String[] args) {
		WasteCollectionSystem system = new WasteCollectionSystem();

		WasteContainer organic = new WasteContainer("organic", 100);
		WasteContainer recyclable = new WasteContainer("recyclable", 200);
		WasteContainer hazardous = new WasteContainer("hazardous", 50);
		WasteContainer electronic = new WasteContainer("electronic", 50);

		organic.addWaste(100);
		recyclable.addWaste(200);
		hazardous.addWaste(50);
		electronic.addWaste(50);

		System.out.println();
		system.handleRequest(organic);
		system.handleRequest(recyclable);
		system.handleRequest(hazardous);
		system.handleRequest(electronic);
		System.out.println();

		// should still process even though containers are not full
		organic.addWaste(50);
		recyclable.addWaste(100);
		hazardous.addWaste(25);

		System.out.println();
		system.handleRequest(organic);
		system.handleRequest(recyclable);
		system.handleRequest(hazardous);
		System.out.println();

		// should not process when containers are empty
		System.out.println();
		system.handleRequest(organic);
		system.handleRequest(recyclable);
		system.handleRequest(hazardous);
		System.out.println();

		// should not add a waste when the added waste exceed the maximum capacity
		organic.addWaste(101);
		recyclable.addWaste(201);
		hazardous.addWaste(51);

		System.out.println();
		system.handleRequest(organic);
		system.handleRequest(recyclable);
		system.handleRequest(hazardous);
		System.out.println();
	}
}
