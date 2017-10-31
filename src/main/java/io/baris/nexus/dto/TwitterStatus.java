package io.baris.nexus.dto;

import java.util.Objects;
public class TwitterStatus extends BaseDocument {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TwitterStatus that = (TwitterStatus) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TwitterStatus { ");
        sb.append(super.toString());
        sb.append("text='").append(text).append('\'');
        sb.append(" }");
        return sb.toString();
    }
}
