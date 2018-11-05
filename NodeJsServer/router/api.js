const express = require('express')
const router = express.Router();

router.post('/user_log_in',(req,res)=>{
    console.log(req.body);
    const userName = req.body.userName;
    const userPassword = req.body.userPassword;

    if(userName === "mujahid7292" && userPassword==="123456"){
        res.send(JSON.stringify("Successfully Logged In"))
    } else{
        res.send(JSON.stringify("Logged In Failed"))
    }
});

module.exports = router;