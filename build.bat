::@echo off
javac Game.java View.java Controller.java Model.java Json.java Sprite.java Snake.java Tail.java Head.java Fruit.java Body.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)
