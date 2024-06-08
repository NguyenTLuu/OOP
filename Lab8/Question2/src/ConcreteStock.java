import java.util.ArrayList;
import java.util.List;

public class ConcreteStock implements Stock {
    private String symbol;
    private double currentPrice;
    private List<Investor> investors = new ArrayList<>();

    public ConcreteStock(String sysbol, double currentPrice) {
        this.symbol = sysbol;
        this.currentPrice = currentPrice;
    }

    public void addObserver(Investor investor) {
        this.investors.add(investor);
    }

    public void removeObserver(Investor investor) {
        this.investors.remove(investor);
    }

    public void notifyInvestors(double priceChange) {
        currentPrice = priceChange;
        for (Investor investor : investors) {
            investor.update(symbol, priceChange);
        }
    }
}
