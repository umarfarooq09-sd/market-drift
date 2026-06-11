package com.marketdrift.api;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StockRepository extends JpaRepository<StockSnapshot,Long>{
  @Query("""
    select s from StockSnapshot s
    where s.tradingDate = :date
      and (lower(s.symbol) like lower(concat('%', :search, '%'))
        or lower(s.companyName) like lower(concat('%', :search, '%')))
    order by s.changePercent desc
    """)
  List<StockSnapshot> searchOnDate(@Param("date") LocalDate date,@Param("search") String search);
  List<StockSnapshot> findBySymbolOrderByTradingDateAsc(String symbol);
}
