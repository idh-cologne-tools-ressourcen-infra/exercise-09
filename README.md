# Exercise 9

This exercise is about first contact with the [Apache UIMA] framework. It is due January 20th.

## Step 1

Please clone this repository onto your local computer. On the command line, you would enter: `git clone https://github.com/idh-cologne-tools-ressourcen-infra/exercise-09`, and create a new branch using your UzK username as a name.

## Step 2

Get your IDE ready for the dependency management system Maven. 

- Eclipse: If you have a recent version, it's already installed. Otherwise, see [here](https://projects.eclipse.org/projects/technology.m2e) (or, better yet, update your Eclipse installation).
- IntelliJ: Should be available out of the box. See [here](https://www.jetbrains.com/help/idea/maven-support.html) for details.
- NetBeans: According to [this page](http://wiki.netbeans.org/Maven), Maven support is integrated in 6.7 and newer.

## Step 3

Open the project in your IDE, and let Maven install all the dependencies. If it doesn't work automatically, you may need to update the project once. If everything works well, you can run the main function in `de.ukoeln.idh.teaching.tri.ex09.Main`. It should produce output on the console and create files in the `target` directory. 

The main function in `de.ukoeln.idh.teaching.tri.ex09.Main` runs a simple pipeline on the data files in `src/main/resources`. The pipeline consists of a collection reader to read in the plain text files (`org.dkpro.core.io.text.TextReader`), a tokeniser (`org.dkpro.core.tokit.BreakIteratorSegmenter`) and a writer (`org.dkpro.core.io.conll.Conll2000Writer`). All of these classes come from the DKPro library, which is imported via Maven. The output is produced in the `target` folder and comes in a simple tabular format. Each token is printed on a line, followed by its part of speech tag and 

## Step 4






## Step 5

Commit your program to the repository and push it to the repository.