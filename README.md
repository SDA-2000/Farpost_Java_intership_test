<h1>Farpost_Java_intership_test</h1>

Для запуска проекта необходимо:
1. Docker
2. Maven
3. OpenJDK17
4. WSL или Linux

Команда запуска проекта:
```sh
#Следующую строку необходимо запустить при первом запуске проекта
mvn clean package
sudo docker-compose up --build
```
После успешного запуска, API будет находиться по адресу:
```sh
http://localhost:8080
```
