package crypto;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CryptoData {
    private String urlXlm ="https://www.binance.com/api/v3/ticker/price?symbol=XLMUSDT";
    //Получает json
    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }
    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    //Получает json-over//

    //Получает цену валюты
    public static double cryptoOnlinePrice (String setUrl){
        JSONParser parser = new JSONParser();
        String result = null;
        double castedDouble=0.00;
        try{
            JSONObject jsonObject = (JSONObject) parser.parse(jsonGetRequest(setUrl));
            result = (String) jsonObject.get("price");
            castedDouble = Double.parseDouble(result);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return castedDouble;
    }
    //Получает цену валюты-over

    //Получить имя валюты
    public static String cryptoOnlineName (String setUrl){
        JSONParser parser = new JSONParser();
        String result = null;
        double castedDouble=0.00;
        try{
            JSONObject jsonObject = (JSONObject) parser.parse(jsonGetRequest(setUrl));
            result = (String) jsonObject.get("symbol");
//            castedDouble = Double.parseDouble(result);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    //Получить имя валюты-over

    public double setDepAmount(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert deposit amount");
        while (!scan.hasNextDouble()) {
            String str = scan.nextLine().trim();
            System.out.printf("\"%s\" - not a number!%nEnter amount: ", str);
        }
        double value= scan.nextDouble();

        while (value <= 0) {
            System.out.println("Incorrect value! Enter quantity: ");
            while (!scan.hasNextDouble()) {
                String str = scan.next().trim();
                System.out.printf("\"%s\" - not a number!%nEnter amount: ", str);
            }
            value = scan.nextDouble();
        }

        return value;
    }

    public double tokenPriceAtByMoment(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert token price at buy moment");

        while (!scan.hasNextDouble()) {
            String str = scan.nextLine().trim();
            System.out.printf("\"%s\" - not a number!%nEnter amount: ", str);
        }
        double value= scan.nextDouble();

        while (value <= 0) {
            System.out.println("Incorrect value! Enter quantity: ");
            while (!scan.hasNextDouble()) {
                String str = scan.next().trim();
                System.out.printf("\"%s\" - not a number!%nEnter amount: ", str);
            }
            value = scan.nextDouble();
        }
        return value;
    }

    public String getUrlXlm() {
        return urlXlm;
    }
}
