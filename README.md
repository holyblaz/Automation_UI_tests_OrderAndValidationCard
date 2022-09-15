# Automation_UI_tests_OrderAndValidationCard [![Build status](https://ci.appveyor.com/api/projects/status/vf2yq6nh1112230a?svg=true)](https://ci.appveyor.com/project/holyblaz/automation-ui-tests-orderandvalidationcard)

# Обучение в Нетологии.

## Тема: Тестирование веб-интерфейсов, Selenium и Selenide

Автоматизация тестов на приложение ```app-order.jar``` с использованием селекторов на базе Gradle, с использованием Selenide

![](https://github.com/netology-code/aqa-homeworks/blob/aqa4/web/pic/order.png)

Требования к содержимому полей:

1. Поле Фамилия и имя - разрешены только русские буквы, дефисы и пробелы.
1. Поле телефон - только цифры (11 цифр), символ + (на первом месте).
1. Флажок согласия должен быть выставлен.
1. Тестируемая функциональность: отправка формы.

 - Условие: если все поля заполнены корректно, то вы получаете сообщение об успешно отправленной заявке;
 - Условие: если какое-то поле не заполнено, или заполнено неверно, то при нажатии на кнопку "Продолжить" должны появляться сообщения об ошибке (будет подсвечено только первое неправильно заполненное поле).


**Для запуска проекта:**
1. Склонировать проект из репозитория командой 

```
git clone https://github.com/holyblaz/Automation_UI_tests_OrderAndValidationCard.git
``` 
2. Открыть склонированный проект в Intellij IDEA
3. Открыть в терминале каталог ```artifacts```
4. Для запуска приложения ввести команду ```java -jar ./app-order.jar```
5. Для запуска в браузере ввести ссылку http://localhost:9999/
6. Запустить команду ```./gradlew test```
