set base_dir=%~dp0 
%base_dir:~0,2%
pushd %base_dir% 
echo off
call ATFMUpdater.exe
if errorlevel 1 goto NeedCopy
goto CallMain

:NeedCopy
echo xcopy 下载的文件
IF EXIST .\downloadTemp GOTO _COPY
GOTO _DONE
:_COPY
%windir%\system32\xcopy /s/e/i/y .\downloadTemp  
del /q .\downloadTemp
:_DONE

:CallMain
echo 启动主程序
IF "%PROCESSOR_ARCHITECTURE%"=="x86" GOTO x86
ELSE GOTO x64
:x64
set path=.\jre6\x64\bin
GOTO _SET
:x86
set path=.\jre6\x86\bin
GOTO _SET
:_SET
set libs=.\lib
set append=append.bat
set classpath=.

for %%c in (%libs%\*.jar) do ( call append %%c) 
echo %classpath%;

start javaw -Xms512m -Xmx1300m com.lzw.login.LoginFrame


