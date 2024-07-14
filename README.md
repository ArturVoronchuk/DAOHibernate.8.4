# Задача «Слой DAO c JPA Repositories»

## Описание

Попрактикуемся в работе с JPA Repositories, переписав приложение для работы с БД [«Слой DAO c Hibernate»](../../hibernate/task1/README.md).

**Что нужно сделать**

1. Перепишите репозиторий для работы с БД на основе методов-запросов:

 - чтобы у вашего репозитория были основные методы для `CRUD` операций;
 - создайте метод, который будет принимать название города (`city`) и возвращать `Entity` из базы данных, которые соответствуют этому `city`;
 - создайте метод, который будет принимать возраст (`age`) и возвращать `Entity` из базы данных, которые меньше переданного `age` и отсортированы по возрастанию;
 - создайте метод, который будет принимать имя и фамилию (`name` и `surname`) и возвращать `Entity` из базы данных, которые соответствуют сочетанию `name` и `surname` и являются `Optional`.
 
2. Допишите недостающие методы контроллера в соответствии с появившимися новыми методами в репозитории.

3. Написанный код выложите в тот же репозиторий, что и для задачи [«Слой DAO c Hibernate»](../../hibernate/task1/README.md) на GitHub, только создайте под него другую ветку `jpa-repository` и прикрепите ссылку на неё в комментарий к домашнему заданию.
