## Welcome brave developer!

This is a program that turns a 'streamed' input into an output, slicing it with a given criteria. So far, it takes input from stdin, and puts the sliced/chunked files to the local dir with some format.

### Assignment
1. Read and understand the code.

1. Critique (a simple enumeration of the main issues found written into an .md file is more than enough) and refactor this code according to the problems you see here. Do not limit yourself to the Main.java file. Create as many files and classes as you need to get a solid implementation.

1. Add one of this custom changes
    1. Change the input mechanism so that the program takes data from a text file instead of the stdin. This input file path should be provided as a program argument.
    1. Change the output mechanism so that the slicing happens every 50 bytes, instead of every 5 lines, but avoid splitting the lines. This means that if the 50th byte is in the middle of a line, that line must be completely written into the file before splitting the output file. This is so, in case any line is longer than 50 bytes, so that no file ends up empty.

#####Issues I'd like to change
- unhandled exception FileNotFoundException
- unnecessary code like 'else { line = null}' and more 
- there is not closed input scanner
- it prints all files in the directory, not only created ones
- file name and maximum line number should be at least constant definition (or configurable by config)
- probably add some log messages(I am not going to solve it)
- it creates first file without any input(depends on business logic, I am not going to solve it) and I am going to start with count 1
- I am not using * import  
- I will omit exceptions handling(strongly depends on business logic)

######comment
- in my solution is also what can be optimized like creating those two fileWriters, unit tests, etc. I don't want to do this task much longer than expected 2 hours, so I have not been finishing it.  