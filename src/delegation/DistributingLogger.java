package delegation;

import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {
	
	//En map over alle loggere denne loggeren har tilgang til
	private Map<String,ILogger> loggere;
	
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.loggere = new HashMap<String,ILogger>();
		this.loggere.put(ILogger.ERROR, errorLogger);
		this.loggere.put(ILogger.WARNING, warningLogger);
		this.loggere.put(ILogger.INFO, infoLogger);
	}
	
	public void setLogger(String severity, ILogger logger) {
		this.loggere.put(severity, logger);
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		//Hvis denne loggeren har tilgang til loggeren log vil bruke, så hent loggeren og log det
		if(this.loggere.containsKey(severity)) {
			this.loggere.get(severity).log(severity, message, exception);
		}
	}

}
