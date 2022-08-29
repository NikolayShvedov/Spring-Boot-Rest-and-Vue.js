# Spring-Boot-Rest-and-Vue.js
Java Spring REST Application using Vue.js

Скрипты для асинхронных запросов из консоли:

// GET all  
fetch('/message/').then(response => response.json().then(console.log))
  
// GET one  
fetch('/message/1').then(response => response.json().then(console.log))
  
// POST add new one  
fetch(  
  '/message',   
  {   
    method: 'POST',   
    headers: { 'Content-Type': 'application/json' },  
    body: JSON.stringify({ text: 'New message', id: 2 })  
  }  
).then(result => result.json().then(console.log))  
  
// PUT save existing  
fetch(  
  '/message/2',   
  {   
    method: 'PUT',   
    headers: { 'Content-Type': 'application/json' },   
    body: JSON.stringify({ text: 'New message edit', id: 2 })  
   }  
).then(result => result.json().then(console.log));  
  
// DELETE existing  
fetch('/message/3', { method: 'DELETE' }).then(result => console.log(result))  
  
# Environment variables  
clientId=<your_clientId>;clientSecret=<your_clientSecret>  
  
# Параметры для работы с БД  
Также в файле "application.properties"

| Поле                       |                Значение           |
| -------------------------- | :-------------------------------: |
| База данных                |             db_example            |
| Пользователь               |              postgres             |
| Пароль                     |                1234               |
