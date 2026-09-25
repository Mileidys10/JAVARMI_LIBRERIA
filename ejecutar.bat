@echo off
call compilar.bat
start "Servidor LipeRMI" cmd /k "java -cp ".;lib\lipermi-1.0.1.jar" net.Principal"
timeout /t 2 /nobreak >nul
start "Cliente LipeRMI" java -cp ".;lib\lipermi-1.0.1.jar" calculo.vistas.Principal
