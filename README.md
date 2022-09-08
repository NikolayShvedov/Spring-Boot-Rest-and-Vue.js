# Spring-Boot-Rest-and-Vue.js
Java Spring REST Application using Vue.js

# Скрипты для асинхронных запросов из консоли

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
clientId=<your_clientId>;clientSecret=<your_clientSecret>;spring.profiles.active=dev  
  
# Webpack setup (steps 1-5 in terminal)
1) Install yarn:  
npm install --global yarn  
2) Create a new package in the local directory:  
yarn init  
3) Install used libraries:  
yarn add vue vue-resource  
4) Install used developer dependencies:  
yarn add -D webpack webpack-cli babel-loader @babel/core @babel/preset-env vue-loader vue-template-compiler 
5) Install Webpack-dev-server  
yarn add webpack-dev-server -D  
6) Download 'Vue.js devtools' from google chrome store  
https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd/related?hl=ru  
  
To start the frontend code, you need to use the `yarn start` command in the terminal  
  
Note: Since all dependency libraries are written in the `package.json` file, instead of `steps 3-5`, it is enough to run `yarn install` command in the terminal.

# Setting up SockJS + Stomp for WebSocket  
yarn add sockjs-client @stomp/stompjs 

# Connecting Styling Using Vuetify  
1) Connecting css styles:  
yarn add -D vue-style-loader css-loader  
2) Add to the `webpack.config.js` file:  
test: /\.css$/,  
use: [  
 'vue-style-loader',  
 'css-loader'  
]  
3) Install Vuetify:  
yarn add -D vuetify 

# Install Vuex  
yarn add vuex  

# Install Vue Router  
yarn add vue-router  

# Параметры для работы с БД  
Также в файле "application.properties"

| Поле                       |                Значение           |
| -------------------------- | :-------------------------------: |
| База данных                |             db_example            |
| Пользователь               |              postgres             |
| Пароль                     |                1234               |
