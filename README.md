<h1>Farpost_Java_intership_test</h1>

Для запуска проекта необходимо:
1. Docker
2. Maven
3. OpenJDK17
4. WSL или Linux

Необходимо создать .env файл на уровне docker-compose.yml со следующим содержимым:
```.env
POSTGRE_USER=ваше_имя_пользователя_в_БД_PostgreSQL
POSTGRE_USER_PASSWORD=пароль_пользователя
```

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
