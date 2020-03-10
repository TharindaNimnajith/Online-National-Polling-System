
/*

Author       : Tharinda Nimnajith Rajapakshe
Date Started : 31.03.2019
Last Updated : 25.04.2019


- JSP/Servlet Video Lecture / Lecture Slides / Web Tutorials -


- Contents -

	1. Web applications
	2. JSP/Servlet lifecycles
	3. MVC architecture
	4. Server side configuration & environment setup (Apache Tomcat 8)
	5. Explain development of full-fledged (from front-end to back-end) sample application including database server
	6. Good coding standards, conventions
	7. Server side debugging & troubleshooting techniques
	8. Marking Rubric of JSP/Servlet project


- Web Applications -

Multiple Clients --> (HTTP Request) --> Server 
Multiple Clients <-- (HTTP Response) <-- Server

Server may be inside your own machine as localhost or can deploy the server in a different machine over the network 
When client and server are in different machines, you have to have protocols to communicate between them

Client -> Browser -> URL -> Protocol://IPaddress(or domain name):port/ApplicationName -> Server

eg: If server's IP address is 172.18.10.20 --> http://172.18.10.20:8080/ApplicationName
	If the the server is in your own machine --> https://localhost:8443/ApplicationName

Port numbers for different protocols:
	http  - 80
	https - 443 [to communicate in a secure/encrypted way]
	(Port numbers 0 to 1023 are reserved ports for well known services)
	(This is the port on which server is listening, it’s optional and if we don’t provide it in URL then request goes to the default 
	port of the protocol)

In HTTPS, the request is sent encrypted by the client and the server decrypts the request, process the request
Then, the server sends an encrypted response to the client, where the client has to download a certificate to decrypt the response

Server is a process, that listens to one or more ports
When ports get requests, the server caters those requests, process them and send responses to clients (Client - Server Architecture)

CLient ->    Web Server     ->  Application Server  ->   Databse Server
          (Web Application)    (Enterprise Archive)     (Oracle / MySQL)
            (Web Archive) 
				(Apache Tomcat Server 8)

eg:- mysql://IPaddress:3306/DatabaseName


- Development of the Application -

	1. Develop the application
	2. Compile the application
	3. Build the application
	4. Deploy the application to the server
	5. Start the server and run the application
	6. Access the service using the browser


- Servlet -

A pure java class that contains set of life cycle methods (Order of execution is predefined / can't change the order):

	1. init()     --->  initialization

	2. service()  --->  contains set of http methods
		1) doGet    ->  retrieve/fetch data from remote server (eg: getEmployeeID)
		2) doPost   ->  create instance remotely
		3) doPut    ->  update instance in a remote machine
		4) doDelete ->  delete data in a remote machine

	3. destroy()  --->  termination

You can overide those mothods (eg: doGet, doPost), Use SQL to update, delete data when developing the application

//protected void doGet(HttpServletRequest req, HttpServletResponse res)
//The above 2 parameters must be there in each and every get and post method

*/


//Servlet
class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

	}
}


/*

- JSP(JavaServer Pages) -

JSP  ->      HTML      (static)
	           + 
	       <% Java %>  (dynamic)


Between <%   %> you can write any logic that you want in Java

Using <%=   %> will output the result of the expression between the brackets to the screen
Basically, what <%= %> does is to call the toString() method of the expression that is being evaluated
eg: Instead of ==>  <% System.out.println("Hello World") %>  , you can simply write ==>  <%= "Hello World" %>


Servlet Compilation:- Servlet -> JRE(Java Runtime Environment) -> .class -> run
JSP Compilation:- JSP -> JSP Engine -> Servlet -> JRE -> .class -> run


JSP lifecycle:-

	1. jspInit()     -> can be overridden 
	2. _jspService() -> can not be overridden
	3. jspDestroy()  -> can be overridden


- Using Eclipse - 

Java EE (Enterprise Edition) is needed to create dynamic web projects (can't be done in Java SE (Standard Edition))
eg: IDE (Integrated Development Environment) -> Eclipse Oxygen EE, Eclipse Neon EE

Eclipse code auto-generations (setters, getters, constructors): Right click on the text editor -> Sources

New Project -> Dynamic Web Project -> Target Runtime = "Apache Tomcat v8.x"
Right click on WebContent -> New -> JSP file

Windows -> Show View -> Servers
Right click on Tomcat v8.5 server at localhost -> Start
Right click on the project -> Run as -> Run on server

In Eclipse Workspace, an instance of the actual server will be created
You can add multiple server instances with different port numbers

Right click on src -> new -> package
Right click on the package -> new -> servlet
Override necessary methods in the servlet


- Advantages of Adding Packages for the Application -

	1. Seperate similar things in similar layers (eg: models, controllers, views, services)
	2. Enhances the application
	3. Readability of the application increases
	4. Easy to troubleshoot the application


- MVC Architecture -

This is not a design pattern, but an architectural pattern
MVC - Model, View, Controller

		-->   View1	  -->			     -->
User  		          	    Controller        Model  <--->  Database 	   
		<--   View2   <--				 <--

Duties of the controller:
	1. Get request from user
	2. Set request data to the model object
	3. Directs the response to the other view


- JavaBeans -

Classes that encapsulate many objects into a single object (the bean)

A JavaBeans class should follow these conventions:
	1. Must implement serializable
	2. It should have a public no-arg constructor
	3. All properties in Java must be private with public getters and setters

Setter method (Mutator):
	1. It should be public in nature
	2. The return type shoud be void
	3. The setter method must be prefrixed with set
	4. It should take some argument

Getter method (Accessor):
	1. It should be public in nature
	2. The return type should not be void
	3. The getter method must be prefixed
	4. It should not take argument void

For boolean properties, getter method name can be prefixed with either 'is' (recommended) or 'get'

*/


//Structure of a JavaBean Class 
public class TestBean {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}


/*

- HTTP Status Codes -

200  ->  Run Successfully (Request is OK) 
201  ->  Created (The request is complete and a new resource is created)
202  ->  Accepted (The request is accespted for processing, but the processing is not complete)
400  ->  Bad Request (The server did not understand the request)
401  ->  Unauthorized (The requested page needs a username and a password)
402  ->  Payment Required
403  ->  Forbidden (Access is forbidden to the requested URL)
404  ->  Page Not Found Error (Server can't fine the requested page)
408  ->  Request Timeout (The request took longer than the server was prepared to wait)
410  ->  Gone (The requested page is no longer available)
414  ->  Request-url Too Long (The server will not accept the request, because the url is too long - 
		 Occurs when you convert a "post" request to a "get" request with a long query information)
415  ->  Unsupported Media Type (The server will not accept the request, because the media type is not supported)
500  ->  Internal Server Error (Request wasn't completed, the server met an unexpected condition)
501  ->  Not Implemented (The request was not completed because the server did not support the functionality required)
502  ->  Bad Gateway (The request was not completed because the server received an invalid response from the upstream server)
503  ->  Service Unavailable (The request was not completed because the server is temporarily overloading or down)
504  ->  Gateway Timeout (The gateway has timed out)
505  ->  HTTP Version Not Supported (The server does not support the "http protocol" version)


HTTP Request contains 2 parts:
	1. Request header - http methods, http status code, date/time time stamp which you sent the data, 
					    protocol, content type (text / html)
	2. Request body - data (html, etc)


- Layered Architecture -

Presentation Layer  ->  Service Layer  ->  Data Access Layer  ->  Persistence Layer  ->  Database
	(Controller)			(Service, SQL statements)

Don't write SQL queries (Database Logic / CRUD Operations) in the controller (servlet)
CRUD -> Create, Read, Update, Delete 
In the controller - business logic only
Create a seperate class for SQL queries (Database Logic / CRUD Operations)
eg: Controller  ->  IService Interface  ->  ServiceImplementation Class -> Database
	[Write data access logic (SQL queries / Database Logic / CRUD Operations) in the ServiceImplementation Class]

Call the Service layer with in the controller
Controller -> IServices -> ServiceImpl

Use loggers instead of using System.out.print() which prints to the console (eg: in exception handling)
Use comments everywhere (interfaces, classes etc.)
SQL queries in one XML file in /WEB-INF folder (WebContent/WEB-INF)
Use seperate packages for separate sections
Refer the marking guide

*/


//index.jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Application</title>
</head>
<body>

<%-- This is 
		  a JSP 
			 comment --%>

<% //This is a single line comment %>

<% /* This is also a  
				multi-line 
						comment */ %>


<%-- 	
	<%
		for(int i = 0; i < 10; i++) {
	%>

	<input type = "text" value = "<%= i%>" />

	<h1>Value is <%= i%></h1>

	<%
		}
	%> 
--%>


<form method = "post" action = "AddServlet">

	No1 = <input type = "text" name = "no1" /> <br /><br />
	No2 = <input type = "text" name = "no2" /> <br /><br />
	
	<input type = "submit" name = "add" value ="Add Numbers" />
		
</form>	
	
</body>
</html>


//AddServlet.java
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));

		int total = no1 + no2;

		// redirecting the response into another Results.jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Results.jsp");
		
		// if Results.jsp was in the WebContent folder (first / is for WebContent folder(root)) ->
		// RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Results.jsp");

		// redirecting the value of total to Results.jsp page
		request.setAttribute("sum", total);
		dispatcher.forward(request, response);
	}
}


//Results.jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
	<%
		int value = (Integer) request.getAttribute("sum");
	%>

	<h1>Value is = <%=value%></h1>

</body>
</html>


//Simple Calculator in JSP/Servlet Project
//OOPEmployeeWebApp Sample Project

//Import new application to Eclipse
//File -> Import -> Select root directory -> Give the path of the project -> Finish

//Removing errors
//Right click on the project -> Properties -> Java Build Path -> Libraries -> Select files with errors -> Remove -> 
//Add Library -> JRE System Library -> Alternate JRE -> Give the JDK version -> Finish -> OK

//MySql Command Line Client -> Enter the password 
//create database oop; 
//show databases;
//drop database oop;


//If forget the mysql password:-

//1.Task Manager -> Services -> Right click on MySQL process and stop it

//2.Create reset.txt
//USE mysql;
//UPDATE mysql.user SET Password = PASSWORD('tharinda') WHERE User = 'root';
//FLULSH PRIVELEGES;

//3.Open cmd on the MySQL bin directory or navigate there using cd
//C:\Program Files\MySQL Server 8.0\bin>  <-- Prompt on cmd should be like this

//C:\Program Files\MySQL Server 8.0\bin>
//mysqld --defaults-file="C:\\ProgramData\\MySQL\\MySQL Server 8.0\\my.ini" --init-file=C:\Users\USER\Desktop\Working Directory\reset.txt

//4.Task Manager -> mqsqld.exe -> Select 'End Process' by right clicking on it

//5.Task Manager -> Services -> Right click on MySQL process and start it

//6.MySql Command Line Client -> Enter the password (new password)


//Database connection on Eclipse

//Window -> Show View -> Data Source Explorer
//Data Source Explorer -> Right click on Database Connections -> New -> MySQL (Name = New MySQL) -> Next -> 
//Click on Divers icon (New Driver Definition) -> MySQL JDBC Driver 5.1 -> Go to JAR List tab from Name/Type tab -> Add JAR/zip -> 
//Give the path for the .jar file (.../OOPEmployeeWebApp/OOPEmployeeWebApp/WebContent/WEB-INF/lib/mysql-connector-java-5.1.6.jar) ->
//Remove the existing .jar file -> OK -> Give the mysql login password in the form -> 
//Modify URL and Database fields replacing 'database' by the name of the created MySQL database (eg: oop) -> 
//Test Connection -> Finish (after test is successful)
//Expand Database Connection folder in Data Source Explorer
//Tables -> Employee -> right click -> Data -> Edit


//Debug the application to isolate the error and find exactly where the error comes

//Servers -> Right click on the server -> Restart in Debug
//Select debug points in the application -> Right click on the project -> Debug As -> Debug on Server
//press f6


//In utility (helping) servlets, you are going to throw exceptions
//In service servlets, you are going to catch exceptions


//Java Web Technologies:


//Java provides support for dynamic web applications through Servlets and JSPs


//Web Server is a software that can process the client request and send the response back to the client
//For example, Apache is one of the most widely used web server
//Web Server runs on some physical machine and listens to client request on specific port


//A web client is a software that helps in communicating with the server
//Some of the most widely used web clients are Firefox, Google Chrome, Safari etc.


//When we request something from server (through URL), web client takes care of creating a request and sending it to server and then 
//parsing the server response and present it to the user


//HTML (HyperText Markup Language) 
//Web Server and Web Client are two separate softwares, so HTML is the common language for communication between server and client 


//HTTP (HyperText Transfer Protocol)
//HTTP is the common communication protocol between server and client which runs on top of TCP/IP communication protocol


//Java Servlet and JSPs are server side technologies to extend the capability of web servers by providing support for dynamic response 
//and data persistence


//Sample HTTP Request

GET /FirstServletProject/jsps/hello.jsp HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache


//Sample HTTP Response

200 OK
Date: Wed, 07 Aug 2013 19:55:50 GMT
Server: Apache-Coyote/1.1
Content-Length: 309
Content-Type: text/html;charset=US-ASCII

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello</title>
</head>
<body>
<h2>Hi There!</h2>
<br>
<h3>Date=Wed Aug 07 12:57:55 PDT 2013
</h3>
</body>
</html>


//We will use “Eclipse IDE for Java EE Developers” for creating our first servlet application

//Since servlet is a server side technology, we will need a web container that supports Servlet technology, so we will use 
//Apache Tomcat server


//Go to Eclipse Preference and select Server Runtime Environments and select the version of your tomcat server
//Provide the apache tomcat directory location and JRE information to add the runtime environment
//Now go to the Servers view and create a new server pointing to the above added runtime environment
//If Servers tab is not visible, then you can select Window > Show View > Servers so that it will be visible in Eclipse window
//Try stopping and starting server to make sure it’s working fine
//If you already started the server from terminal, you have to stop it from terminal and start it from Eclipse for it to work properly
//Now we are ready with our setup to create first servlet and run it on tomcat server
//Select File > New > Dynamic Web Project and provide runtime as the server we added previously
//Provide the module version as 3.0 to create our servlet using Servlet 3.0 specs
//When we click on Finish , it generates Servlet skeleton code, so no need to type in all the different methods and imports in the servlet


//Now we will add some HTML with dynamic data code in doGet() method that will be invoked for HTTP GET request
//Now chose Run > Run on Server option from servlet editor window
//After clicking finish, browser will open in Eclipse
//You can open it outside of Eclipse also in any other browser


package com.journaldev.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/FirstServlet" , "/FirstServlet.do"}, 
	initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
	public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}


//Servlet is used to generate HTML and send it in response
//In doGet() implementation, we are creating an HTML document as writing it in response PrintWriter object & adding dynamic information
//It’s good for start but if the response is huge with lot of dynamic data, it’s error prone and hard to read and maintain
//This is the primary reason for introduction of JSPs


//JSP is also server side technology and it’s like HTML with additional features to add dynamic content where we need it
//JSPs are good for presentation because it’s easy to write as it’s like HTML


<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello</title>
</head>
<body>
<h2>Hi There!</h2>
<br>
<h3>Date=<%= new Date() %>
</h3>
</body>
</html>


//Web Container

//Tomcat is a web container
//When a request is made from client to web server, it passes the request to web container
//Web container should find the correct resource to handle the request (servlet or JSP) 
//Then the web container should use the response from the resource to generate the response and provide it to web server
//Then web server sends the response back to the client

//When web container gets the request and if it’s for servlet, container creates two Objects HTTPServletRequest and HTTPServletResponse
//Then it finds the correct servlet based on the URL and creates a thread for the request
//Then it invokes the servlet service() method and based on the HTTP method
//service() method invokes doGet() or doPost() methods
//Servlet methods generate the dynamic page and write it to response
//Once servlet thread is complete, container converts the response to HTTP response and send it back to client


//Some of the important work done by web container are:

//1.Communication Support  
		//Container provides easy way of communication between web server and the servlets and JSPs
		//Because of container, we don’t need to build a server socket to listen for any request from web server
		//Because of container, we don’t need to parse the request and generate response
		//All these important & complex tasks are done by container and all we need to focus on is the business logic for the application

//2.Lifecycle and Resource Management 
		//Container takes care of managing the life cycle of servlet
		//Container takes care of loading the servlets into memory, initializing servlets, invoking servlet methods and destroying them
		//Container also provides utility like JNDI for resource pooling and management

//3.Multithreading Support
		//Container creates new thread for every request to the servlet and when it’s processed the thread dies
		//So servlets are not initialized for each request which saves time and memory

//4.JSP Support
		//JSPs doesn’t look like normal java classes and web container provides support for JSP
		//All JSPs in the application are compiled by container & converted to Servlet and then container manages them like other servlets

//5.Miscellaneous Task
		//Web container manages several tasks behind the scene that makes our life easier
		//It manages the resource pool
		//It does memory optimizations
		//It runs garbage collector
		//It provides security configurations
		//It supports for multiple applications
		//It supports hot deployment 


//Web Application Directory Structure
//Java Web Applications are packaged as Web Archive (WAR) and it has a defined structure


//Deployment Descriptor
//web.xml file is the deployment descriptor of the web application
//It contains mapping for servlets (prior to 3.0), welcome pages, security configurations, session timeout settings etc.


//Web Application Framework
//It is a piece of structural software that provides automation of common tasks of the domain 
//It is a built-in architectural solution that can be easily inherited by applications implemented on the framework


//Common Tasks of the Web Application:-

//1.Binding Request Parameters to Java Types
//2.Validating Data
//3.Making calls to business logic
//4.Making calls to the data layer
//5.Rendering presentation layer (HTML, …)
//6.Providing internationalization and localization
//7.Keep Presentation Layer Separate from Data Layer


//MVC:-

//The model view controller pattern is the most used pattern for today’s world web applications
//It has been used for the first time in Smalltalk and then adopted and popularized by Java
//At present there are more than a dozen PHP web frameworks based on MVC pattern 


//Model:-

//Does all the computational work
//It is input/output free
//All communication with the model is via methods


//Controller:-

//User input goes to the controller
//Tells the model what to do


//View:-

//Shows results
//It is a window into the model
//The view can get results from the controller
//The view can get results directly from the model


/*

Client -> (HTTP Request) -> Controller -> (Request Data Objects) -> Model -> (return) -> Controller -> 
								(Send Model Data Objects) -> View -> (Send Formatted Response) -> Controller -> (HTTP Response) -> Client

*/


//Applying MVC to Web Applications

//View       :- HTML form, native Java interface, client-side script, applet
//Controller :- Java servlet, session Bean
//Model      :- Entity Bean or other business logic object


//Interchangeable Elements

//View       :- HTML form becomes touch-screen
//Controller :- JSP becomes session bean
//Model      :- Entity Bean	


//Views and Controllers closely interact (HTML/JSP)
//If HTML code is written out entirely through JSP, the Controller and View (conceptually) merge
//A Controller-View pair works with one Model
//One Model may have multiple Controller-View pairs


//MVC Advantage:-

//Single point of entry to Model object
//Multiple-client support
//Design clarity
//Modularity
//Controlled growth
//Portable
//Separation of concerns


//Java Server Page (JSP)

//A simplified, fast way to create dynamic web content
//HTML or XML pages with embedded Java Code or Java Beans
//Can be a mix of template data in HTML/XML with some dynamic content

//Java Server Pages are HTML pages embedded with snippets of Java code.
//It is an inverse of a Java Servlet

//Four different elements are used in constructing JSPs:- 
	//Scripting Elements
	//Implicit Objects
	//Directives
	//Actions


//JSP Example:-

//index.jsp

//The next line is the Page Directive								
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<html>
	<head>
		<title>JSP</title>
	</head>
	<body>
		<%= new String("Hi From JSP") %>
		//This is the Java code
		//The output of this code will be printing the above string on the browser
	</body>
</html>


//JSP Advantages:-

//High Performance
//Has access to all the powerful Enterprise Java APIs, including JDBC, JNDI, EJB, JAXP 
//Can be used in combination with servlets


//Scripting Elements 

//There are three kinds of scripting elements
	//Declarations
	//Scriptlets
	//Expressions


//Declarations

//Declarations are used to define methods & instance variables
//Do not produce any output that is sent to client
//The functions and variables defined are available to the JSP Page as well as to the servlet in which it is compiled
//Embedded in <%! and  %> delimiters


//Declaration Example
<%!
	int myVar = 123;

	Public void jspDestroy() {
		System.out.println(“JSP Destroyed”);
	}

	Public void jspInit() {
		System.out.println(“JSP Loaded”);
	}
%>


//Scriptlets

//Used to embed java code in JSP pages
//Contents of JSP go into _JSPpageservice() method
//Code should comply with syntactical and semantic constuct of java
//Embedded in <% and %> delimiters


//Scriptlets Example
<%
	int x = 5;
	int y = 7;
	int z;

	z = x + y;
%>	


//Expressions

//Used to write dynamic content back to the browser
//If the output of expression is Java primitive the value is printed back to the browser
//If the output is an object then the result of calling toString() on the object is output to the browser
//Embedded in <%= and %> delimiters


//Expressions Examples

<%="Fred" + " " + "Flintstone"%>
//Prints "Fred Flintstone" to the browser

<%=Math.sqrt(100)%>
//Prints 10 to the browser


//JSP Actions

//Processed during the request processing phase (As opposed to JSP directives which are processed during translation_
//Standard actions should be supported by J2EE compliant web servers
//Custom actions can be created using tag libraries

//The different actions are,
	//Include action
	//Forward action
	//Param action
	//useBean action
	//getProperty action
	//setProperty action
	//plugIn action


//JSP Actions - Include Action

//Include action used for including resources in a JSP page
//Include directive includes resources in a JSP page at translation time
//Include action includes response of a resource into the response of the JSP page
//Same as including resources using RequestDispatcher interface
//Changes in the included resource reflected while accessing the page.
//Normally used for including dynamic resources


//Example 1 for Include Action

<jsp:include page="includePage.jsp">
//This is the JSP Include Action
//This includes the the output of includePage.jsp into the page where this is included.


//Example 2 for Include Action

//include.jsp
<body>
	<p>- Carlos Ruiz Zafon, The Prisoner of Heaven</p>
</body>

//index.jsp
<body>
	<p>We only remember what never happened</p>

	<jsp:include page="include.jsp"></jsp:>
	//This is the JSP Include Action
	//This includes the the output of include.jsp into the page where this is included.

	//Output:-
	//We only remember what never happened
	//- Carlos Ruiz Zafon, The Prisoner of Heaven
</body>


//JSP Actions - Param Action

//Used in conjunction with Include & Forward actions 
//This is used to include additional request parameters to the included or forwarded resource


//Example for Param Action
<jsp:forward page="Param2.jsp">
	<jsp:param name="FirstName" value="Sanjay">
	//This will result in the forwarded resource having an additional parameter FirstName with a value of Sanjay
</jsp:forward>


//Syntax Summary

//Scriplet - nest Java code
<% System.output.println("Message in the Console"); %>

//Declaration Tag - define variables
<%! int x = 5; %>

//Expression Tag - print java variables
<%= x %>

//Comment Tag - add comments
<%-- This is JSP comment --%>


//Simple JSP Loop

//index.jsp

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>

	<body>

		//Declaring variable
		<%! int elements = 10; %>

		//Preparing loop
		<% for(int i = 0; i < elements; i++) { %>

			//Adding CSS styling to the printing values
			<div style="color:green">

				//Printing value
				<%= i %>

			</div>

		//Finishing loop
		<% } %>

	</body>

</html>


//Servlets

//Servlets are small programs that execute on the server side of a web connection
//Servlets dynamically extend the functionality of a web server
//Java Servlets/JSP are  part of the Sun’s J2EE Enterprise Architecture (The web development part)

//Java Servlet is a simple, consistent mechanism for extending the functionality of a web server
//Java Servlets are precompiled Java programs that are executed on the server side.
//Java Servlets require a Servlet container to run in
//Java Servlets are portable to any java application server


//Advantages of Servlets:-

//1. Work well in a Heterogeneous Environments
		//OS and platform neutral
		//Work with all major web servers (IIS, Apache,etc..)

//2.Well defined Web Architecture framework
		//Has automatic fallback to URL re-writing
		//Standard built in services such as:
			//Standard Approach to Authentication using declarative security vice programmatic security
			//Database connection pooling
			//Complete support for sessions via cookies and/or URL re-writing
		

//How Servlet Works:-

/*

Client -> (HTTP Request) -> Server -> (HTTP Request) -> Servlet (which is inside the Web Container) -> (Query Formation) -> 
											Database -> (Query Run) -> Servlet -> (HTTP Response) -> Server -> (HTTP Response) -> Client

*/


//The Life Cycle of a Servlet

//A servlet life cycle can be defined as the entire process from its creation till the destruction
//The following are the paths followed by a servlet:
	//init()
	//service( )
	//destroy( )


/*

init() -> Servlet (In Service) -> destroy()
				Service()
				HTTP:
				  doGet()
				  doPost()
				  doHead()
				  doOptions()
				  doTrace() 
				  etc.

*/


//The init() Method

//The init method is called only once when the servlet is created
//When a user invokes a servlet, a single instance of each servlet gets created, with each user request resulting in a new thread
//That new thread is handed off to doGet() or doPost() as appropriate

public void init(ServletConfig config) throws ServletException {
	//
}


//The service() Method

//The service() method is the main method to perform the actual task
//Each time the server receives a request for a servlet, the server spawns a new thread and calls service

//The servlet container (i.e. web server) calls the service() method to do 2 things:
	//To handle requests coming from the client( browsers)
	//To write the formatted response back to the client.

//The service() method checks the HTTP request type (GET, POST, PUT, DELETE, etc.)
//Then calls doGet(), doPost(), doPut(), doDelete(), etc. methods as appropriate

public void service(ServletRequest request, ServletResponnse response) throws ServletException, IOException {
	//
}


//The destroy() Method

//The destroy() method is called only once at the end of the life cycle of a servlet
//After the destroy() method is called, the servlet object is marked for garbage collection.

//This method gives your servlet a chance to perform cleanup activities:
	//Close database connections
	//Halt background threads
	//Write cookie lists
	//Hit counts to disk

public void destroy() {
	//Finalization code...
}


//The HttpServlet class

//HttpServlet class servers client’s HTTP request
//For each of the HTTP methods, GET, POST and other corresponding methods
	//doGet()  - Serves HTTP GET request
	//doPost() - Servers  HTTP POST request

//The servelet usually must implement one of the first two methods or the service().. method


//The HTTPServeltRequest Object

//Contains the request data from the client
	//HTTP request headers
	//Form data and Query parameters
	//Other client data (cookies, path, etc.)


//The HTTPServeltResponse Object

//Encapsulate data and send back to the client
	//HTTP response headers(Content type)
	//Response Body


//The most important servlet functionalities

//1.Retrieve the HTML Form parameters from the request (Both get and post parameters)
HttpServletRequest.getParameter(String)

//2.Retrieve a servlet initialization parameter
ServletConfig.getInitParameter()

//3.Retrieve HTTP request header information
HttpServletRequest.getHeaader(String)


//Building Tool - Maven

//Maven is a process of applying patterns to a build infrastructure in order to provide a coherent view of software projects

//Maven provides a way to help with managing:
	//Builds
	//Documentation
	//Reporting
	//Dependencies
	//Software Configuration Management
	//Releases
	//Distribution


//Advantages of Maven:

//Make the development process visible or transparent
//Provide an easy way to see the health and status of a project
//Decreasing training time for new developers
//Bringing together the tools required in a uniform way
//Preventing inconsistent setups
//Providing a standard development infrastructure across projects
//Focus energy on writing applications


//Maven Architecture

/*

								-> Plugin (eg: jar)
Projects to build -> Maven Core -> Plugin (eg: surefire)
								-> Plugin (eg: release)

			(Local Machine)			(Remote repository
											or
									  local install)

*/


//Common project metadata format

//POM = Project Object Model = pom.xml
//Contains metadata about the project
	//Location of directories
	//Developers/Contributors
	//Issue tracking system
	//Dependencies
	//Repositories to use
	//etc.


//Example for common project metadata format
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.codehaus.cargo</groupId>
  <artifactId>cargo-core-api-container</artifactId>
  <name>Cargo Core Container API</name>
  <version>0.7-SNAPSHOT</version>
  <packaging>jar</packaging>
  <dependencies/>
  <build/>
[…]
