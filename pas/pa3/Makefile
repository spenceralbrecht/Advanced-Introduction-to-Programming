#simple Makefile for GCD.java
GCD: GCD.class
	echo Main-class: HelloWorld > Manifest
	jar cvfm GCD Manifest GCD.class
	rm Manifest
	chmod u+x GCD

GCD.class: GCD.java
	javac -Xlint GCD.java

clean:
	rm -f GCD.class GCD

submit: Makefile GCD.java
	submit cmps012a-pt.f15 lab4 Makefile GCD.java
