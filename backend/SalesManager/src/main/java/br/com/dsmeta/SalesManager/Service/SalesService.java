package br.com.dsmeta.SalesManager.Service;

import br.com.dsmeta.SalesManager.Model.Sale;
import br.com.dsmeta.SalesManager.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> findAllSales(String minDate, String maxDate, Pageable pageable){

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return saleRepository.findAll(min , max, pageable);
    }

    public Sale findById(Long id){
        Optional<Sale> byId = saleRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }

        return null;
    }
}
