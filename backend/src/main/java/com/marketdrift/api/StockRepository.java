package com.marketdrift.api;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StockRepository extends JpaRepository<StockSnapshot,Long>{
  List<StockSnapshot> findByTradingDateAndSymbolContainingIgnoreCaseOrderByChangePercentDesc(LocalDate date,String symbol);
  List<StockSnapshot> findBySymbolOrderByTradingDateAsc(String symbol);
}
