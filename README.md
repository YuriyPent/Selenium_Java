# Selenium_Java
Инструменты для автоматизации тестирования с Selenium + Java
Установка и запуск Selenium Grid hub: C:\>java -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role hub
Установка node: C:\>java -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register -port 5555
Run/Debug configurations: clean verify -Dwebdriver.gecko.driver=C:\Tools\geckodriver.exe