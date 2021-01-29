package id.co.bni.otf.bootcamp.web.controller.stocks;

import id.co.bni.otf.bootcamp.service.ClosingpricesSerevice;
import id.co.bni.otf.bootcamp.service.dto.StocksDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Validated
@RequestMapping(value = "/closing-price", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClosingPriceController {
    private final ClosingpricesSerevice closingpricesSerevice;

    public ClosingPriceController(ClosingpricesSerevice closingpricesSerevice) {
        this.closingpricesSerevice = closingpricesSerevice;
    }

    @PostMapping("")
    public ResponseEntity<Object> getMaxProfit(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                              @RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") Date to){

        return ResponseEntity.ok().body(closingpricesSerevice.getMaxProfit(from,to));
    }
}
