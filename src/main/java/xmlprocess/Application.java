package xmlprocess;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class Application {

    public static void main(String[] args) {
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:xmlprocess-context.xml");
    	
    	StaxEventItemReader<Trade> xmlStaxEventItemReader = new StaxEventItemReader<Trade>();
    	Resource resource = ctx.getResource("trades.xml");
    	
    	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    	marshaller.setClassesToBeBound(Trade.class);
    	
//		javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(Trade.class);
//		javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    	/*    	Map<String, String>aliases = new HashMap<String, String>();
    	
    	aliases.put("trade","xmlprocess.Trade");
    	aliases.put("price","java.math.BigDecimal");
    	aliases.put("customer","java.lang.String");
    	aliases.put("quantity","java.math.BigDecimal");
    	aliases.put("isin","java.lang.String");
    	
    	XStreamMarshaller marshaller = new XStreamMarshaller();
    	try {
			marshaller.setAliases(aliases);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
    	xmlStaxEventItemReader.setUnmarshaller(marshaller);
    	xmlStaxEventItemReader.setResource(resource);
    	xmlStaxEventItemReader.setFragmentRootElementName("trade");
    	xmlStaxEventItemReader.open(new ExecutionContext());

    	boolean hasNext = true;

    	Trade trade = null;

    	while (hasNext) {
    	    try {
				trade = xmlStaxEventItemReader.read();
			} catch (UnexpectedInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    if (trade == null) {
    	        hasNext = false;
    	    }
    	    else {
    	        System.out.println(trade);
    	    }
    	}
    	

    }

}
