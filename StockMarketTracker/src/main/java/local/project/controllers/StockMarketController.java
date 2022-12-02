package local.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import local.project.models.Stock;
import local.project.service.StockMarketImpl;

@RestController
public class StockMarketController {

	private StockMarketImpl service;

	/**
	 * @param service
	 */
	@Autowired
	public StockMarketController(StockMarketImpl service) {
		super();
		this.service = service;
	}
	
	
	/////Endpoints
	/**
	 * Method to find a single stock based off the ticker
	 * @param ticker the stock's ticker value
	 * @return a stock matching the ticker
	 */
	@GetMapping("/findStockByTicker")
	public Stock findStockByTicker(String ticker) {
		return service.findStockbyTicker(ticker);
	}
	
	/**
	 * A method to find stocks above a certain market cap
	 * @param number the number in which we want to compare
	 * @return a list of stocks
	 */
	@GetMapping("/findByAboveCap")
	public List<Stock> findByAboveCap(String number) {
		
		//convert from string to int then int to double
		//double is the data type we need
		int marketCap = Integer.parseInt(number);
		double marketCap2 = marketCap;
		
		return service.findByAboverCap(marketCap2);
	}
	
	/**
	 * A method to find stocks below a certain market cap
	 * @param number the number in which we want to compare
	 * @return a list of stocks
	 */
	@GetMapping("/findByBelowCap")
	public List<Stock> findByBelowCap(String number) {
		
		//convert string to double
		Double marketCap = Double.parseDouble(number);
		
		System.out.println(marketCap);
		
		return service.findByBelowCap(marketCap);
	}
	
	/**
	 * A method to find all stocks in the database
	 * @return a list of stocks
	 */
	@GetMapping("/findAllStocks")
	public List<Stock> findAllStocks(){
		return service.findAllStocks();
	}
	
	/**
	 * A method to buy stocks
	 * @param ticker the ticker of the stock wanted
	 * @param quantity the number of stocks wished to be bought
	 * @param buyingPrice the price which will be bought for
	 * @return the change in the market cap. Will be 0 if buying price is 0 or less
	 */
	@PostMapping("/buyStock")
	public double buyStock(String ticker, int quantity, double buyingPrice) {
		System.out.println(ticker);
		return service.buyStock(ticker, quantity, buyingPrice);
	}
	
}
