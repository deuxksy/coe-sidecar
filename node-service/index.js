var express = require('express')
var app = express()

app.get('/hello', function (req, res) {
  res.send('hello world')
})

app.get('/status', function (req, res) {
  res.send({status: "UP"})
})

app.listen(8008, function() {
  console.log("Server Start!")
})
