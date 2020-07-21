## Welcome brave developer!

This is a program that turns a 'streamed' input into an output, slicing it with a given criteria. So far, it takes input from stdin, and puts the sliced/chunked files to the local dir with some format.

### Assignment
1. Read and understand the code.

1. Critique (a simple enumeration of the main issues found written into an .md file is more than enough) and refactor this code according to the problems you see here. Do not limit yourself to the Main.java file. Create as many files and classes as you need to get a solid implementation.

1. Add one of this custom changes
    1. Change the input mechanism so that the program takes data from a text file instead of the stdin. This input file path should be provided as a program argument.
    1. Change the output mechanism so that the slicing happens every 50 bytes, instead of every 5 lines, but avoid splitting the lines. This means that if the 50th byte is in the middle of a line, that line must be completely written into the file before splitting the output file. This is so, in case any line is longer than 50 bytes, so that no file ends up empty.

