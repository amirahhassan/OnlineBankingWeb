<!DOCTYPE html>
<html lang="en">
<head>
    <title>OBS</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
<div class="container">
    <div class="center">
        <h1>Sign Up</h1>
        <form action="" method="POST">
            <div class="txt_field">
                <input type="text" name="text" required />
                <span></span>
                <label>Name</label>
            </div>
            <div class="txt_field">
                <input type="email" name="email" required />
                <span></span>
                <label>Email</label>
            </div>
            <div class="txt_field">
                <input type="password" name="password" required />
                <span></span>
                <label>Password</label>
            </div>
            <input name="submit" type="Submit" value="Sign Up" />
            <div class="signup_link">
                Already a member? <a href="login">Log In</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
