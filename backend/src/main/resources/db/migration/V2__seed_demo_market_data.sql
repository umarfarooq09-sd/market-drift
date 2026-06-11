INSERT INTO stock_snapshots
    (symbol, company_name, sector, close_price, change_percent, volume, trading_date)
VALUES
    ('NVDA','NVIDIA Corp.','Technology',151.4200,31.8400,388200000,'2026-06-11'),
    ('CRWV','CoreWeave Inc.','Technology',184.6300,24.5800,34900000,'2026-06-11'),
    ('IONQ','IonQ Inc.','Technology',44.1800,21.0900,29600000,'2026-06-11'),
    ('RKLB','Rocket Lab USA','Industrials',28.7200,18.4600,41300000,'2026-06-11'),
    ('PLTR','Palantir Technologies','Technology',142.1000,12.3600,77800000,'2026-06-11'),
    ('TSLA','Tesla Inc.','Consumer Cyclical',326.4300,10.6200,122400000,'2026-06-11'),
    ('AMD','Advanced Micro Devices','Technology',127.8500,7.8200,66100000,'2026-06-11'),
    ('AAPL','Apple Inc.','Technology',204.0900,5.1800,49800000,'2026-06-11'),
    ('META','Meta Platforms','Communication',694.2700,3.8400,18200000,'2026-06-11'),
    ('UNH','UnitedHealth Group','Healthcare',294.7500,-5.4200,19100000,'2026-06-11'),
    ('BA','Boeing Co.','Industrials',188.4000,-8.7300,13600000,'2026-06-11'),
    ('COIN','Coinbase Global','Financial Services',236.8200,-11.6100,17300000,'2026-06-11'),
    ('MSTR','Strategy Inc.','Technology',368.1400,-16.2400,21800000,'2026-06-11'),
    ('SMCI','Super Micro Computer','Technology',37.6500,-22.1800,58400000,'2026-06-11'),
    ('WOLF','Wolfspeed Inc.','Technology',3.2100,-34.6400,48200000,'2026-06-11'),
    ('NVDA','NVIDIA Corp.','Technology',114.8500,3.1900,251000000,'2026-06-04'),
    ('NVDA','NVIDIA Corp.','Technology',119.9800,4.4700,264000000,'2026-06-05'),
    ('NVDA','NVIDIA Corp.','Technology',125.1200,4.2800,271000000,'2026-06-06'),
    ('NVDA','NVIDIA Corp.','Technology',134.3400,7.3700,301000000,'2026-06-09'),
    ('NVDA','NVIDIA Corp.','Technology',138.7500,3.2800,292000000,'2026-06-10'),
    ('WOLF','Wolfspeed Inc.','Technology',4.9200,-3.5300,22100000,'2026-06-04'),
    ('WOLF','Wolfspeed Inc.','Technology',4.6500,-5.4900,24500000,'2026-06-05'),
    ('WOLF','Wolfspeed Inc.','Technology',4.3100,-7.3100,28900000,'2026-06-06'),
    ('WOLF','Wolfspeed Inc.','Technology',3.8900,-9.7400,33600000,'2026-06-09'),
    ('WOLF','Wolfspeed Inc.','Technology',3.5600,-8.4800,39100000,'2026-06-10')
ON CONFLICT (symbol, trading_date) DO NOTHING;
