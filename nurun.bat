rem @echo off
"C:\Program Files\Java\jdk1.7.0_65\bin\javac" ntmp.java -classpath ./jar\*;./ -Xlint:unchecked
"C:\Program Files\Java\jdk1.7.0_65\bin\java" -classpath ./jar\*;./ ntmp -Dfile.encoding=UTF-8 -Duser.timezone=Asia/Tokyo -Duser.language=ja -Duser.country=JP


rem javac ntmp.java -classpath ./jar\*;./ -Xlint:unchecked
rem java -classpath ./jar\*;./ ntmp


rem javac -encoding utf-8 tmp.java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./
rem java -classpath C:\github\jt\jar\log4j-1.2.17.jar;./ tmp

rem -Dlog4j.configuration=C:/github/jt/log4j.xml
