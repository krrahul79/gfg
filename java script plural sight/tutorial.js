const http = require('http')
const requestListener = (req, res) => {
    res.write("hello world")
    res.end()
}
const server = http.createServer();
server.on('request',requestListener)
server.listen('4300', () => {
    console.log("Server listen to 4300")
})

const express = require('express')

const server = express()
server.set('view-engine','ejs');

server.get('/',(req,res)=>{
res.render(index)
})