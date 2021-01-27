package de.ukoeln.idh.teaching.tri.ex09;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;


public class NamedEntityTagger extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		
		for(Token token : aJCas.select(Token.class )) {
 			if(token.getCoveredText().matches("[A-Z].*")) {
 				NamedEntity a = new NamedEntity(aJCas);
 				a.setBegin(token.getBegin());
 				a.setEnd(token.getEnd());
 				a.setValue("PER");
 				a.addToIndexes();
 				
	       }
		}
	}
}
