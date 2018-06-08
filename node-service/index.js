const express = require('express')
const app = express()
const SERVER_PORT = 8008

app.get('/hello', (req, res) => {
  res.send('hello world')
})

app.get('/status', (req, res) => {
  res.send({status: "UP"})
})

app.listen(8008, () => {
  console.log("Server Start is running at " + SERVER_PORT);
})
