package local.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.project.models.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer>{
	
	/**
	 * Find a list of stocks with a stock market cap greater than the 
	 * number inputed
	 * @param number the value used to filter the results
	 * @return a list of stocks
	 */
	public List<Stock> findByStockMarketCapGreaterThan(double number);
	
	
	/**
	 * Find a list of stocks with a stock market cap less than the 
	 * number inputed
	 * @param number the value used to filter the results
	 * @return a list of stocks
	 */
	public List<Stock> findByStockMarketCapLessThan(double number);
	
	
	/**
	 * Find a single stock with the ticker inputed
	 * @param ticker
	 * @return a single stock
	 */
	public Stock findByStockTicker(String ticker);

}
