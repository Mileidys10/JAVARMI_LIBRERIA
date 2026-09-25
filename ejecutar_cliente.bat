@echo off
call compilar.bat
java -cp ".;lib\lipermi-1.0.1.jar" calculo.vistas.Principal
