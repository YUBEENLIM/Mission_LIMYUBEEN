package com.ll;

class Quote {
    int id;
    String content;
    String authorName;

    public Quote(int id, String authorName, String content) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }
}


