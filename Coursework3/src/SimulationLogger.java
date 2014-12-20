import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationLogger {

	public static void log(String msg) {

		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.INFO, msg);

	}
}
