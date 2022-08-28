# Spring-Boot-Rest-and-Vue.js
Java Spring REST Application using Vue.js

Скрипты для асинхронных запросов из консоли:

// GET all  
fetch('/message/').then(response => response.json().then(console.log))
  
// GET one  
fetch('/message/1').then(response => response.json().then(console.log))
  
# Параметры для работы с БД  
Также в файле "application.properties"

| Поле                       |                Значение           |
| -------------------------- | :-------------------------------: |
| База данных                |             db_example            |
| Пользователь               |              postgres             |
| Пароль                     |                1234               |