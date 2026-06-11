package com.marketdrift.api;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/market")
@CrossOrigin(origins="${app.frontend-url:http://localhost:5173}")
public class MarketController {
  private final StockRepository repository;
  public MarketController(StockRepository repository){this.repository=repository;}

  @GetMapping("/movers")
  public List<StockSnapshot> movers(@RequestParam(defaultValue="up") String direction,@RequestParam(defaultValue="5") int percent,@RequestParam(defaultValue="") String search,@RequestParam(required=false) LocalDate date){
    var rows=repository.findByTradingDateAndSymbolContainingIgnoreCaseOrderByChangePercentDesc(date==null?LocalDate.now():date,search);
    var threshold=BigDecimal.valueOf(percent);
    return rows.stream().filter(s->direction.equalsIgnoreCase("down")?s.changePercent.compareTo(threshold.negate())<=0:s.changePercent.compareTo(threshold)>=0).toList();
  }
  @GetMapping("/breadth")
  public Map<String,Long> breadth(@RequestParam(required=false) LocalDate date){
    var rows=repository.findByTradingDateAndSymbolContainingIgnoreCaseOrderByChangePercentDesc(date==null?LocalDate.now():date,"");
    var result=new LinkedHashMap<String,Long>();
    for(int p:new int[]{5,10,20,30}){var t=BigDecimal.valueOf(p);result.put("up"+p,rows.stream().filter(s->s.changePercent.compareTo(t)>=0).count());result.put("down"+p,rows.stream().filter(s->s.changePercent.compareTo(t.negate())<=0).count());}
    return result;
  }
  @GetMapping("/stocks/{symbol}/history")
  public List<StockSnapshot> history(@PathVariable String symbol){return repository.findBySymbolOrderByTradingDateAsc(symbol.toUpperCase());}
}
