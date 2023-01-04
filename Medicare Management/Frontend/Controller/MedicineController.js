const bodyParser = require("body-parser");
const axios = require("axios");
const fetch = require("node-fetch");
const session = require("express-session");
const { request } = require("express");


const getAdminDashboard = (request , response) => {
    response.render("AdminDashboard" );
};


const getAddMedicineForm = (request , response) => {
    response.render("AddMedicineForm" , {title : "Add Medicine"});
};


const addMedicineDetails = (request , response) => {
    const body = request.body ;
    
    axios.post("http://localhost:8080/medicare/v1/medicine/add" , body)
    setTimeout(render_view, 1500);
    function render_view(){
    response.redirect("/medicare/get");
    }
};

const getAllMedicine = (request , response) => {
    axios.get("http://localhost:8080/medicare/v1/medicine/get")
  .then((medicine) => {
        console.log(medicine.data);
        response.render("MedicineList",{json:medicine.data})
  });

}

const getUpdateForm = (request , response) => {
    let id = request.params.id;
    response.render("UpdateForm" , {id:id});
}


const updateMedicineDetails = (request , response) => {
    const body = request.body
    console.log(body);
    
    axios.put("http://localhost:8080/medicare/v1/medicine/update" , body);
    setTimeout(render_view, 1500);
    function render_view(){
    response.redirect("medicare/get");
    }

}

const deleteMedicineDetails = (request , response) => {
    let id = request.params.id;
    axios.delete("http://localhost:8080/medicare/v1/medicine/delete/"+id)
    setTimeout(render_view, 1500);
    function render_view(){
    response.redirect("/medicare/get");
    }
}

const logout = (request , response) => {
    request.session.destroy();
    setTimeout(render_view, 1500);
    function render_view(){
    response.redirect("/medicare/login");
    }
};


module.exports = {getAdminDashboard, getAddMedicineForm ,addMedicineDetails, getAllMedicine , getUpdateForm , logout ,updateMedicineDetails ,deleteMedicineDetails };