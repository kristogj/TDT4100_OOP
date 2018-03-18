package delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
	
	//Blir gitt i konstruktøren og styrer hvor feilmeldingen skal skrives til
	private OutputStream stream;
	private String formatString;
	
	public StreamLogger(OutputStream stream) {
		this.stream = stream;
		this.formatString = "%s: %s (%s)"; //eks "error: en feilmelding (IOException)"
	}
	
	
	@Override
	public void log(String severity, String message, Exception exception) {
		String logMessage = String.format(this.formatString,severity, message, exception);
		try {
			stream.write(logMessage.getBytes());
			stream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

}
