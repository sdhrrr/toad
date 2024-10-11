## Welcome to Toad 

Toad is an open source, fun and lightweight  programming language with dynamic semantics.
It is simple and easy to learn which doesn't require any compilation.
Toad is inspired from python and runs on Java Runtime Environment. 
Toad packages core programming features like flow control, functions, high level constructs like objects and closures. 

Without dumping entire documentation here, all the lexical grammar and syntax of Toad(Lox) written in BNF(Backus-Naur Form) can be read [here](https://craftinginterpreters.com/appendix-i.html).

### Getting started 
Toad is a tree-walk interpretor written in Java. Strictly speaking, Toad is a transipler which transpiler Toad code into Java Runtime code which is then run on JVM.

Toad uses a recursive descent parsing to parse the tokens into an AST(Abstract Syntax Tree) of statements and expression nodes.
Thus, Toad can recognise parse errors, can report a couple of static resolution errors and also runtime errors get reported.
Try Toad out just by downloading the lastest release.

### Try it out 
Toad can be run either by REPL or passing a Toad code file with a `.txt` extension.

Download the `Toad.jar` file. Make sure you have java runtime installed. 

Fire up the terminal and run `java -toad.jar`, now you can type and run REPLs of Toad.

If you want to run an entire file, create a new text file `sampleToadCode.txt` for a test run. 

Open the terminal in the same directory and type the following : `java -toad.jar sampleToadcode.txt`

This command will interpret and run the code written in `sampleToadCode.txt`.
La voilà, we have the outputted result in the terminal.

### Contributing to Toad
Contributions to Toad are welcomed and encouraged! 

There are many corners in Toad which need to sharpening. Please let me know of any bugs or errors which I might be oblivious of, I'll try to improve them.
Any additions like libraries or data-structures are welcomed and appreciated.
Download the source files and make improvements to the code and put a pull request.

*Make sure to test your changes before submitting the pull request.*

#### Special Thanks
This project would not have been possible without the reference book: Crafting Interpretors by [Robert Nystrom](https://github.com/munificent)
