# CopyCat
**Our Goals**
* Learn about networking.
* The whole development cycle. 
* How to transform business requirement to software development plan.
* How to we decide to do what and when?

## Plan

#### Business Requirement
An android-only instant messenger software with automatic translation among two people. Our instant messenger will be a phone application and will rely on a phone directory to communicate with other people. The app will support notification of an incoming text. Every user shall be able to select the language that they would want to read the incoming text in. 

##### Account Creation & Management
As a new user I will open the application and create an account using my phone number, then entering a username and password.
Forgotten password workflow.

#### Development Plan
**Tools used**\
The team decided to use Android Studio to create an android application. The server is going to run on a Windows PC.

## Things to Keep in Mind
* For the usernames, how would they be unique?
* HTTP Protocol to exchange data in JSON format. This pattern is also called REST.
* *Server - Use nodeJS (HTTP server)*.

##### Steps to Git

* Always pull before anything make sure your master and your current working branch are up to date to check type git status, since we will just be working on our own individual branches we just need to update our branches to the master branch to do so type git pull origin master this will pull the files from the master repo in to your current working branch

* When you are up to date with master you can now make changes make sure you are making changes while in your branch(git checkout "your branch name")

* After you make changes the sequence of commands are git add . git commit -m "message explainging the changes you have made in that push" if it is the first time you are pushing with that branch you have to set it up as an upstream to do so type git push -u origin "branch name" if the branch has already been set up as an upstream you can simply type git push

Congrats you pushed to your branch

Once youve pushed to your branch and you want to merge them with the master brach you have to send a pull request through the website from there the owner of the repo will accept or decline the pull request

## Work History
##### ~Phase zero 	: Getting Started (TODO: 9/9/17)~
* Get Android studio and play with it 
##### ~Phase one		: Proof of Concept (TODO: 9/17/17)~
* Do the Hello World of the nodeJS server. 
* HTTP GET (get the data out) and HTTP POST, to get and send a text message in a JSON format. 
		**Example** 
```
{
 	"index": 12,
    	"user": "john",
    	"msg": "some message text"
	“Language”: “english”
}
```	
* Learn to use git. Create a common github repository for this project, everybody needs to                                      contribute to this repo.
* Create a test client to test a nodeJS server. Create a server and client in Java. 
* Research how to use Java to send and receive JSON via HTTP.
##### ~Phase two			: Create the Messenger (TODO: 10/27/17)~
* Review socket.io and follow tutorial to get some work (hopefully) done to share with the team.
* https://socket.io/blog/native-socket-io-and-android/

# socket.io-android-chat

Original Code Obtained from https://github.com/nkzawa/socket.io-android-chat

## License

MIT
