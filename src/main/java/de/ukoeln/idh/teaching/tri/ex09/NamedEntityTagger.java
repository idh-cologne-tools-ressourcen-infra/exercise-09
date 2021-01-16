package de.ukoeln.idh.teaching.tri.ex09; 
 
import org.apache.uima.analysis_engine.AnalysisEngineProcessException; 
import org.apache.uima.cas.SelectFSs; 
import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.tcas.Annotation; 
import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity; 
 
public class NamedEntityTagger extends org.apache.uima.fit.component.JCasAnnotator_ImplBase { 
 
	
	@Override
	public void process (JCas aJCas) throws AnalysisEngineProcessException { 
		
		SelectFSs<NamedEntity> selector = aJCas.select(NamedEntity.class); 
		
		
		
		for (NamedEntity PER: selector) { 
			
			if (PER.getCoveredText().equals("")) { 
				
				
				Annotation anno = new Annotation(aJCas); 
				anno.setBegin(PER.getBegin()); 
				anno.setEnd(PER.getEnd()); 
				anno.addToIndexes(); 
				
				
			} 
		} 
	} 
 
	int getEnd() { 
		// TODO Auto-generated method stub 
		 
		return 0; 
	} 
		 
 
	public Object getCoveredText() { 
		// TODO Auto-generated method stub 
		return null; 
	} 
	
	public int getBegin() { 
		// TODO Auto-generated method stub 
		return 0; 
	} 
} 