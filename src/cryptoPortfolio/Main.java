package cryptoPortfolio;
import crypto.CryptoData;
import crypto.CryptoMath;
import db.DBConnection;
import java.util.Scanner;

import static crypto.CryptoData.cryptoOnlineName;
import static crypto.CryptoData.cryptoOnlinePrice;


public class Main {
    private static double priceResultXlm;
    private static double depAmount;
    private static double tokenPriceAtBuyMoment;
    private static String tokenName;
    private static Double[] outputCrypto;
    public static void main(String[] args) {
        CryptoData data = new CryptoData();
        Scanner scan = new Scanner(System.in);
        System.out.println("Set token name: ");
        String value= scan.nextLine();

        //Цена токена
        priceResultXlm = cryptoOnlinePrice(data.tokenOption(value));
        //Имя токена
        tokenName =cryptoOnlineName(data.tokenOption(value));
        //Сумма вклада
        depAmount =data.setDepAmount();
        //Цена токена на момент покупки
        tokenPriceAtBuyMoment = data.tokenPriceAtByMoment();
        //Вычисления
        CryptoMath math = new CryptoMath(tokenName,depAmount,tokenPriceAtBuyMoment,priceResultXlm);
        math.outputResultCalc();
        // Цифры для ввода как тест 17.35  и 0.39(для отрицательного) 0.001 ( для положительного)

        //Готовый массив даблов
        outputCrypto = math.returnResultDouble();
        ////////////////////////////Sign to db////////////////////////////////////////////

        DBConnection crypto = new DBConnection();
        crypto.dbInsertion(tokenName,outputCrypto[0],outputCrypto[1],outputCrypto[2]
                ,outputCrypto[3],outputCrypto[4],outputCrypto[5]);
    }
}

