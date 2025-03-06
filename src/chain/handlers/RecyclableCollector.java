package chain.handlers;

import chain.WasteCollector;
import model.WasteContainer;

public class RecyclableCollector implements WasteCollector {
	private WasteCollector nextChain;

	@Override
	public void setNextChain(WasteCollector nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void handleRequest(WasteContainer container) {
		if(container.getType().equalsIgnoreCase("recyclable")) {
			System.out.println("Processing recyclable waste container");
			container.emptyContainer();
		} else {
			if(nextChain != null) {
				nextChain.handleRequest(container);
			} else {
				System.out.println("No handler available for this waste type: " + container.getType());
			}
		}
	}
}
