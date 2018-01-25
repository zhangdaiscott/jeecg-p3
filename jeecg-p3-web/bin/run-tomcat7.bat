@echo off
title %cd%
echo.
echo [信息] 使用Tomcat7插件运行工程。
echo.


cd %~dp0
cd..

set MAVEN_OPTS=%MAVEN_OPTS% -Xms256m -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=256m
call mvn tomcat7:run

cd bin
pause