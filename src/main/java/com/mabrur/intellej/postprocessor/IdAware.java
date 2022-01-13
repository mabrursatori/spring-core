package com.mabrur.intellej.postprocessor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public interface IdAware {

    public void setId(String id);

    public String getId();
}
