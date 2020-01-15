package com.example.instagarmreplica.model;

public class Story {
    private String story_image;
    private String story_posted_by;

    public Story(String story_image, String story_posted_by) {
        this.story_image = story_image;
        this.story_posted_by = story_posted_by;
    }

    public String getStory_image() {
        return story_image;
    }

    public void setStory_image(String story_image) {
        this.story_image = story_image;
    }

    public String getStory_posted_by() {
        return story_posted_by;
    }

    public void setStory_posted_by(String story_posted_by) {
        this.story_posted_by = story_posted_by;
    }
}
