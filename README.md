# VERxION
Simple version controller reimplementing the basic features of `git` in java.

## VERxION
This is a simple program that is written as an experiment to reimplement the basic features of git
with the intentions of understanding git-internals.

`verxion` works like a containing folder that is used to hold projects people are working on.
Files of the projects are simply added in the main(root) folder of the project and the program
will be able to track multiple versions of a program.

The program is fully written in java and will work in version  `8.0` and above.
### Compilation
All files will be compiled when compiling the `Main.java` file.
run   `javac Main.java` in the root folder.

### Executing the program:

* Input: terminal: `> `
### Syntax
The program accepts commands in the follow way:
 `java Main` followed by a the `command name` and ` {arguments}`. 




### List of useful commands
* `cat` - prints and concatenates files to the standard output
* `cp` -copies a file into another file
* `grep` - helps to search for a file in a specific pattern
* `less` - will let you go backward and forward in the files
* `ls` - will list all files and directories in current working directory
* `mv` - helps to move one file into another file
* `pwd` - given you the current working directory


### Builtins
All the commands in the program are builtin for the user. 
* I am currently working on `merge` features.
`setup` is a git equivalent for `init`
`list-untracked` is a git equivalent for `status`
* Other commands are similar to that of the ones found in git.


### Author
* Bereket Molla