package ru.geekbrains.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CatholicChurch {
    private String news;

    private PropertyChangeSupport support;

    public CatholicChurch() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setNews(String news) {
        support.firePropertyChange("news", this.news, news);
        this.news = news;
    }
}
