@echo off
javac ntmp.java -classpath ./jar\*;./ -Xlint:unchecked
java -classpath ./jar\*;./ ntmp



rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
