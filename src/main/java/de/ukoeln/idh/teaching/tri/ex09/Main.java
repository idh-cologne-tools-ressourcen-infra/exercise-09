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

	public static void main(String[] args)
			throws ResourceInitializationException, AnalysisEngineProcessException, CollectionException, IOException {
		
		// initialize collection reader
		CollectionReaderDescription readerDescription = CollectionReaderFactory.createReaderDescription(
				TextReader.class, TextReader.PARAM_SOURCE_LOCATION, "src/main/resources/reviewaa*");
		System.out.println("1");
		// initialize tokenizer
		AnalysisEngineDescription tokenizer = AnalysisEngineFactory
				.createEngineDescription(BreakIteratorSegmenter.class);
		System.out.println("2");
		AnalysisEngineDescription namedEntity = AnalysisEngineFactory
				.createEngineDescription(NETagger.class);
		System.out.println("3");
		// initialize output writer
		AnalysisEngineDescription writer = AnalysisEngineFactory.createEngineDescription(Conll2002Writer.class,
				Conll2002Writer.PARAM_TARGET_LOCATION, "target", Conll2002Writer.PARAM_OVERWRITE, true);
		System.out.println("4");
		// run the pipeline
		SimplePipeline.runPipeline(readerDescription, tokenizer, namedEntity, writer);
		System.out.println("5");
	}

}
