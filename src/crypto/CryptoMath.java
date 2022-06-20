package crypto;

import utils.Rounder;


public class CryptoMath {
    private double xlmDouble;
    private double depAmount;
    private double tokenPriceAtBuyMoment;
    private double quantityOfTokens;
    private double depAmountRightNow;
    private double profit;
    public CryptoMath(double depAmount,double tokenPriceAtBuyMoment,double parseTokenPrice){
        //Конструктор получает данные
        this.depAmount = depAmount;
        this.tokenPriceAtBuyMoment = tokenPriceAtBuyMoment;
        this.xlmDouble = parseTokenPrice;

    }

    public double resultQuantityOfTokens(){
        double value = getDepAmount() / getTokenPriceAtBuyMoment();
        return value;
    }
    public double resultDepAmountNow(){
        double value = resultQuantityOfTokens() * getXlmDouble();
        return value;
    }

    public double resultProfit(){
        double value = resultDepAmountNow() - getDepAmount();
        return value;
    }

    public void outputResultCalc(){
        System.out.println("Депозит: " + getDepAmount()+
                " Цена покупки: " + getTokenPriceAtBuyMoment() +
                " Текущая цена: " + getXlmDouble() +
                " Количество токенов: " + Rounder.roundDownTokens(resultQuantityOfTokens()) +
                " Депозит сейчас: " + Rounder.roundValueProfit(resultDepAmountNow()) +
                " Profit: " + Rounder.roundValueProfit(resultProfit()));
    }


    public double getXlmDouble() {
        return xlmDouble;
    }


    public double getDepAmount() {
        return depAmount;
    }


    public double getTokenPriceAtBuyMoment() {
        return tokenPriceAtBuyMoment;
    }

}
