package local.project.service;

import java.util.List;

import local.project.models.Stock;

public interface StockMarketServiceInterface {
	
	/**
	 * 
	 * @param ticker
	 * @return the stock corresponding with the ticker input
	 */
	public Stock findStockbyTicker(String ticker);
	
	/**
	 * 
	 * @param number
	 * @return the stock corresponding with the number input
	 */
	public List<Stock> findByAboverCap(double number);
	
	/**
	 * 
	 * @param number
	 * @return the stock corresponding with the number input
	 */
	public List<Stock> findByBelowCap(double number);
	
	/**
	 * 
	 * @return a list of all stocks in the database
	 */
	public List<Stock> findAllStocks();
	
	/**
	 *
	 * @param stockTicker the ticker of the stock wished to be bought
	 * @param quantity the quantity wished to be bought
	 * @param buyingPrice the price which the user bought for
	 * @return the total cost increase/decrease of market cap 
	 */
	public double buyStock(String stockTicker, int quantity, double buyingPrice);

}
