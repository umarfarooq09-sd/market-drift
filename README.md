# MarketDrift

A full-stack US stock market movement dashboard inspired by the supplied market-breadth screenshot.

## Included

- React/Vite responsive frontend with demo login
- Search, top gainers, top losers, and clickable 5%, 10%, 20%, and 30%+ up/down buckets
- Stock detail drawer with price trend and date context
- Spring Boot REST API with percentage calculation endpoints
- PostgreSQL/Neon-ready persistence configuration

## Run the frontend

```powershell
cd frontend
npm install
npm run dev
```

Open `http://localhost:5173`. Demo login values are already filled in.

## Run the backend

Set values from `.env.example`, then:

```powershell
cd backend
mvn spring-boot:run
```

API endpoints:

- `GET /api/market/movers?direction=up&percent=10&search=NVDA`
- `GET /api/market/breadth`
- `GET /api/market/stocks/NVDA/history`

## Live market data

Use a licensed US market-data provider such as Polygon, Finnhub, Twelve Data, or Alpha Vantage. A scheduled ingestion service should fetch end-of-day aggregate data, calculate:

`changePercent = ((closePrice - previousClose) / previousClose) * 100`

and store one `stock_snapshots` row per symbol and trading date. Keep API keys only in backend environment variables.

For a production deployment, use Neon for Postgres, deploy Spring Boot to Render/Railway/Fly.io, deploy the frontend to Vercel, and replace the demo login with Spring Security plus JWT or an identity provider.
