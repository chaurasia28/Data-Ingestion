# 📥 Data Ingestion Tool

A Spring Boot application that supports bi-directional data ingestion between ClickHouse and CSV flat files. The tool allows you to:

- ✅ Upload a CSV file and insert data into ClickHouse
- ✅ Export data from ClickHouse tables into a downloadable CSV file
- ✅ Preview table data
- ✅ login



## Run ClickHouse with Docker
docker run -d --name clickhouse-server -p 8123:8123 yandex/clickhouse-server

Configure application.properties

## 🛠 Tech Stack

- *Backend:* Spring Boot (Java)
- *Database:* ClickHouse
- *Frontend:* React
- *Build Tool:* Maven
- *Containerization:* Docker (for ClickHouse setup)

---

## 🚀 Features

- 🔐 User signup and login (JWT secured)
- 📤 Export selected columns from ClickHouse table to CSV
- 📥 Upload CSV and insert into ClickHouse
- 🔄 Join tables and export (bonus feature)
- 🧪 Handle connection/auth failures
- 👁 Optional: Preview ClickHouse table data

---

## 🧪 Testing Datasets

Use ClickHouse sample datasets like:

- test_data

TableName is that is in my dataset : test_data
along with columns like : id,name,created_at

## Run the App
mvn spring-boot:run

## 🌐 Frontend
Accessible at: http://localhost:3000
Styled using external style.css with interactive buttons and clean layout.

Test Cases:

1. Export selected columns to flat file ✅  
2. Upload CSV and verify data in ClickHouse ✅  
3. (Bonus) Join tables and export to file ✅  
4. Handle auth/connection errors ✅  
5. Preview table data (optional) ✅

## 🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first.

## 🔗 Links
🔹 ClickHouse Docs: https://clickhouse.com/docs
🔹 Spring Boot Reference: https://docs.spring.io/spring-boot/index.html


## 📦 Setup

### 1. Clone the repo

```bash
git clone https://github.com/chaurasia28/Data-Ingestion