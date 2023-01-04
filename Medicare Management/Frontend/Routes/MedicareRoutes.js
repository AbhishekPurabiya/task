const express = require("express");

//connecting the controller with route

const MedicineController = require("../Controller/MedicineController");
const UserController = require("../Controller/UserController");

//creatung the router
const router = express.Router();

//for user/ login
router.get("/login" , UserController.getLoginPage);
router.post("/auth" , UserController.loginAuthentication);

//for admin
router.get("/AdminDashboard" , MedicineController.getAdminDashboard);
router.get("/add-Form" , MedicineController.getAddMedicineForm);
router.post("/add" , MedicineController.addMedicineDetails);
router.get("/update/:id" , MedicineController.getUpdateForm);
router.post("/update" , MedicineController.updateMedicineDetails);
router.get("/delete/:id" , MedicineController.deleteMedicineDetails);
router.get("/get" , MedicineController.getAllMedicine);
router.get("/logout" , MedicineController.logout);

// for user
router.get("/UserDashboard" , UserController.getUserDashboard);
router.get("/user/get" , UserController.getMedicineList)
router.get("/user/cart" , UserController.showMyCart);
router.get("/user/cart/add/:id" , UserController.addToCart);
router.get("/user/cart/remove/:id" , UserController.removeFromCart);
//router.get("/user/get/name" , UserController.getSearchPageByName);
router.post("/user/get/search/name" , UserController.findMedicineWithname);
//router.get("/user/get/brand" , UserController.getSearchPageByBrand);
router.post("/user/get/search/brand" , UserController.findMedicineWithbrand);

module.exports = router ;