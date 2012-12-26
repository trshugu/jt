@echo off
javac -encoding utf-8 tmptest.java -classpath C:\github\jt\jar\*;./
java -classpath C:\github\jt\jar\*;./ org.junit.runner.JUnitCore tmptest



rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
