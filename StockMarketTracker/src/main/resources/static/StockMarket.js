

/**
 * Function to see all stocks
 */
function seeAllStocks(){
    console.log("hi see all");  

   fetch("/findAllStocks")
   .then(function (response){
        const stockListResp = response.json();

        return stockListResp;
   })
   .then(
    function(stockList){
        createStockList(stockList);
    }
   );

}

/**
 * Function to see Stocks above a certain market cap
 */
function seeByAboveMarketCap(){
    console.log("hi above");   

    //get value
    const number = document.getElementById("inputAboveMarketValue").value;

    //send fetch req and send to dom manipulate
    fetch(`/findByAboveCap?number=${number}`)
    .then(function (response){
         const stockListResp = response.json();
 
         return stockListResp;
    })
    .then(
     function(stockList){
         createStockList(stockList);
     }
    );

}

/**
 * Function to see stocks below a market cap
 */
function seeByBelowMarketCap(){
    console.log("hi below");  
    
    const number = document.getElementById("inputBelowMarketValue").value;

    fetch(`/findByBelowCap?number=${number}`)
    .then(function (response){
         const stockListResp = response.json();
 
         return stockListResp;
    })
    .then(
     function(stockList){
         createStockList(stockList);
     }
    );
    
}

/**
 * Function to see stocks by ticker
 */
function seeByTicker(){
    console.log("hi ticker");  
    
    const frontpage = document.getElementById("showStocks");
    const dependency = document.getElementsByClassName("ShowDaStocks");
    //frontpage.removeChild(dependency);

    const tickerval = document.getElementById("inputTickerValue").value;

    fetch(`/findStockByTicker?ticker=${tickerval}`)
    .then(function (response){
         const stockListResp = response.json();
         console.log("in here");
         return stockListResp;
    })
    .then(
     function(stockJson){
        console.log("in here");

        //prepare data
        const stockCompName = document.createTextNode("Company Name: "+ stockJson.stockCompanyName + " | ");
        const stockTicker = document.createTextNode("Stock Ticker: "+ stockJson.stockTicker + " | ");
        const stockMarketCap = document.createTextNode("Market Cap: "+stockJson.stockMarketCap + " | ");
        const stockQuantityTotal = document.createTextNode("Quantity: "+stockJson.stockQuantityTotal + " | ");
        const stockQuantityAvailable = document.createTextNode("Quantity Available: "+stockJson.stockQuantityAvailable +" | ");
        const pricePerStock = document.createTextNode("Price per Stock: " +"$"+stockJson.stockMarketCap/stockJson.stockQuantityTotal);
        
        //append data
        const stockDiv = document.createElement("div");
        stockDiv.className = "ShowDaStocks";

        stockDiv.appendChild(stockCompName);
        stockDiv.appendChild(stockTicker);
        stockDiv.appendChild(stockMarketCap);
        stockDiv.appendChild(stockQuantityTotal);
        // stockDiv.appendChild(stockQuantityAvailable);
        stockDiv.appendChild(pricePerStock);

        
        frontpage.appendChild(stockDiv);
     }
    );
    
}

/**
 * Function to show stocks on the homepage
 * @param {json} stockJson  a list of jsons
 */
function createStockList(stockJson){
    for(let i = 0; i < stockJson.length; i++){

        //get data into text node
        const stockCompName = document.createTextNode("Company Name: "+ stockJson[i].stockCompanyName + " | ");
        const stockTicker = document.createTextNode("Stock Ticker: "+ stockJson[i].stockTicker + " | ");
        const stockMarketCap = document.createTextNode("Market Cap: "+stockJson[i].stockMarketCap + " | ");
        const stockQuantityTotal = document.createTextNode("Quantity: "+stockJson[i].stockQuantityTotal + " | ");
        const stockQuantityAvailable = document.createTextNode("Quantity Available: "+stockJson[i].stockQuantityAvailable +" | ");
        const pricePerStock = document.createTextNode("Price per Stock: " +"$"+stockJson[i].stockMarketCap/stockJson[i].stockQuantityTotal);

        //make a new div and append data to it
        const stockDiv = document.createElement("div");
        stockDiv.className = "ShowDaStocks";

        stockDiv.appendChild(stockCompName);
        stockDiv.appendChild(stockTicker);
        stockDiv.appendChild(stockMarketCap);
        stockDiv.appendChild(stockQuantityTotal);
        // stockDiv.appendChild(stockQuantityAvailable);
        stockDiv.appendChild(pricePerStock);

        const frontpage = document.getElementById("showStocks");
        frontpage.appendChild(stockDiv);
    }
}

/**
 * Function to send information to buy a stock
 */
function sendBuyStock(){
//document.getElementById("buyStock").addEventListener("submit", function(event){
    const ticker = document.getElementById("inputTicker").value;
    const quantity = document.getElementById("inputQuantity").value;
    const price = document.getElementById("inputPrice").value;

    // console.log(ticker)
    // console.log(quantity)
    // console.log(price)

    //send data and refresh the page
    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "/buyStock");

    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    xhttp.send(`ticker=${ticker}&quantity=${quantity}&buyingPrice=${price}`);
    
    console.log("Sending");

    //refresh
    document.getElementById("buyStockForm").disabled = false;
};