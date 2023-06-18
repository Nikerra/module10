# Module 10. Spring MVC


### Требования: 
Реализовать Spring MVC приложение, которое будет обрабатывать запросы по URL /finance . Приложение должно:
- GET-запрос /finance возвращает html-cтраницу, которая содержит поля для расчёта доходности по вкладу через определенное количество лет.
- POST-запрос /finance возвращает html-cтраницу с результатами расчёта доходности или ошибку если форма заполнена неверно

При POST-запросе передаются значения полей:
- sum - сумма на момент открытия
- percentage - годовая процентная ставка
- years - количество лет

## Критерии приемки:
1. В браузере по адресу http://localhost:8080/finance открывается страница, которая реализована в соответствии с макетом (maket.pdf)
2. Если сумма на момент открытия меньше 50 000 рублей, то POST запрос возвращает html страницу с текстом ошибки: "Минимальная сумма на момент открытия вклада 50 000 рублей"
3. Если пользователь вводит недопустимые символы или отрицательное число, то POST запрос возвращает html страницу с текстом ошибки: "Неверный формат данных. Скорректируйте значения"
4. Минимальный размер суммы на момент открытия брать из application.properties
5. Использовать паттерн проектирования MVC (Model-View-Controller)
6. Написать unit tests для слоя Controller (задание со звёздочкой)