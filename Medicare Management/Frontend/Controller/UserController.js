const bodyParser = require("body-parser");
const axios = require("axios");
const fetch = require("node-fetch");
const session = require("express-session");


// fro getting the login page
const getLoginPage = (request, response) => {
    response.render("Login");
};

// for login authentication
const loginAuthentication = (request, response) => {
    const body = request.body;
    axios.post("http://localhost:8080/medicare/v1/user/login", body)
        .then((user) => {
            console.log(user.data);
            if (user.data != null) {
                if (user.data.role == "user") {
                    sess = request.session;
                    sess.role = user.data.role;
                    sess.cid = user.data.cid;
                    response.render("UserDashboard", { title: "User Dashboard" });
                } else if (user.data.role == "admin") {
                    sess = request.session;
                    sess.role = user.data.role;
                    sess.cid = user.data.cid;
                    response.render("AdminDashboard", { title: "Admin Dashboard" });
                } else {
                    response.render("error", { error: "Invalid Username and Password.." });
                }
            }
        })

};

const getUserDashboard = (request , response) => {
    response.render("UserDashboard" );
};


const getMedicineList = (request , response) => {
    axios.get("http://localhost:8080/medicare/v1/user/get")
  .then((medicine) => {
        console.log(medicine.data);
        response.render("UserMedicineList",{json:medicine.data})
  });

}

const  showMyCart = (request , response) => {
    id = request.session.cid;
    console.log(request.session)
    console.log(id);
    axios.get("http://localhost:8080/medicare/v1/user/cart/get/"+id)
  .then((medicine) => {
        console.log(medicine.data);
        response.render("UserCart",{json:medicine.data})
  });

}

const addToCart = (request , response) => {
    let mid = request.params.id ;
    cid = request.session.cid;
    axios.post("http://localhost:8080/medicare/v1/user/cart/add/"+mid+"/"+cid)
    setTimeout(render_view, 1500);
    function render_view(){
    response.redirect("/medicare/user/get");
    }
}

const removeFromCart = (request , response) => {
    let id = request.params.id ;
    axios.delete("http://localhost:8080/medicare/v1/user/cart/remove/"+id)
    setTimeout(render_view, 1500);
    function render_view(){
        response.redirect("/medicare/user/cart");
    }
    
}

// const getSearchPageByName = (request , response) => {
//     response.render("SearchByName");
// };

const findMedicineWithname = (request , response) => {
    let name = request.body.name ;
    axios.get("http://localhost:8080/medicare/v1/user/get/name/"+name)
    .then((medicine) => {
        console.log(medicine.data);
        response.render("SearchByName",{json:medicine.data})
  });
}

// const getSearchPageByBrand = (request , response) => {
//     response.render("SearchByBrand");
// };

const findMedicineWithbrand = (request , response) => {
    let brand = request.body.brand ;
    axios.get("http://localhost:8080/medicare/v1/user/get/brand/"+brand)
    .then((medicine) => {
        console.log(medicine.data);
        response.render("SearchByBrand",{json:medicine.data})
  });
}

module.exports = {getUserDashboard, getLoginPage, loginAuthentication, getMedicineList , 
    showMyCart , addToCart , removeFromCart  , findMedicineWithname  ,findMedicineWithbrand};