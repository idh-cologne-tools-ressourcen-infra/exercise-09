package de.ukoeln.idh.teaching.tri.ex09;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class NETagger extends org.apache.uima.fit.component.JCasAnnotator_ImplBase{
    @Override
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
        // iterate trough every token in a file after tokenization
        for (Token token : aJCas.select(Token.class)) {
            // if the first character is in uppercase
            // assign PER as a value to the newly created NamedEntity instance
            char check = (char)token.getText().codePointAt(0);
            if(Character.isUpperCase(check)){
                NamedEntity ne = new NamedEntity(aJCas);
                ne.setBegin(token.getBegin());
                ne.setEnd(token.getEnd());
                ne.setValue("PER");
                ne.addToIndexes();
            }
        }

    }
}
