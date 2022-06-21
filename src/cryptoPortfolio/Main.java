package cryptoPortfolio;


import crypto.CryptoData;
import crypto.CryptoMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static crypto.CryptoData.cryptoOnlineName;
import static crypto.CryptoData.cryptoOnlinePrice;


public class Main {
    static double priceResultXlm;
    static double depAmount;
    static double tokenPriceAtBuyMoment;
    static String tokenName;
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

    }
}
