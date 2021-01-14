package de.ukoeln.idh.teaching.tri.ex09; 
 
import org.apache.uima.analysis_engine.AnalysisEngineProcessException; 
import org.apache.uima.cas.SelectFSs; 
import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.tcas.Annotation;
import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;

public class NETagger extends org.apache.uima.fit.component.JCasAnnotator_ImplBase { 
 
	public void process (JCas aJCas) throws AnalysisEngineProcessException { 
		SelectFSs<NamedEntity> selector = aJCas.select(NamedEntity.class); 
		for (NamedEntity PER: selector) { 
			if (PER.getCoveredText().equals("")) { 
				Annotation a = new Annotation(aJCas); 
				a.setBegin(PER.getBegin()); 
				a.setEnd(PER.getEnd()); 
				a.addToIndexes(); 
			} 
		} 
	} 
 
	int getEnd() { 
		// TODO Auto-generated method stub 
		 
		return 0; 
	} 
		 
	 
 
	public int getBegin() { 
		// TODO Auto-generated method stub 
		return 0; 
	} 
 
	public Object getCoveredText() { 
		// TODO Auto-generated method stub 
		return null; 
	} 
} 
 