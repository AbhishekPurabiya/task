const express = require("express");
const app = express();
app.listen(8181 , (request) => {
    console.log("Application Started")
});

const sessions = require("express-session");
app.set("view engine" , "ejs");
const bodyParser=require("body-parser");

const oneDay = 1000*60*60*24 ;

app.use(sessions({
    secret: "mysecretkey9876543210",
    saveUninitialized:true,
    cookie: { maxAge: oneDay },
    resave: false
}));

app.use(bodyParser.urlencoded({extended:true}));

//connecting the router
const AppRouter = require("./Routes/MedicareRoutes");

// for any request the list 
app.get("/" , (request , response) => {
    response.redirect("/medicare");
});

app.use("/medicare" , AppRouter);