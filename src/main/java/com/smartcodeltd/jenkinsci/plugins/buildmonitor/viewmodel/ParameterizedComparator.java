package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel;

/**
 * interface for {@link java.util.Comparator}s that support an parameter.
 *
 * when you are implementing this class, you also need to add the respective option value to the javascript
 * in the configure-entries.jelly in order to have the input field show up when selected.
 */
public interface ParameterizedComparator {
   void setParameter(String parameter);
   String getParameter();
}