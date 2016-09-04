
public class Startup {

    public static void main(String[] args) {

	lesLinje("Hva koster GBP?");
	lesLinje("Hvor mye er $?");
	lesLinje("Hva ligger svenske kroner på?");
	lesLinje("Hvor mye for euro?");
    }

    private static void lesLinje(String textInput) { // motta tekst
	// System.out.println("Du sier: " + textInput);
	String currency = textInput;
	if ((textInput.contains("USD")) || (textInput.contains("$")) || (textInput.contains("US dollar"))
		|| (textInput.contains("amerikanske dollar"))) {
	    currency = "USD";
	}
	if ((textInput.contains("GBP")) || (textInput.contains("£")) || (textInput.contains("britiske pund"))) {
	    currency = "GBP";
	}
	if ((textInput.contains("SEK")) || (textInput.contains("svenske kroner"))
		|| (textInput.contains("svenska kronor"))) {
	    currency = "SEK";
	}
	if ((textInput.contains("EUR")) || (textInput.contains("euro"))
		|| (textInput.contains("€"))) {
	    currency = "EUR";
	}
	// System.out.println("currency=" + currency);
	double value = new Brain_Currency().GetCurrency(currency);
	System.out.println("Valutakursen for " + currency + " er " + value);
    }

}
