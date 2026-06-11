package com.marketdrift.api;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="stock_snapshots",indexes={@Index(name="idx_snapshot_date_change",columnList="tradingDate,changePercent")})
public class StockSnapshot {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
  @Column(nullable=false,length=12) public String symbol;
  @Column(nullable=false) public String companyName;
  public String sector;
  @Column(nullable=false,precision=18,scale=4) public BigDecimal closePrice;
  @Column(nullable=false,precision=10,scale=4) public BigDecimal changePercent;
  public Long volume;
  @Column(nullable=false) public LocalDate tradingDate;
}
