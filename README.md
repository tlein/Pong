**Compiling:**  
	Command Line:  Run this in the root path of the project, make sure to create a bin/ directory there.  

*Windows:*
	<pre>
```javac -d "bin/" -classpath "lib/slick.jar;lib/lwjgl.jar" src/org/tlein/pong/Game.java src/org/tlein/pong/entities/*.java``` </pre>
*Unix:*
	<pre>
```javac -d "bin/" -classpath "lib/slick.jar:lib/lwjgl.jar" src/org/tlein/pong/Game.java src/org/tlein/pong/entities/*.java``` </pre>
**Running:**  
	Command Line:  Run this in the root path of the project  
  
*Windows:*
	<pre>
```java -cp "lib/*;bin/" -Djava.library.path="natives/" org.tlein.pong.Game``` </pre> 
*Unix:*  
	<pre>
```java -cp "lib/*:bin/" -Djava.library.path="natives/" org.tlein.pong.Game``` </pre>