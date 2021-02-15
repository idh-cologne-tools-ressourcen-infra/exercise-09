package de.ukoeln.idh.teaching.tri.ex09;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class NamedEntityTagger extends org.apache.uima.fit.component.JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// iterate over tokens
				for (Token token : aJCas.select(Token.class)) {
					// check first character
					char first = token.getCoveredText().charAt(0);
					if (Character.isUpperCase(first)) {
						// create a new NamedEntity annotation
						NamedEntity ne = new NamedEntity(aJCas, token.getBegin(), token.getEnd());
						// set feature value to PER
						ne.setValue("PER");
					}
				}
	}

}
