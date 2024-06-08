interface Investor {
    String getName();
    Strategy addaptStrategy();

    void update(String stockSymbol, double priceChange);
}
