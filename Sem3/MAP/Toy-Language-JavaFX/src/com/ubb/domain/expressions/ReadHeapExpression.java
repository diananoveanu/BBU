package com.ubb.domain.expressions;

import com.ubb.adt.dictionary.MyIDictionary;
import com.ubb.domain.exceptions.GenericException;
import com.ubb.domain.value.RefValue;
import com.ubb.domain.value.Value;

public class ReadHeapExpression implements Expression {
    private Expression exp;

    public ReadHeapExpression(Expression exp) {
        this.exp = exp;
    }

    @Override
    public Value evaluate(MyIDictionary<String, Value> tbl, MyIDictionary<Integer, Value> heap) throws GenericException {
        Value exprValue = exp.evaluate(tbl, heap);
        if (exprValue instanceof RefValue) {
            RefValue ref = (RefValue) exprValue;
            int address = ref.getAddress();
            if (heap.containsKey(address)) {
                return heap.get(address);
            } else {
                throw new GenericException("Address is not in heap!");
            }
        } else {
            throw new GenericException("Expression is not RefValue");
        }
    }

    @Override
    public String toString() {
        return "rH(" + exp.toString() + ")";
    }
}
