import org.json.JSONObject;

public class CurrencyConverter {
    private JSONObject rates;

    public CurrencyConverter(String baseCurrency) {
        try {
            rates = ExchangeRateAPI.getRates(baseCurrency).getJSONObject("conversion_rates");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double convert(String toCurrency, double amount) {
        return amount * rates.getDouble(toCurrency);
    }
}
