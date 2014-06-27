package com.smartcodeltd.jenkinsci.plugins.buildmonitor.order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import hudson.model.AbstractProject;

import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.ParameterizedComparator;

/**
 * this sorter sorts items according to the order of the matching job names in the
 * comma separates list passed as {@link ByParameterList#setParameter(String)}
 */
public class ByParameterList implements Comparator<AbstractProject>, ParameterizedComparator {

    private String parameter;

    private transient ArrayList<String> orderList;

    @Override
    public int compare(AbstractProject a, AbstractProject b) {
        if(orderList == null) {
            initializeOrderList();
        }
        return orderList.indexOf(a.getName()) - orderList.indexOf(b.getName());
    }
    
    private void initializeOrderList() {
        orderList = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(this.parameter,",");
        while(tokenizer.hasMoreTokens()) {
            orderList.add(tokenizer.nextToken().trim());
        }
    }

    @Override
    public void setParameter(String param) {
        this.parameter = param;
    }

    @Override
    public String getParameter() {
        return this.parameter;
    }
}