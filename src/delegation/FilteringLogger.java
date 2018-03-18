package delegation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FilteringLogger implements ILogger {
	
	//Loggeren feilmeldingen skal sendes videre til hvis den går gjennom filtreringen
	private ILogger logger;
	//En HashMap for å holde oversikten over hvilke severitys som er aktive
	private Map<String,Boolean> severities;
	
	public FilteringLogger(ILogger logger, String...severities) {
		this.logger = logger;
		this.severities = new HashMap<String,Boolean>();
		Arrays.asList(severities).stream().forEach(s -> this.severities.put(s, true));
	}
	
	public boolean isLogging(String severity) {
		return this.severities.containsKey(severity) && this.severities.get(severity);
	}
	
	public void setIsLogging(String severity, boolean value) {
		this.severities.put(severity, value);
	}
	
	
	@Override
	public void log(String severity, String message, Exception exception) {
		if(isLogging(severity)) {
			this.logger.log(severity, message, exception);
		}
	}

}
