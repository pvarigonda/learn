package xmlprocess;

import java.util.List;

@javax.xml.bind.annotation.XmlRootElement(name="records")
public class Records {

	private List<Trade> trades;

	public List<Trade> getTrades() {
		return trades;
	}

	@javax.xml.bind.annotation.XmlElement(name="trade")
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	
}
