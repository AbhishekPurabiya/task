<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--Linking the bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!--linking the css file-->
    <link rel="stylesheet" href="/css/Login.css">
    <title>Login</title>
</head>
<body>
    <div class="container-fluid">
        <div class="container">
            <section class="form vh-100">
                <div class="container-fluid h-custom">
                    <div class="row d-flex justify-content-center align-items-center h-100">
           
                        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                            <h3><strong>Food Delivery System</strong></h3>
                            <br><br>
                            <form action="/food/user/login" method="post" onsubmit="return validate()">
                                <!-- Email input -->
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
                                    <label for="username">Username</label>
                                </div>

                                <!-- Password input -->
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" id="Password" placeholder="Password" name="password" required>
                                    <label for="Password">Password</label>
                                </div>

                                <div class="d-flex justify-content-between align-items-center">
                                    <!-- Checkbox -->
                                    <div class="form-check mb-0">
                                        <input class="form-check-input me-2" type="checkbox" id="showPassword" onclick="showpassword()"/>
                                        <label class="form-check-label" for="form2Example3">
                                            Show Password
                                        </label>
                                    </div>
                                   
                                </div>

                                <div class="login-signup text-center text-lg-start mt-4 pt-2">
                                    <div>
                                        <button type="submit" class="btn btn-primary btn-lg"
                                            style="padding-left: 3.5cm; padding-right: 3.5cm;">Login</button>
                                    </div>
                                    <Strong>Don't have an Account <a href="/views/SignUp.jsp">Register Here</a> </Strong>
                                    <div>
                                   
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </section>
        </div>
    </div>
	
	<script type="text/javascript">
	/** mathod to mak show password checkbox*/

	function showpassword() {
		var x = document.getElementById("Password");

		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}

	}

	

	</script>
	



    
    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>