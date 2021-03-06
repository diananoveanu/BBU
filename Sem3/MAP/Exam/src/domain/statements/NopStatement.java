package domain.statements;

import domain.ProgramState;
import domain.adt.dictionary.IDictionary;
import domain.adt.dictionary.MyDictionary;
import domain.exceptions.GenericException;
import domain.types.Type;

public class NopStatement implements IStatement {
    @Override
    public ProgramState execute(ProgramState state) throws GenericException {
        return null;
    }

    @Override
    public IDictionary<String, Type> typeCheck(IDictionary<String, Type> typeEnv) throws GenericException {
        return typeEnv;
    }

    @Override
    public String toString(){
        return "nop";
    }
}
