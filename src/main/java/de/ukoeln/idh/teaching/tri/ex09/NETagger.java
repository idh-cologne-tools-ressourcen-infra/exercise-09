package de.ukoeln.idh.teaching.tri.ex09;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.SelectFSs;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;


public class NETagger extends org.apache.uima.fit.component.JCasAnnotator_ImplBase{

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		SelectFSs<Token> selector = aJCas.select(Token.class);
			for (Token token : selector.asList()) {
				if (token.getCoveredText().matches("[A-Z].*"))  {
					NamedEntity ne = new NamedEntity(aJCas);
					ne.setBegin(token.getBegin());
					ne.setEnd(token.getEnd());
					ne.setValue("PER");
					ne.addToIndexes();
				}
				
			}

	}
	
}