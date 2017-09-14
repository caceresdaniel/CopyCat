I'LL FIX THIS LATER STOP 

# CopyCat
**Our Goals**
* Learn about networking.
* The whole development cycle. 
* How to transform business requirement to software development plan.
* How to we decide to do what and when?/
#### Business Requirement
An android-only instant messenger software with automatic translation among two people. Our instant messenger will be a phone application and will rely on a phone directory to communicate with other people. The app will support notification of an incoming text. Every user shall be able to select the language that they would want to read the incoming text in. 
\
#### Account Creation & Management
As a new user I will open the application and create an account using my phone number, then entering a username and password.
Forgotten password workflow.
\
#### Development Plan
**Tools used**
The team decided to use Android Studio to create an android application. The server is going to run on a Windows PC.
\
#### Things to Keep in Mind
For the usernames, how would they be unique?
HTTP Protocol to exchange data in JSON format. This pattern is also called REST.
*Server* - Use nodeJS (HTTP server).
\
#### Work History
**Phase zero**	: Getting Started (TODO: 9/9/17)
Get Android studio and play with it 
**Phase one**	: Proof of Concept (TODO: 9/17/17)
Do the Hello World of the nodeJS server. 
HTTP GET (get the data out) and HTTP POST, to get and send a text message in a JSON format. <return>
		Example: 
```{
 				"index": 12,
    				"user": "john",
    				"msg": "some message text"
				“Language”: “english”
}```
Learn to use git. Create a common github repository for this project, everybody needs to contribute to this repo.
Create a test client to test a nodeJS server. Create a server and client in Java. 
Research how to use Java to send and receive JSON via HTTP.
