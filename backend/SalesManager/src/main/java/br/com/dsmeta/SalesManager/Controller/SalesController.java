package br.com.dsmeta.SalesManager.Controller;

import br.com.dsmeta.SalesManager.Model.Sale;
import br.com.dsmeta.SalesManager.Service.SalesService;
import br.com.dsmeta.SalesManager.Service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(
            @RequestParam (value = "minDate", defaultValue = "") String minDate,
            @RequestParam (value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<Sale> allSales = salesService.findAllSales(minDate, maxDate, pageable);
        return ResponseEntity.ok(allSales);
    }

    @GetMapping("/{id}/notification")
    public void sendSms(@PathVariable Long id){
        Sale saleById = salesService.findById(id);
        smsService.sendSms(saleById);

    }

}
