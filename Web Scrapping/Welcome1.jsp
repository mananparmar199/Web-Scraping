<%-- 
    Document   : Welcome1
    Created on : Apr 18, 2021, 9:41:36 PM
    Author     : manan
--%>


<!DOCTYPE html>
<html>
    <style>
     body {
  background-image: url('img1.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
        .btn {
  background-color: #ddd;
  border: none;
  color: black;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  transition: 0.3s;
}
.btn:hover {
  background-color: #3e8e41;
  color: white;
}
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

:root {
  --primary-color: #6CD9CE;
  --secondary-color: #D93BA1;
  --complimentary-color: #2E2473;
}

.container {
  min-height: 50vh;
  position: relative;
  width: 100vw;
  display: flex;
  background-color: var(--complimentary-color);
  justify-content: center;
  align-items: center;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
 position: relative;
}

h1 {
  font-size: 150px;
  color: var(--primary-color);
  transform: translateY(-600px);
  animation: 1.2s slideIn ease-in-out forwards 1s;
  z-index: 10;
  opacity: 0;
  position: relative;
}

h1::before {
    content: '';
    width: 0%;
    height: 76px;
    background-color: var(--secondary-color);
    position: absolute;
    bottom: -10px;
    animation: 1s underline ease-in-out forwards 2s;
    mix-blend-mode: screen;
}

.overlay {
    position: absolute;
    width: 100%;
    top: 0;
    bottom: 0;
    opacity: 0;
    left: 0;
    right: 0;
    background-color: var(--secondary-color);
    transform: scale(.5);
    animation: .5s slideIn ease-in-out forwards, 1s skewBg ease-in-out;
}

@keyframes skewBg {
  0% {
    transform: scale(.5);
  }
  100% {
    transform: scale(1);
  }
}

@keyframes underline {
  100% {
    width: 100%;
  }
}

@keyframes slideIn {
  100% {
    transform: translateY(0px);
    opacity: 1;
  }
}    
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <p align="right">
        <a href="index.html">
                <button class="btn">Logout</button></a></p>
        <div class = 'container projects'>
        <h1>
            <% 
            if(session!=null){  
            String name=(String)session.getAttribute("name");
            out.print("Welcome "+name);
            }
            else
            {
             String name4 = (String)request.getAttribute("s1");
            out.println("Welcome "+name4);
            }%>
        </h1>
        <div class="overlay"></div>
        </div>
         <br><br> <br><br>
        <center>
            <a href="SecondServlet">
                <button class="btn">Top Rated Movies</button></a><br>
            <a href="Scifi">
                <button class="btn">Most Popular Movies</button></a><br>
            <a href="tvshows">
                <button class="btn">Top Rated TV Shows</button></a><br>
            <a href="tvpop">
                <button class="btn">Most Popular TV Shows</button></a><br>
    </body>
</html>
