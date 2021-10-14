<h2 align="center"> Bank App Project </h2>

Table of content<br>
1.<a href="#introduction">Introduction</a><br>
2.<a href="#technologies">Technologies & installation</a><br>
3.<a href="#execute">How to execute </a><br>
4.<a href="#use">How to use</a><br>


<div id="introduction">
<h2>Introduction </h2>
Application provide a saparate interface to customer and admin to interact with bank related operations. 
This application runs on two servers ( Apache tomact and Netty) and connect with the sql database.
</div>

<div id="technologies">
<h2>Technologies & installation</h2>
1. <b>JDK 1.8 </b>: Download and install JDK. Need to set environment variable (copy the path of bin folder of JRE and paste in system variable).<br>
2. <b>Apache Tomcat 9.0.53 </b> : Download and install this server. Set environment variable (copy the path of bin and paste in system variable) .<br> 
3. <b>SBT 1.3.13 </b>: Download and install sbt.<br>
4. <b>Intellij Idea </b> : Download and install this IDE. Also add plugins of Scala (works as play framework and have server, Netty).<br> 
5. <b>SQL database </b> : Install sql and workbenck of sql.<br>
</div>

<div id="execute">
<h2> How to execute </h2>
1. Clone the project and save in saparate folder. <br>
2. Import database (my_bank_app) in workbench. <br>
3. Import the project (folder name in git project: bankappnew4) in Intellij Idea.<br>
4. Build the project using sbt. As the dependencies are added in build.sbt file, it will add external jar files in library(Like Ebean library, Json Library, ). <br>
5. Run the project using sbt.<br>
6. On the otherhand, save the other folder(folder name in git project: HTML Pages hosted on tomcat)in the webapps of Apache Tomcat.<br>
7. Run tomcat server and then HTML pages, starting from index.html page.  <br>
</div>

<div id="use">
<h2> How to use </h2>
1. Admin Dashboard <br>
(i)  Log in as admin will be redirect on admin dashboard.<br>
     Credentials for admin log in : <br>
     Username : admin@gmail.com <br>
     Password : admin <br>
(ii) Functions <br>
	-Admin can register a new customer using registration function.<br>
	-Admin can check the list of customers.<br>
	-Admin can activate or deactivate a customer.<br>
2. Customer Dashboard<br>
(i)  Log in as customer will redirect on customer dashboard.<br>
     For trial purpose only: <br>
     Customer log in id: <br>
     Username : sanger705@gmil.com <br>
     Passowrd : 12345 <br>
     Note : Rest data saved in tables or new customer can be registered using admin dashboard. <br>
(ii) Functions<br>
	-Customer can deposite and withdraw the amount.<br>
	-Customer can check the transaction history.<br>
  </div> 

