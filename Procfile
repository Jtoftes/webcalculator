web:	java $JAVA_OPTS -Ddw.server.connector.port=$PORT -jar target/webcalculator-1.3.1.jar server config/heroku.yml
scheduler:  java $JAVA_OPTS -cp target/classes:target/dependency/* com.acabra.calculator.job.WebCalculatorJobManager
