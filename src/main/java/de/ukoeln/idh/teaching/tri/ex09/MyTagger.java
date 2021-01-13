package de.ukoeln.idh.teaching.tri.ex09;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class MyTagger extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		for (Token token : jcas.select(Token.class)) {
			if (Character.isUpperCase(token.getCoveredText().charAt(0))) {
				NamedEntity ne = new NamedEntity(jcas, token.getBegin(), token.getEnd());
				ne.setValue("PER");
				ne.addToIndexes();
			}
		}
	}

}
