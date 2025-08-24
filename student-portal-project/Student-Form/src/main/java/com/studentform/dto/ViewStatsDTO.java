package com.studentform.dto;

public class ViewStatsDTO {
    private String source;
    private Long count;

    public ViewStatsDTO(String source, Long count) {
        this.source = source;
        this.count = count;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}
