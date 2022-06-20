package crypto;

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
    public double resultDepAmountnow(){
        double value = resultQuantityOfTokens() * getXlmDouble();
        return value;
    }

    public double resultProfit(){
        double value = resultDepAmountnow() - getDepAmount();
        return value;
    }

    public void outputResultCalc(){
        System.out.println("Депозит: " + getDepAmount()+" Цена покупки: " + getTokenPriceAtBuyMoment() +
                " Текущая цена: " + getXlmDouble() + " Количество токенов: " + resultQuantityOfTokens() +
                " Депозит сейчас: " + resultDepAmountnow() + " Profit: " + resultProfit());
    }


    public double getXlmDouble() {
        return xlmDouble;
    }

    public void setXlmDouble(double xlmDouble) {
        this.xlmDouble = xlmDouble;
    }

    public double getDepAmount() {
        return depAmount;
    }

    public void setDepAmount(double depAmount) {
        this.depAmount = depAmount;
    }

    public double getTokenPriceAtBuyMoment() {
        return tokenPriceAtBuyMoment;
    }

    public void setTokenPriceAtBuyMoment(double tokenPriceAtBuyMoment) {
        this.tokenPriceAtBuyMoment = tokenPriceAtBuyMoment;
    }

    public double getQuantityOfTokens() {
        return quantityOfTokens;
    }

    public void setQuantityOfTokens(double quantityOfTokens) {
        this.quantityOfTokens = quantityOfTokens;
    }

    public double getDepAmountRightNow() {
        return depAmountRightNow;
    }

    public void setDepAmountRightNow(double depAmountRightNow) {
        this.depAmountRightNow = depAmountRightNow;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
