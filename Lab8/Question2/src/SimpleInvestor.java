public class SimpleInvestor implements Investor {
    private String name;
    private Strategy curentStrategy;

    public SimpleInvestor(String name) {
        this.name = name;
        this.curentStrategy = Strategy.MonitorOnly;
    }

    public String getName() {
        return this.name;
    }

    public Strategy addaptStrategy() {
        return this.curentStrategy;
    }

    public void update(String stockSymbol, double priceChange) {
        System.out.print(getName() + " was notified by the price change in " + stockSymbol + ": $" + priceChange);
        if (priceChange < 50) {
            System.out.println(" and change their strategy to " + Strategy.HedgingStrategies);
        } else {
            if (priceChange > 200) {
                System.out.println(" and change their strategy to " + Strategy.Transactions);

            } else {
                System.out.println(" and decide to do nothing ");
            }
        }
    }
}
