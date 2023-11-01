import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class C57_Log4j_UseProperties {
    //Logger ları import ederken dikkat edelim, hata alabiliriz...
    public static void main(String[] args) {

        //loglarımızı configure etmek için
        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C57_Log4j_UseProperties.class);

        logger.trace("bu bir trace mesajidir");//trace
        logger.debug("bu bir debug mesajidir");//debug
        logger.info("bu bir info mesajidir");//info
        logger.warn("bu bir warn mesajidir");//warn
        logger.error("bu bir error mesajidir");//error
        logger.fatal("bu bir fatal mesajidir");//fatal
    }
}
