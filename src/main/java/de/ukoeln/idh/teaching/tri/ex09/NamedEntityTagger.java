package de.ukoeln.idh.teaching.tri.ex09;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class NamedEntityTagger extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		//TODO: implement annotation and type
		// iterate over tokens
		for (Token token : jcas.select(Token.class)) {
			// TODO: uppercase -> new NE (PER)
			// check uppercase
			char first = token.getCoveredText().charAt(0);
			if (Character.isUpperCase(first)) {

				// create a new NamedEntity annotation
				NamedEntity ne = new NamedEntity(jcas, token.getBegin(), token.getEnd());
				// set a feature value to PER
				ne.setValue("PER");
				// add the feature structure to CAS indexes
				ne.addToIndexes();
			}
		}
	}

}
