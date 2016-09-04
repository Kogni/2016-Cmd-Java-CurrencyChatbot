
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Brain_Currency {

    Startup Class_Controller;
    URL url;
    HttpURLConnection connection;
    StringBuffer DataImported = new StringBuffer();

    public Brain_Currency() {
	// this.Class_Controller = Class_Controller;

    }

    public double GetCurrency(String currency) {
	if (currency.contains("USD")) {
	    return GetUSD(currency);
	}
	return GetUSD(currency);
	// System.out.println("Gjenkjente ikke valuta " + currency);
	// return 0;
    }

    public double GetUSD(String currency) {

	try {
	    url = new URL("http://themoneyconverter.com/" + currency + "/NOK.aspx");

	    connection = (HttpURLConnection) url.openConnection();

	    URLConnection conn;

	    conn = url.openConnection();

	    conn.setRequestProperty("User-Agent",
		    "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");

	    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String str;

	    while ((str = in.readLine()) != null) {
		DataImported.append(str);
	    }
	    try {
		String Buffer = DataImported.toString().toLowerCase();
		String Temp = Buffer;
		// System.out.println("0 " + Temp.indexOf("<div id='tmc-header'>"));
		Temp = Temp.substring(Temp.indexOf("<div id='tmc-header'>") + "<div id='tmc-header'>".length());
		// System.out.println("A " + Temp);
		Temp = Temp.substring(Temp.indexOf("latest exchange rates:") + "latest exchange rates:".length());
		// System.out.println("B " + Temp);
		Temp = Temp.substring(Temp.indexOf(" = ") + " = ".length());
		// System.out.println("C " + Temp);
		// Temp = Temp.substring( Temp.indexOf("1 United States Dollar = ")+"1 United States Dollar = ".length() );
		// System.out.println("D " + Temp);
		Temp = Temp.substring(0, Temp.indexOf(" norwegian krone"));
		Double currValue = 0.0;
		// System.out.println("E " + Temp);
		try {
		    currValue = Double.parseDouble(Temp);
		    return currValue;
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return 0;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return 0;
    }

}
