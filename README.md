 # URL Shortener

A high-throughput URL shortener built in Java.

 ## What it does
- Shorten a long URL to a 6-character slug
- Expand a slug back to the original URL
- In-memory storage using HashMap
- File persistence — URLs survive program restart
- Same URL always returns same slug (reverse index)
- Input validation — only http:// and https:// accepted
- Custom exception handling — InvalidURLException

## How to run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.urlshortener.Main"
```

## Commands
| Command | Example | Result |
|---|---|---|
| shorten | shorten https://google.com | Returns a slug |
| expand  | expand aB3xKp | Returns original URL |
| list    | list | Shows all URLs |
| quit    | quit | Exits program |

## Built with
- Java 25
- Maven
