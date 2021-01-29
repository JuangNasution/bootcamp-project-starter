package id.co.bni.otf.bootcamp.service;

import id.co.bni.otf.bootcamp.entity.ClosingPrice;
import id.co.bni.otf.bootcamp.repository.ClosingPricesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ClosingpricesSerevice {
    private final ClosingPricesRepository closingPricesRepository;

    public ClosingpricesSerevice(ClosingPricesRepository closingPricesRepository) {
        this.closingPricesRepository = closingPricesRepository;
    }

    public float getMaxProfit(Date start, Date to){
        LocalDate newStart = new java.sql.Date(start.getTime()).toLocalDate();
        LocalDate newTo = new java.sql.Date(to.getTime()).toLocalDate();
        List<ClosingPrice> priceList = closingPricesRepository.findByDateBetween(newStart, newTo);
        float maxProfit = 0;
        for (int i = 1; i < priceList.size(); i++) {
            if(priceList.get(i+1).getPrice().floatValue()  > priceList.get(1).getPrice().floatValue()){
                maxProfit+=priceList.get(i+1).getPrice().floatValue()-priceList.get(1).getPrice().floatValue();
            }
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
