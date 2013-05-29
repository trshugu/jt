@echo off
"C:\Program Files\Java\jdk1.8.0\bin\javac" -encoding utf-8 tmp.java -classpath C:\github\jt\jar\*;./
java -classpath C:\github\jt\jar\*;./ tmp



rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
