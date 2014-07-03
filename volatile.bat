@echo off
"C:\Program Files (x86)\Java\jdk1.7.0_60\bin\javac.exe" -encoding utf-8 tmp.java -classpath ./jar\*;./
"C:\Program Files (x86)\Java\jdk1.7.0_60\bin\java.exe" -classpath ./jar\*;./ tmp



rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
