package com.marketdrift.api;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="stock_snapshots",
  uniqueConstraints=@UniqueConstraint(name="uq_stock_snapshot_symbol_date",columnNames={"symbol","trading_date"}),
  indexes={@Index(name="idx_snapshot_date_change",columnList="trading_date,change_percent")})
public class StockSnapshot {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
  @Column(nullable=false,length=12) public String symbol;
  @Column(name="company_name",nullable=false) public String companyName;
  public String sector;
  @Column(name="close_price",nullable=false,precision=18,scale=4) public BigDecimal closePrice;
  @Column(name="change_percent",nullable=false,precision=10,scale=4) public BigDecimal changePercent;
  public Long volume;
  @Column(name="trading_date",nullable=false) public LocalDate tradingDate;
}
