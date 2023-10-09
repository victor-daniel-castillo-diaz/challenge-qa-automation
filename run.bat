rmdir /s /q allure-results
echo browser = Chrome > .\src\test\java\com\saucedemo\config.properties
cmd /c mvn clean test -Dcucumber.filter.tags="@shoppingCart or @login or @departments-mercado-libre"
cmd /c allure serve
pause
