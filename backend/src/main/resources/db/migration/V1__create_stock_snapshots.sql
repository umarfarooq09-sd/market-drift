CREATE TABLE stock_snapshots (
    id BIGSERIAL PRIMARY KEY,
    symbol VARCHAR(12) NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    sector VARCHAR(100),
    close_price NUMERIC(18, 4) NOT NULL CHECK (close_price >= 0),
    change_percent NUMERIC(10, 4) NOT NULL,
    volume BIGINT CHECK (volume IS NULL OR volume >= 0),
    trading_date DATE NOT NULL,
    CONSTRAINT uq_stock_snapshot_symbol_date UNIQUE (symbol, trading_date)
);

CREATE INDEX idx_snapshot_date_change
    ON stock_snapshots (trading_date, change_percent);

CREATE INDEX idx_snapshot_symbol_date
    ON stock_snapshots (symbol, trading_date);

CREATE INDEX idx_snapshot_company_name_lower
    ON stock_snapshots (LOWER(company_name));
