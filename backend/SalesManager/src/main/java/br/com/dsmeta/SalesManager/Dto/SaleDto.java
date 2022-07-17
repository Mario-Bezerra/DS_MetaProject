package br.com.dsmeta.SalesManager.Dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SaleDto implements Serializable {
    private final Long id;
    private final String sellerName;
    private final Integer visited;
    private final Integer deals;
    private final double amount;
    private final LocalDate date;

    public SaleDto(Long id, String sellerName, Integer visited, Integer deals, double amount, LocalDate date) {
        this.id = id;
        this.sellerName = sellerName;
        this.visited = visited;
        this.deals = deals;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleDto entity = (SaleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.sellerName, entity.sellerName) &&
                Objects.equals(this.visited, entity.visited) &&
                Objects.equals(this.deals, entity.deals) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sellerName, visited, deals, amount, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "sellerName = " + sellerName + ", " +
                "visited = " + visited + ", " +
                "deals = " + deals + ", " +
                "amount = " + amount + ", " +
                "date = " + date + ")";
    }
}
