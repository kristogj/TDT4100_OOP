package delegation;

//Det skal være tre andre klasse som implementerer dette grensesnittet
//DistrubutingLogger, FilteringLogger og StreamLogger
public interface ILogger {
	
	//Konstanter som bruker for å fortelle om noe om alvorlighetsgraden til feilmeldingen. Brukes i severity.
	public String ERROR = "error", WARNING = "warning", INFO = "info";
	
	//severity argumentet angir alvorlighetsgraden, og må være en av String-verdiene ovenfor.
	//message er en melding om hva som var feil
	//exception er et unntaksobjekt, som kan gi mer informasjon av hva som var feil, men kan også være null
    public void log(String severity, String message, Exception exception);

}
