
public class Startup {

    static objectSentenceTemplate[] sentenceTemplates;

    public static void main(String[] args) {

	sentenceTemplates = new objectSentenceTemplate[5];
	sentenceTemplates[0] = new objectSentenceTemplate("Hei", "Hei p� deg");
	sentenceTemplates[1] = new objectSentenceTemplate("Hva", "Masserart med sukker p�");
	sentenceTemplates[2] = new objectSentenceTemplate("Har du", "Jepp");
	sentenceTemplates[3] = new objectSentenceTemplate("Jeg har", "S� bra!");
	sentenceTemplates[4] = new objectSentenceTemplate("d�d", "Uffameg!");

	lesLinje("Hei, NyBot");
	lesLinje("Har du det bra?");
	lesLinje("Hva har du gjort idag?");
	lesLinje("Jeg har v�rt en tur i byen og handlet");
	lesLinje("Min bestemor er d�d");
	lesLinje("N�r betalte du NRK-lisensen?");
    }

    private static void lesLinje(String textInput) { // motta tekst
	System.out.println("Du sier: " + textInput);
	System.out.println("NyBot sier: " + lagRespons(textInput));
    }

    private static String lagRespons(String textInput) { // generer svar
	for (int X = 0; X < sentenceTemplates.length; X++) {
	    if (textInput.toLowerCase().contains(sentenceTemplates[X].trigger.toLowerCase())) {
		return sentenceTemplates[X].respons;
	    }
	}
	return "S� fint v�r vi har idag!";
    }

}
