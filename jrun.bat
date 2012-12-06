@echo off
javac -encoding utf-8 tmp.java -classpath C:\github\jt\logback-access-1.0.9.jar;C:\github\jt\logback-classic-1.0.9.jar;C:\github\jt\logback-core-1.0.9.jar;C:\github\jt\slf4j-api-1.7.2.jar;./
java -classpath C:\github\jt\logback-access-1.0.9.jar;C:\github\jt\logback-classic-1.0.9.jar;C:\github\jt\logback-core-1.0.9.jar;C:\github\jt\slf4j-api-1.7.2.jar;./ tmp



rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
