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

The main function in `de.ukoeln.idh.teaching.tri.ex09.Main` runs a simple pipeline on the data files in `src/main/resources`. The pipeline consists of a collection reader to read in the plain text files (`org.dkpro.core.io.text.TextReader`), a tokeniser (`org.dkpro.core.tokit.BreakIteratorSegmenter`) and a writer (`org.dkpro.core.io.conll.Conll2000Writer`). All of these classes come from the DKPro library, which is imported via Maven. The output is produced in the `target` folder and comes in a simple tabular format. Each token is printed on a line, followed by its named entity tag -- which is `O`, because we have not included a named entity tagger.

## Step 4
Which brings us to step 4 :-)

Please write a simple named entity tagger according to the rules below. To this end, you'll need to

1. create a class that inherits from `org.apache.uima.fit.component.JCasAnnotator_ImplBase`. 
2. add the class to the pipeline by adding an instance of a `AnalysisEngineDescription` to the `SimplePipeline.runPipeline(...)` call, similar to the tokeniser class.
3. implement the `process(...)` method in your class. Please add code such that each token that starts with an upper case letter is detected as a named entity. The type for named entities is called `de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity`. Set the `Value` attribute of the annotation to `PER`. I.e.: We assume that every upper-cased word represents a person entity (not true of course, but we'll add complexity later).



## Step 5

Commit your program to the repository and push it to the repository.


## Useful links

- [Apache Maven](http://maven.apache.org)

- [Apache UIMA](https://uima.apache.org)
     - [Overview & Setup](https://uima.apache.org/d/uimaj-current/overview_and_setup.html)
     - [Tutorial & Developers Guide](https://uima.apache.org/d/uimaj-current/tutorials_and_users_guides.html)
     - [Tools Guide and Reference](https://uima.apache.org/d/uimaj-current/tools.html)
     - [References](https://uima.apache.org/d/uimaj-current/references.html)
- [UIMA Javadoc](https://javadoc.io/doc/org.apache.uima/uimaj-core/latest/index.html)
- [UIMAfit Javadoc](https://javadoc.io/doc/org.apache.uima/uimafit-core/latest/index.html)

- [DKPro core](https://dkpro.github.io/dkpro-core/)
- 