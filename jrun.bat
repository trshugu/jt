@echo off
javac -encoding utf-8 tmp.java -classpath C:\github\jt\log4j-1.2.17.jar;./
java -classpath C:\github\jt\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
