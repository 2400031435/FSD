@REM Custom Maven script using downloaded Maven
@echo off
setlocal

set MAVEN_CMD="%~dp0..\apache-maven-3.9.6\bin\mvn.cmd"

if exist %MAVEN_CMD% (
    call %MAVEN_CMD% %*
) else (
    echo Error: Could not find downloaded maven at %MAVEN_CMD%
    exit /b 1
)

endlocal
