public class main2 {
    public static void main(String[] args) {
        Stock appleStock = new ConcreteStock("APP",100) ;
        Stock dellstock = new ConcreteStock("DEll",100) ;
// Register basic investor
        Investor tomInvestor = new SimpleInvestor ("Tom");
        Investor bobInvestor = new SimpleInvestor ("Bob") ;
        appleStock.addObserver (tomInvestor) ;
        appleStock. addObserver (bobInvestor) ;
        dellstock. addObserver (tomInvestor) ;

// Simulate a significant price change
        appleStock.notifyInvestors(100) ;
        appleStock.notifyInvestors (40.0) ;
        appleStock.notifyInvestors(10.0);
        appleStock.notifyInvestors (5.0);
        dellstock.notifyInvestors(300.0);
        dellstock.notifyInvestors(200.0);
    }
}
