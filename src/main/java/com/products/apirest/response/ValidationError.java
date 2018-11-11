package com.products.apirest.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationError extends ResourceError {

	private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String message, Date timeStamp) {
        super(status, message, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }
}
