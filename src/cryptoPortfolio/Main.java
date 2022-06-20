package cryptoPortfolio;


import crypto.CryptoData;
import crypto.CryptoMath;

import static crypto.CryptoData.cryptoOnlineName;
import static crypto.CryptoData.cryptoOnlinePrice;


public class Main {
    static double priceResultXlm;
    static double depAmount;
    static double tokenPriceAtBuyMoment;
    static String tokenName;
    public static void main(String[] args) {
        CryptoData data = new CryptoData();
        //Цена токена
        priceResultXlm = cryptoOnlinePrice(data.getUrlXlm());
        //Имя токена
        tokenName =cryptoOnlineName(data.getUrlXlm()) ;
        //Сумма вклада
        depAmount =data.setDepAmount();
        //Цена токена на момент покупки
        tokenPriceAtBuyMoment = data.tokenPriceAtByMoment();
        //Вычисления
        CryptoMath math = new CryptoMath(tokenName,depAmount,tokenPriceAtBuyMoment,priceResultXlm);
        math.outputResultCalc();
    }
}
