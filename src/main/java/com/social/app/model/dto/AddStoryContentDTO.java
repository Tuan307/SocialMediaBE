package com.social.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddStoryContentDTO {
    private List<String> contentUrl;
    private String type;
    private int storyId;
}
