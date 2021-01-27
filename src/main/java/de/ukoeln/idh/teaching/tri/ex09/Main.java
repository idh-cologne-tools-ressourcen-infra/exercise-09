package de.ukoeln.idh.teaching.tri.ex09;

import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;
import org.dkpro.core.io.conll.Conll2002Writer;
import org.dkpro.core.io.text.TextReader;
import org.dkpro.core.tokit.BreakIteratorSegmenter;

public class Main {

//	Which brings us to step 4 :-)
//
//	Please write a simple named entity tagger according to the rules below. To this end, you'll need to
//
//	create a class that inherits from org.apache.uima.fit.component.JCasAnnotator_ImplBase.
//	add the class to the pipeline by adding an instance of a AnalysisEngineDescription to the SimplePipeline.runPipeline(...) 
//	call, similar to the tokeniser class.
//	implement the process(...) method in your class. Please add code such that each token that starts with an upper case letter
//	is detected as a named entity. 
//	The type for named entities is called de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity. 
//	Set the Value attribute of the annotation to PER. I.e.: 
//	We assume that every upper-cased word represents a person entity (not true of course, but we'll add complexity later).
				
	public static void main(String[] args)
			throws ResourceInitializationException, AnalysisEngineProcessException, CollectionException, IOException {

		// initialize collection reader
		CollectionReaderDescription readerDescription = CollectionReaderFactory.createReaderDescription(
				TextReader.class, TextReader.PARAM_SOURCE_LOCATION, "src/main/resources/reviewaa*");

		// initialize tokenizer
		AnalysisEngineDescription tokenizer = AnalysisEngineFactory
				.createEngineDescription(BreakIteratorSegmenter.class);
		
		//initialize tagger
		AnalysisEngineDescription tagger = AnalysisEngineFactory
				.createEngineDescription(EntityTagger.class);

		// initialize output writer
		AnalysisEngineDescription writer = AnalysisEngineFactory.createEngineDescription(Conll2002Writer.class,
				Conll2002Writer.PARAM_TARGET_LOCATION, "target", Conll2002Writer.PARAM_OVERWRITE, true);

		
				
		// run the pipeline
		SimplePipeline.runPipeline(readerDescription, tokenizer, tagger, writer);

	}

}
