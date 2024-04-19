package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    private LocalDate maxDate;
    private LocalDate minDate;

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    public Page<SaleReportDTO> getReport(String minDateStr, String maxDateStr, String name, Pageable pageable) {
        maxDate = getMaxDate(maxDateStr);
        minDate = getMinDate(minDateStr, maxDateStr);
        Page<Sale> result = repository.getReport(minDate, maxDate, name, pageable);
        return result.map(SaleReportDTO::new);
    }

    private LocalDate getMinDate(String minDateStr, String maxDateStr) {
        return "".equals(minDateStr) ? getMaxDate(maxDateStr).minusYears(1L) : LocalDate.parse(minDateStr);
    }
    private LocalDate getMaxDate(String maxDateStr) {
        return "".equals(maxDateStr) ? LocalDate.now() : LocalDate.parse(maxDateStr);
    }
}
