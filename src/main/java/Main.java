import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRouteBuilder.class);

    public static void main(String[] args) throws Exception {
        org.apache.camel.main.Main main = new org.apache.camel.main.Main();
        main.addRouteBuilder(new SimpleRouteBuilder());
        logger.info("Next call is blocking, ctrl-c to exit\n");
        main.run();
    }
}

class SimpleRouteBuilder extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRouteBuilder.class);

    public void configure() throws Exception {
        from("file:input")
            .log(LoggingLevel.INFO, logger, "move file ${headers."+ Exchange.FILE_NAME+"} from input folder to output")
            .to("file:output");
    }

}