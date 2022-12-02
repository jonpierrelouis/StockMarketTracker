package local.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.project.models.Stock;
import local.project.repositories.StockRepo;

@Service
public class StockMarketImpl implements StockMarketServiceInterface {

	private StockRepo stockRepo;
	
	/**
	 * @param stockRepo
	 */
	@Autowired
	public StockMarketImpl(StockRepo stockRepo) {
		super();
		this.stockRepo = stockRepo;
	}

	///////////Methods
	/**
	 * find stock by ticker
	 */
	@Override
	public Stock findStockbyTicker(String ticker) {
		
		return stockRepo.findByStockTicker(ticker.toUpperCase());
	}

	/**
	 * Find by stock greater than number given
	 */
	@Override
	public List<Stock> findByAboverCap(double number) {
		
		return stockRepo.findByStockMarketCapGreaterThan(number);
	}

	/**
	 * Find by stocks less than number given
	 */
	@Override
	public List<Stock> findByBelowCap(double number) {
		
		return stockRepo.findByStockMarketCapLessThan(number);
	}

	/**
	 * Find all stocks
	 */
	@Override
	public List<Stock> findAllStocks() {
		
		return stockRepo.findAll();
	}

	/**
	 * buy stocks
	 */
	@Override
	public double buyStock(String stockTicker, int buyingQuantity, double buyingPrice) {
	
		//make sure you can't buy for negative money
		if(buyingPrice <= 0) {
			
			return 0;
		}
		
		//get stock from db
		System.out.println(stockTicker);
		Stock stock = findStockbyTicker(stockTicker);
		System.out.println(stock);
		
		//get market cap and numb of stocks and find price difference 
		double currentMarketCap = stock.getStockMarketCap();
		double currentBuyingPrice = currentMarketCap / stock.getStockQuantityTotal();
		
		double priceDifference = buyingPrice - currentBuyingPrice;
		
		//make sure we get a valid quantity to purchase
		int currentQuantity = stock.getStockQuantityTotal();
		
		//if the number of stocks being bought is greater than the number of stocks avaliable
		//then the number of stocks being bought become the number of stocks available,
		//which would be the total number of stocks
		if(buyingQuantity > currentQuantity) {
			buyingQuantity = currentQuantity;
		}
		
		//get new market cap price and save it to database
		double marketCapDifference = (priceDifference * buyingQuantity) ;
		
		stock.setStockMarketCap(currentMarketCap + marketCapDifference);
		
		stockRepo.save(stock);
		
		return marketCapDifference;
	}

}
