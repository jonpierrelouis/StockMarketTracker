package local.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="stock_market")
public class Stock {
	
	@Id
	@Column(name="stock_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stockId;
	
	@Column(name="stock_company_name")
	private String stockCompanyName;
	
	@Column(name="stock_ticker")
	private String stockTicker;
	
	@Column(name="stock_market_cap")
	private double stockMarketCap;
	
	@Column(name="stock_quantity_total")
	private int stockQuantityTotal;
	
	@Column(name="stock_quantity_available")
	private int stockQuantityAvailable;
}
