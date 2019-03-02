# Selenium_Java
Инструменты для автоматизации тестирования с Selenium + Java

Установка и запуск Selenium Grid hub:

C:\>java -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role hub

Установка node: 

C:\>java -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register -port 5555

Конфигурация JSON1:

{
	"capabilities":
	[
		{
			"browserName": "firefox",
			"marionette": true,
			"maxInstances": 3
		},
		{
			"browserName": "chrome",
			"maxInstances": 1
		}
	],
	"port": 5555,
	"hub": "http://localhost:4444"
}

Установка node: 

C:\>java -Dwebdriver.gecko.driver=C:\Tools\geckodriver.exe -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role node -nodeConfig "path_to_file\node1.json"

Конфигурация JSON2:

{
	"capabilities":
	[
		{
			"browserName": "firefox",
			"marionette": true,
			"maxInstances": 4
		}
	],
	"port": 5556,
	"hub": "http://localhost:4444"
}

Установка node: 

C:\>java -Dwebdriver.gecko.driver=C:\Tools\geckodriver.exe -jar "path_to_file\selenium-server-standalone-3.141.59.jar" -role node -nodeConfig "path_to_file\node2.json"

Run/Debug configurations: 

clean verify -Dwebdriver.gecko.driver=C:\Tools\geckodriver.exe