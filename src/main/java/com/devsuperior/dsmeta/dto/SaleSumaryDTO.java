package com.devsuperior.dsmeta.dto;

public class SaleSumaryDTO {

    private final String sellerName;
    private final Double total;

    public SaleSumaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
