//Here we will learn  about following things: 
A little history of the command line
How to access the command line from your own computer
How to perform some basic file manipulation
A few other useful commands
How to chain commands together to make more powerful tools
The best way to use administrator powers

It was designed to run as a multi-user system on mainframe computers, with users connecting to it remotely via individual 
terminals.

//How can open a terminal 
By clicking on the Activities item at the top left of the screen, then typing the first few letters of “terminal”, “command”,
“prompt” or “shell” then it will open the terminal or type Ctrl-Alt-T.

//Learn command
pwd : print working directory’ All it does is print out the shell’s current working directory. 
means  default location of shell.
cd : 
You can change the working directory using the cd command, an abbreviation for ‘change directory’.
cd / : 
Now your working directory is “/”. The “/” directory, often referred to as the root directory, is the base of that 
unified file system. From there everything else branches out to form a tree of directories and subdirectories.
cd home : 
pwd : From the root directory, the following command will move you into the “home” directory 
(which is an immediate subdirectory of “/”):
cd .. :
pwd : 
To go up to the parent directory, in this case back to “/”, use the special syntax of two dots (..)
cd : 
pwd : 
Typing cd on its own is a quick shortcut to get back to your home directory:
cd ../.. : 
pwd : 
you can also use .. more than once if you have to move up through multiple levels of parent directories:
cd
pwd
cd ../../etc
pwd
Most of the examples we’ve looked at so far use relative paths. That is, the place you end up at depends on your current 
working directory. Consider trying to cd into the “etc” folder.
cd
pwd
cd /etc
pwd
But we have seen two commands that are absolute. No matter what your current working directory is, they’ll have the same 
effect. The first is when you run cd on its own to go straight to your home directory. The second is when you used cd / to 
switch to the root directory. In fact any path that starts with a forward slash is an absolute path. 
whoami : 
 the whoami command will remind you of your username, in case you’re not sure.
 whoami : 
cd /home/USERNAME/Desktop : 
pwd : 
It also gives us another way to get back to your home directory, and even to the folders within it. Suppose you want 
to go straight to your “Desktop” folder from anywhere on the disk (note the upper-case “D”). In the following command 
you’ll need to replace USERNAME with your own username.
cd ~
pwd

cd ~/Desktop
pwd
There’s one other handy shortcut which works as an absolute path. As you’ve seen, using “/” at the start of your path means
“starting from the root directory”. Using the tilde character (”~”) at the start of your path similarly means “starting from 
my home directory”.

 cd
cd /
cd ~/Desktop
cd /etc
cd /var/log
cd ..
cd 

//Creating folders and files
mkdir /tmp/tutorial
cd /tmp/tutorial

mkdir is short for ‘make directory
Notice the use of an absolute path, to make sure that we create the tutorial directory inside /tmp. Without the forward 
slash at the start the mkdir command would try to find a tmp directory inside the current working directory, then try 
to create a tutorial directory inside that. If it couldn’t find a tmp directory the command would fail.
mkdir dir1 dir2 dir3
mkdir
cd /etc ~/Desktop
The mkdir command expects at least one argument, whereas the cd command can work with zero or one, but no more.
ls
Let’s take a look at them with the ls (list) command.Notice that mkdir created all the folders in one directory.
It didn’t create dir3 inside dir2 inside dir1, or any other nested structure. But sometimes it’s handy to be able to 
do exactly that, and mkdir does have a way:
mkdir -p dir4/dir5/dir6
ls
This time you’ll see that only dir4 has been added to the list, because dir5 is inside it, and dir6 is inside that.
cd dir4
ls
cd dir5
ls
cd ../..
The “-p” that we used is called an option or a switch (in this case it means “create the parent directories, too”).
mkdir another folder
ls
 suppose we want to create a directory with a space in the name? Let’s give it a go.
 You probably didn’t even need to type that one in to guess what would happen: two new folders, 
 one called another and the other called folder. 
 mkdir "folder 1"
mkdir 'folder 2'
mkdir folder\ 3
mkdir "folder 4" "folder 5"
mkdir -p "folder 6"/"folder 7"
ls
//Creating files using redirection
ls > output.txt
Suppose we wanted to capture the output of that command as a text file that we can look at or manipulate further. 
All we need to do is to add the greater-than character (”>”) to the end of our command line
cat output.txt
We can use the cat command to look at its content.
echo "This is a test"
echo "This is a test" > test_1.txt
echo "This is a second test" > test_2.txt
echo "This is a third test" > test_3.txt
ls
echo just prints its arguments back out again (hence the name). But combine it with a redirect, and you’ve got a way to easily create small test files:
cat test_1.txt test_2.txt test_3.txt
You should cat each of these files to check their contents. But cat is more than just a file viewer - its name comes from 
‘concatenate’, meaning “to link together”. If you pass more than one filename to cat it will output each of them, one after 
the other, as a single block of text.
cat test_1.txt test_2.txt test_3.txt
cat test_?.txt
cat test_*
Where you want to pass multiple file names to a single command, there are some useful shortcuts that can save you a lot of
typing if the files have similar names. A question mark (”?”) can be used to indicate “any single character” within the file 
name. An asterisk (”*”) can be used to indicate “zero or more characters”. These are sometimes referred to as “wildcard” 
characters.
cat t* > combined.txt
cat combined.txt
If you look at the output of ls you’ll notice that the only files or folders that start with “t” are the three test files we’ve 
just created, so you could even simplify that last command even further to cat t*, meaning “concatenate all the files whose
names start with a t and are followed by zero or more other characters”.
cat t* >> combined.txt
echo "I've appended a line!" >> combined.txt
cat combined.txt
If you do want to append to, rather than replace, the content of the files, double up on the greater-than character:
less combined.txt
When viewing a file through less you can use the Up Arrow, Down Arrow, Page Up, Page Down, Home and End keys to 
move through your file. Give them a try to see the difference between them. When you’ve finished viewing your file, 
press q to quit less and return to the command line.
echo "Lower case" > a.txt
echo "Upper case" > A.TXT
echo "Mixed case" > A.txt
A note about case
Unix systems are case-sensitive, that is, they consider “A.txt” and “a.txt” to be two different files. If you were to run the 
following lines you would end up with three files:
But the vast majority of shell commands are lower case,

//5. Moving and manipulating files