package chain;

import model.WasteContainer;

public interface WasteCollector {
	void setNextChain(WasteCollector nextChain);
	void handleRequest(WasteContainer container);
}
