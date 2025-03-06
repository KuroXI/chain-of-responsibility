package chain;

import chain.handlers.HazardousCollector;
import chain.handlers.OrganicCollector;
import chain.handlers.RecyclableCollector;
import model.WasteContainer;

public class WasteCollectionSystem implements WasteCollector {
	private WasteCollector chain;
WW
	public WasteCollectionSystem() {
		OrganicCollector organicCollector = new OrganicCollector();
		RecyclableCollector recyclableCollector = new RecyclableCollector();
		HazardousCollector hazardousCollector = new HazardousCollector();

		organicCollector.setNextChain(recyclableCollector);
		recyclableCollector.setNextChain(hazardousCollector);

		this.chain = organicCollector;
	}

	@Override
	public void setNextChain(WasteCollector nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void handleRequest(WasteContainer container) {
		if (!container.isEmpty()) {
			chain.handleRequest(container);
			System.out.println();
		} else {
			System.out.println("Waste container is empty");
		}
	}
}
