var express = require('express');
const bodyParser = require('body-parser');
const apiRouter = require('./router/api')

//Fire up express app
const app = express();

//First Middleware
app.use(bodyParser.json());

//Second Middleware
app.use(bodyParser.urlencoded({ extended: true })); // support encoded bodies

//Third Middleware
app.use('/api',apiRouter);

//Set up the default port
app.set('port',(process.env.Port || 80));

app.get('/',(req,res)=>{
    res.send(JSON.stringify("Connected"));
});

app.listen(app.get('port'),()=>{
    console.log("Listening to port 80");
});